package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 素材库对象 pp_source_material
 *
 * @author Pp
 * @date 2025-04-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pp_source_material")
public class PpSourceMaterial extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 分组id
     */
    private Long groupId;

    /**
     * 文件id
     */
    private Long ossId;

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
