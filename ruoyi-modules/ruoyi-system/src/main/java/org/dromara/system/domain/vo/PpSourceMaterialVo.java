package org.dromara.system.domain.vo;

import org.dromara.system.domain.PpSourceMaterial;
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
 * 素材库视图对象 pp_source_material
 *
 * @author Pp
 * @date 2025-04-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = PpSourceMaterial.class)
public class PpSourceMaterialVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 分组id
     */
    @ExcelProperty(value = "分组id")
    private Long groupId;

    /**
     * 原数据
     */
    @ExcelProperty(value = "原数据")
    private String originalData;

    @ExcelProperty(value = "文件ID")
    private String ossId;

    /**
     * 类型
     */
    @ExcelProperty(value = "类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sc_type")
    private String type;

    /**
     * 状态
     */
    @ExcelProperty(value = "状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_normal_disable")
    private String status;
    @ExcelProperty(value = "创建时间")
    private Date createTime;

}
