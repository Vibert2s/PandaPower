package org.dromara.system.domain.bo;

import org.dromara.system.domain.PpSourceMaterial;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 素材库业务对象 pp_source_material
 *
 * @author Pp
 * @date 2025-04-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = PpSourceMaterial.class, reverseConvertGenerate = false)
public class PpSourceMaterialBo extends BaseEntity {

    /**
     * 
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 分组id
     */
    private Long groupId;

    /**
     * 文件id
     */
    private Long oosId;

    /**
     * 原数据
     */
    private String originalData;

    /**
     * 类型
     */
    private String type;

    /**
     * 状态
     */
    private String status;


}
