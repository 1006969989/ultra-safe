package com.ultrapower.project.system.sensitivebank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ultrapower.common.utils.poi.ExcelUtil;
import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.framework.aspectj.lang.annotation.Log;
import com.ultrapower.framework.aspectj.lang.enums.BusinessType;
import com.ultrapower.framework.web.controller.BaseController;
import com.ultrapower.framework.web.domain.AjaxResult;
import com.ultrapower.framework.web.page.TableDataInfo;
import com.ultrapower.project.system.dict.domain.DictData;
import com.ultrapower.project.system.dict.domain.DictType;
import com.ultrapower.project.system.dict.service.DictDataServiceImpl;
import com.ultrapower.project.system.dict.service.IDictDataService;
import com.ultrapower.project.system.physecsys.domain.PhySecSys;
import com.ultrapower.project.system.sign.domain.LettersSign;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ultrapower.project.system.sensitivebank.domain.SensitiveBank;
import com.ultrapower.project.system.sensitivebank.service.ISensitiveBankService;
import org.springframework.web.multipart.MultipartFile;


/**
 * 涉敏人员库Controller
 *
 * @author wangcong
 * @date 2020-06-07
 */
@Controller
@RequestMapping("/system/sensitivebank")
public class SensitiveBankController extends BaseController
{
    private String prefix = "system/sensitivebank";

    @Autowired
    private ISensitiveBankService sensitiveBankService;
    @Autowired
    private IDictDataService dictDataService;

    @RequiresPermissions("system:sensitivebank:view")
    @GetMapping()
    public String sensitivebank()
    {
        return prefix + "/sensitivebank";
    }

    /**
     * 查询涉敏人员库列表
     */
    @RequiresPermissions("system:sensitivebank:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SensitiveBank sensitiveBank)
    {
        startPage();
        List<SensitiveBank> list = sensitiveBankService.selectSensitiveBankList(sensitiveBank);
        return getDataTable(list);
    }

    /**
     * 导入物理安全情况列表
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<SensitiveBank> util = new ExcelUtil<SensitiveBank>(SensitiveBank.class);
        List<SensitiveBank> sensitiveBankList = util.importExcel(file.getInputStream());
        for(SensitiveBank sensitiveBank : sensitiveBankList){
            System.out.println(sensitiveBank.toString());
            //此处进行字典对照转换
            sensitiveBank=voToDto(sensitiveBank);
            sensitiveBank.setLogicdelete("0");
            sensitiveBankService.insertSensitiveBank(sensitiveBank);
        }
        return AjaxResult.success("导入成功");
    }
    /**
     * 导出涉敏人员库模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() throws Exception
    {
        ExcelUtil<SensitiveBank> util = new ExcelUtil<SensitiveBank>(SensitiveBank.class);
        return util.importTemplateExcel("涉敏人员库导入模板");
    }
    /**
     * 导出涉敏人员库列表
     */
    @RequiresPermissions("system:sensitivebank:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(String ids)
    {
        System.out.println(ids);
        String[] id= Convert.toStrArray(ids);
        List<SensitiveBank> list = new ArrayList<SensitiveBank>();
        for(int i=0;i<id.length;i++){
            list.add(dtoToVo(sensitiveBankService.selectSensitiveBankById(id[i])));
        }
        ExcelUtil<SensitiveBank> util = new ExcelUtil<SensitiveBank>(SensitiveBank.class);
        return util.exportExcel(list, "涉敏人员库");
    }

    /**
     * 新增涉敏人员库
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存涉敏人员库
     */
    @RequiresPermissions("system:sensitivebank:add")
    @Log(title = "涉敏人员库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SensitiveBank sensitiveBank)
    {
        sensitiveBank.setLogicdelete("0");
        return toAjax(sensitiveBankService.insertSensitiveBank(sensitiveBank));
    }

    /**
     * 修改涉敏人员库
     */
    @GetMapping("/edit/{uuid}")
    public String edit(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        SensitiveBank sensitiveBank = sensitiveBankService.selectSensitiveBankById(uuid);
        mmap.put("sensitiveBank", sensitiveBank);
        return prefix + "/edit";
    }

    /**
     * 修改保存涉敏人员库
     */
    @RequiresPermissions("system:sensitivebank:edit")
    @Log(title = "涉敏人员库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SensitiveBank sensitiveBank)
    {
        return toAjax(sensitiveBankService.updateSensitiveBank(sensitiveBank));
    }

    /**
     * 删除涉敏人员库
     */
    @RequiresPermissions("system:sensitivebank:remove")
    @Log(title = "涉敏人员库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        //逻辑删除
        String[] id= Convert.toStrArray(ids);
        SensitiveBank sensitiveBank=new SensitiveBank();
        sensitiveBank.setLogicdelete("1");
        int flag=1;
        for(int i=0;i<id.length;i++){
            sensitiveBank.setUuid(id[i]);
            if(sensitiveBankService.updateSensitiveBank(sensitiveBank)!=1){
                flag=0;
            }
        }
        return toAjax(flag);
    }

    /**
     * 打开详情页
     */
    @GetMapping("/detail/{uuid}")
    public String detail(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        SensitiveBank sensitiveBank = sensitiveBankService.selectSensitiveBankById(uuid);
        mmap.put("sensitiveBank", sensitiveBank);
        return prefix + "/detail";
    }
    //导出时所用字典对照
    public SensitiveBank dtoToVo(SensitiveBank sensitiveBank){
        List<DictData> dicList;
        //所属系统类型字典对照
        dicList=dictDataService.selectDictDataByType("system_type");
        String groupnametype=sensitiveBank.getGroupnametype();
        for (DictData dict:dicList){
            if(dict.getDictValue().equals(groupnametype)){
                sensitiveBank.setGroupnametype(dict.getDictLabel());
                break;
            }
        }
        //从账号类型字典对照
        dicList=dictDataService.selectDictDataByType("from_account_type");
        String authztype=sensitiveBank.getAuthztype();
        for (DictData dict:dicList){
            if(dict.getDictValue().equals(authztype)){
                sensitiveBank.setAuthztype(dict.getDictLabel());
                break;
            }
        }
        //操作权限对照
        dicList=dictDataService.selectDictDataByType("operation_permission");
        String[] operauthzs=sensitiveBank.getOperauthz().split(",");
        String realOperauthz="";
        for(int i=0;i<operauthzs.length;i++){
            for (DictData dict:dicList){
                if(dict.getDictValue().equals(operauthzs[i])){
                    realOperauthz+=dict.getDictLabel();
                    if(i!=operauthzs.length-1){
                        realOperauthz+=",";
                    }
                    break;
                }
            }
        }
        sensitiveBank.setOperauthz(realOperauthz);
        //涉敏权限内容对照
        dicList=dictDataService.selectDictDataByType("sensitive_content");
        String[] sensitiveauthzcontents=sensitiveBank.getSensitiveauthzcontent().split(",");
        String realContent="";
        for(int i=0;i<sensitiveauthzcontents.length;i++){
            for (DictData dict:dicList){
                if(dict.getDictValue().equals(sensitiveauthzcontents[i])){
                    realContent+=dict.getDictLabel();
                    if(i!=sensitiveauthzcontents.length-1){
                        realContent+=",";
                    }
                    break;
                }
            }
        }
        sensitiveBank.setSensitiveauthzcontent(realContent);
        return sensitiveBank;
    }

    //导入时的字典对照(本质是在导出的字典对照方法中 将getDictValue与getDictLabel互换)
    public SensitiveBank voToDto(SensitiveBank sensitiveBank){
        List<DictData> dicList;
        //所属系统类型字典对照
        dicList=dictDataService.selectDictDataByType("system_type");
        String groupnametype=sensitiveBank.getGroupnametype();
        for (DictData dict:dicList){
            if(dict.getDictLabel().equals(groupnametype)){
                sensitiveBank.setGroupnametype(dict.getDictValue());
                break;
            }
        }
        //从账号类型字典对照
        dicList=dictDataService.selectDictDataByType("from_account_type");
        String authztype=sensitiveBank.getAuthztype();
        for (DictData dict:dicList){
            if(dict.getDictLabel().equals(authztype)){
                sensitiveBank.setAuthztype(dict.getDictValue());
                break;
            }
        }
        //操作权限对照
        dicList=dictDataService.selectDictDataByType("operation_permission");
        String[] operauthzs=sensitiveBank.getOperauthz().split(",");
        String realOperauthz="";
        for(int i=0;i<operauthzs.length;i++){
            for (DictData dict:dicList){
                if(dict.getDictLabel().equals(operauthzs[i])){
                    realOperauthz+=dict.getDictValue();
                    if(i!=operauthzs.length-1){
                        realOperauthz+=",";
                    }
                    break;
                }
            }
        }
        sensitiveBank.setOperauthz(realOperauthz);
        //涉敏权限内容对照
        dicList=dictDataService.selectDictDataByType("sensitive_content");
        String[] sensitiveauthzcontents=sensitiveBank.getSensitiveauthzcontent().split(",");
        String realContent="";
        for(int i=0;i<sensitiveauthzcontents.length;i++){
            for (DictData dict:dicList){
                if(dict.getDictLabel().equals(sensitiveauthzcontents[i])){
                    realContent+=dict.getDictValue();
                    if(i!=sensitiveauthzcontents.length-1){
                        realContent+=",";
                    }
                    break;
                }
            }
        }
        sensitiveBank.setSensitiveauthzcontent(realContent);
        return sensitiveBank;
    }
}
