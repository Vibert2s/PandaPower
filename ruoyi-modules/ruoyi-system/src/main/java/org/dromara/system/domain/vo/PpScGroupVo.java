package org.dromara.system.domain.vo;

import org.dromara.system.domain.PpScGroup;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 素材分组视图对象 pp_sc_group
 *
 * @author Pp
 * @date 2025-04-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = PpScGroup.class)
public class PpScGroupVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 分组名称
     */
    @ExcelProperty(value = "分组名称")
    private String groupName;

    /**
     * 父级id
     */
    @ExcelProperty(value = "父级id")
    private Long parentId;

    /**
     * 祖级列表
     */
    @ExcelProperty(value = "祖级列表")
    private String ancestors;

    /**
     * 类型列表
     */
    @ExcelProperty(value = "类型列表")
    private String typeList;


}
