package com.ultrapower.project.system.physecsys.controller;

import com.ultrapower.common.constant.Constants;
import com.ultrapower.common.utils.StringUtils;
import com.ultrapower.common.utils.file.FileUtils;
import com.ultrapower.common.utils.poi.ExcelUtil;
import com.ultrapower.common.utils.security.ShiroUtils;
import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.framework.aspectj.lang.annotation.Log;
import com.ultrapower.framework.aspectj.lang.enums.BusinessType;
import com.ultrapower.framework.config.RuoYiConfig;
import com.ultrapower.framework.web.controller.BaseController;
import com.ultrapower.framework.web.domain.AjaxResult;
import com.ultrapower.framework.web.page.TableDataInfo;
import com.ultrapower.project.system.physecannex.domain.Annex;
import com.ultrapower.project.system.physecannex.service.IAnnexService;
import com.ultrapower.project.system.physeccabinet.domain.Cabinet;
import com.ultrapower.project.system.physeccabinet.service.ICabinetService;
import com.ultrapower.project.system.physecsys.domain.PhySecSys;
import com.ultrapower.project.system.physecsys.service.IPhySecSysService;
import com.ultrapower.project.system.sensitivebank.domain.SensitiveBank;
import com.ultrapower.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 物理安全情况Controller
 *
 * @author ruoyi
 * @date 2020-05-25
 */
@Controller
@RequestMapping("/system/physecsys")
public class PhySecSysController extends BaseController
{
    private String prefix = "system/physecsys";

    @Autowired
    private IPhySecSysService phySecSysService;
    @Autowired
    private ICabinetService cabinetService;
    @Autowired
    private IAnnexService annexService;

    @RequiresPermissions("system:physecsys:view")
    @GetMapping()
    public String physecsys()
    {
        return prefix + "/physecsys";
    }

    /**
     * 查询物理安全情况列表
     */
    @RequiresPermissions("system:physecsys:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PhySecSys phySecSys)
    {
        //String systemname,String groupuuid,String createtime
        System.out.println(phySecSys);
        startPage();
        List<PhySecSys> list = phySecSysService.selectPhySecSysList(phySecSys);
        return getDataTable(list);
    }

    /**
     * 导入物理安全情况列表
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<PhySecSys> util = new ExcelUtil<PhySecSys>(PhySecSys.class);
        List<PhySecSys> phySecSysList = util.importExcel(file.getInputStream());
        for(PhySecSys phySecSys : phySecSysList){
            System.out.println(phySecSys.toString());
            phySecSys.setUuid(UUID.randomUUID().toString().replace("-", ""));
            phySecSys.setLogicdelete("0");
            //创建者  目前不知如何获取登录人id
            //phySecSys.getCreateuserid();
            //若后续不导入创建时间，则可用getNowDateToString()来获取当前时间并转化为String
            phySecSysService.insertPhySecSys(phySecSys);
        }
        return AjaxResult.success("导入成功");
    }
    /**
     * 导出物理安全情况模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() throws Exception
    {
        ExcelUtil<PhySecSys> util = new ExcelUtil<PhySecSys>(PhySecSys.class);
        //util.encodingFilename("物理安全情况导入模板");  好像失效了
        return util.importTemplateExcel("物理安全情况导入模板");
    }

    /**
     * 导出物理安全情况列表
     */
    @RequiresPermissions("system:physecsys:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(String ids)
    {
        String[] id= Convert.toStrArray(ids);
        List<PhySecSys> list = new ArrayList<PhySecSys>();
        for(int i=0;i<id.length;i++){
            list.add(phySecSysService.selectPhySecSysById(id[i]));
        }
        ExcelUtil<PhySecSys> util = new ExcelUtil<PhySecSys>(PhySecSys.class);
        return util.exportExcel(list, "物理安全情况");
    }

    /**
     * 新增物理安全情况
     */
    @GetMapping("/add")
    public String add()
    {
        //此处注意删去全部systemuuid为linshi的机柜信息和附件信息
        Annex annex=new Annex();
        annex.setSystemuuid("linshi");
        List<Annex> annexList=annexService.selectAnnexList(annex);
        try {
            String idstr=annexList.get(0).getUuid();
            for(int i=1;i<annexList.size();i++){
                idstr=idstr+","+annexList.get(i).getUuid();
            }
            //准备附件的ids
            String[] ids= Convert.toStrArray(idstr);
            //删除文件
            String localPath = RuoYiConfig.getProfile();
            String downloadPath;
            for(int i=0;i<ids.length;i++){
                annex=annexService.selectAnnexById(ids[i]);
                // 数据库资源地址
                downloadPath = localPath + StringUtils.substringAfter(annex.getFtppath(), Constants.RESOURCE_PREFIX);
                FileUtils.deleteFile(downloadPath);
            }
            //System.out.println("文件删除完毕");
        }catch(Exception e) {
            //System.out.println("无临时文件");
        }
        //注意还要删除文件！

        //删除数据库信息
        cabinetService.deleteCabinetBySystemUuid("linshi");
        annexService.deleteAnnexBySystemUuid("linshi");
        return prefix + "/add";
    }

    /**
     * 新增保存物理安全情况
     */
    @RequiresPermissions("system:physecsys:add")
    @Log(title = "物理安全情况", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PhySecSys phySecSys)
    {
        //这里弃用sequence，改为UUID
        String uuid=UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        phySecSys.setUuid(uuid);
        //getNowDateToString()用于获取当前时间并转化为String
        phySecSys.setCreatetime(new Date());
        phySecSys.setLogicdelete("0");
        //关于创建者id的获取插入
        //ShiroUtils.getSysUser().getUserId();
        int tag=phySecSysService.insertPhySecSys(phySecSys);
        if(tag==1){
            //此处修改全部systemuuid为linshi的机柜信息和附件信息  将其systemuuid设定为刚才获取的值
            cabinetService.updateCabinetToSys(phySecSys.getUuid());
            annexService.updateAnnexToSys(phySecSys.getUuid());
        }
        return toAjax(tag);
    }

    /**
     * 修改物理安全情况
     */
    @GetMapping("/edit/{uuid}")
    public String edit(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        PhySecSys phySecSys = phySecSysService.selectPhySecSysById(uuid);
        mmap.put("phySecSys", phySecSys);
        return prefix + "/edit";
    }

    /**
     * 修改保存物理安全情况
     */
    @RequiresPermissions("system:physecsys:edit")
    @Log(title = "物理安全情况", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PhySecSys phySecSys)
    {
        phySecSys.setModifytime(new Date());
        return toAjax(phySecSysService.updatePhySecSys(phySecSys));
    }

    /**
     * 删除物理安全情况
     */
    @RequiresPermissions("system:physecsys:remove")
    @Log(title = "物理安全情况", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        //逻辑删除
        String[] id= Convert.toStrArray(ids);
        PhySecSys phySecSys=new PhySecSys();
        phySecSys.setLogicdelete("1");
        int flag=1;
        for(int i=0;i<id.length;i++){
            phySecSys.setUuid(id[i]);
            if(phySecSysService.updatePhySecSys(phySecSys)!=1){
                flag=0;
            }
        }
        return toAjax(flag);
    }


    //打开机柜维护页面
    @GetMapping("/showCabinet/{uuid}")
    public String showCabinet(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        PhySecSys phySecSys = phySecSysService.selectPhySecSysById(uuid);
        mmap.put("phySecSys", phySecSys);
        return "system/physecsys" + "/physeccabinet";
    }
    /**
     * 打开详情页
     */
    @GetMapping("/detail/{uuid}")
    public String detail(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        PhySecSys phySecSys = phySecSysService.selectPhySecSysById(uuid);
        mmap.put("phySecSys", phySecSys);
        return prefix + "/detail";
    }


    //工具方法，获取时间并转为String
    /*public String getNowDateToString(){
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        return sdf.format(date);
    }*/
}
