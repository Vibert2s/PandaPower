package org.dromara.system.service;

import org.dromara.system.domain.vo.PpSourceMaterialVo;
import org.dromara.system.domain.bo.PpSourceMaterialBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 素材库Service接口
 *
 * @author Pp
 * @date 2025-04-23
 */
public interface IPpSourceMaterialService {

    /**
     * 查询素材库
     *
     * @param id 主键
     * @return 素材库
     */
    PpSourceMaterialVo queryById(Long id);

    /**
     * 分页查询素材库列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 素材库分页列表
     */
    TableDataInfo<PpSourceMaterialVo> queryPageList(PpSourceMaterialBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的素材库列表
     *
     * @param bo 查询条件
     * @return 素材库列表
     */
    List<PpSourceMaterialVo> queryList(PpSourceMaterialBo bo);

    /**
     * 新增素材库
     *
     * @param bo 素材库
     * @return 是否新增成功
     */
    Boolean insertByBo(PpSourceMaterialBo bo);

    /**
     * 修改素材库
     *
     * @param bo 素材库
     * @return 是否修改成功
     */
    Boolean updateByBo(PpSourceMaterialBo bo);

    /**
     * 校验并批量删除素材库信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
    int updateScStatus(Long id, String status);
}
