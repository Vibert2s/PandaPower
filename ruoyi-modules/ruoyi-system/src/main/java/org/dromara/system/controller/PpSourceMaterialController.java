package org.dromara.system.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.system.domain.vo.PpSourceMaterialVo;
import org.dromara.system.domain.bo.PpSourceMaterialBo;
import org.dromara.system.service.IPpSourceMaterialService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 素材库
 *
 * @author Pp
 * @date 2025-04-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/sourceMaterial")
public class PpSourceMaterialController extends BaseController {

    private final IPpSourceMaterialService ppSourceMaterialService;

    /**
     * 查询素材库列表
     */
    @SaCheckPermission("system:sourceMaterial:list")
    @GetMapping("/list")
    public TableDataInfo<PpSourceMaterialVo> list(PpSourceMaterialBo bo, PageQuery pageQuery) {
        return ppSourceMaterialService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出素材库列表
     */
    @SaCheckPermission("system:sourceMaterial:export")
    @Log(title = "素材库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(PpSourceMaterialBo bo, HttpServletResponse response) {
        List<PpSourceMaterialVo> list = ppSourceMaterialService.queryList(bo);
        ExcelUtil.exportExcel(list, "素材库", PpSourceMaterialVo.class, response);
    }

    /**
     * 获取素材库详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:sourceMaterial:query")
    @GetMapping("/{id}")
    public R<PpSourceMaterialVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(ppSourceMaterialService.queryById(id));
    }

    /**
     * 新增素材库
     */
    @SaCheckPermission("system:sourceMaterial:add")
    @Log(title = "素材库", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody PpSourceMaterialBo bo) {
        return toAjax(ppSourceMaterialService.insertByBo(bo));
    }

    /**
     * 修改素材库
     */
    @SaCheckPermission("system:sourceMaterial:edit")
    @Log(title = "素材库", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody PpSourceMaterialBo bo) {
        return toAjax(ppSourceMaterialService.updateByBo(bo));
    }

    /**
     * 删除素材库
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:sourceMaterial:remove")
    @Log(title = "素材库", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(ppSourceMaterialService.deleteWithValidByIds(List.of(ids), true));
    }
}
