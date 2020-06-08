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
import com.ultrapower.project.system.dict.service.DictDataServiceImpl;
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
        /*通过下面这个方法便可以获取到字典的标签
        DictUtils.getDictLabel(dictType, dictValue, defaultValue)；
        其中
        dictType：为字典的名字
        dictValue：字典的值（你想要转化的当前字典的值）
        defaultValue：若dictValue在dictType中没有匹配到任何一个值的话 则显示defaultValue*/
        //DictDataServiceImpl
        System.out.println(ids);
        String[] id= Convert.toStrArray(ids);
        List<SensitiveBank> list = new ArrayList<SensitiveBank>();
        for(int i=0;i<id.length;i++){
            list.add(sensitiveBankService.selectSensitiveBankById(id[i]));
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
}
