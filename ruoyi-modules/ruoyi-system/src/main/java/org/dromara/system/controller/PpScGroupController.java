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
import org.dromara.system.domain.vo.PpScGroupVo;
import org.dromara.system.domain.bo.PpScGroupBo;
import org.dromara.system.service.IPpScGroupService;

/**
 * 素材分组
 *
 * @author Pp
 * @date 2025-04-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/scGroup")
public class PpScGroupController extends BaseController {

    private final IPpScGroupService ppScGroupService;

    /**
     * 查询素材分组列表
     */
    @SaCheckPermission("system:scGroup:list")
    @GetMapping("/list")
    public R<List<PpScGroupVo>> list(PpScGroupBo bo) {
        List<PpScGroupVo> list = ppScGroupService.queryList(bo);
        return R.ok(list);
    }

    /**
     * 导出素材分组列表
     */
    @SaCheckPermission("system:scGroup:export")
    @Log(title = "素材分组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(PpScGroupBo bo, HttpServletResponse response) {
        List<PpScGroupVo> list = ppScGroupService.queryList(bo);
        ExcelUtil.exportExcel(list, "素材分组", PpScGroupVo.class, response);
    }

    /**
     * 获取素材分组详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:scGroup:query")
    @GetMapping("/{id}")
    public R<PpScGroupVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(ppScGroupService.queryById(id));
    }

    /**
     * 新增素材分组
     */
    @SaCheckPermission("system:scGroup:add")
    @Log(title = "素材分组", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody PpScGroupBo bo) {
        return toAjax(ppScGroupService.insertByBo(bo));
    }

    /**
     * 修改素材分组
     */
    @SaCheckPermission("system:scGroup:edit")
    @Log(title = "素材分组", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody PpScGroupBo bo) {
        return toAjax(ppScGroupService.updateByBo(bo));
    }

    /**
     * 删除素材分组
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:scGroup:remove")
    @Log(title = "素材分组", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(ppScGroupService.deleteWithValidByIds(List.of(ids), true));
    }
}
