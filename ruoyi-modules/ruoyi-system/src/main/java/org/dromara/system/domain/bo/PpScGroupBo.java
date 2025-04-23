package org.dromara.system.domain.bo;

import org.dromara.system.domain.PpScGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 素材分组业务对象 pp_sc_group
 *
 * @author Pp
 * @date 2025-04-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = PpScGroup.class, reverseConvertGenerate = false)
public class PpScGroupBo extends BaseEntity {

    /**
     * 
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 分组名称
     */
    @NotBlank(message = "分组名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String groupName;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 祖级列表
     */
    private String ancestors;

    /**
     * 类型列表
     */
    private String typeList;


}
