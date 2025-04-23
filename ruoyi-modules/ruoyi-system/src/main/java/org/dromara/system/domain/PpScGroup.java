package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 素材分组对象 pp_sc_group
 *
 * @author Pp
 * @date 2025-04-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pp_sc_group")
public class PpScGroup extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 分组名称
     */
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
