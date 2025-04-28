package org.dromara.system.service;

import cn.hutool.core.lang.tree.Tree;
import org.dromara.system.domain.vo.PpScGroupVo;
import org.dromara.system.domain.bo.PpScGroupBo;
import org.dromara.system.domain.vo.SysDeptVo;

import java.util.Collection;
import java.util.List;

/**
 * 素材分组Service接口
 *
 * @author Pp
 * @date 2025-04-23
 */
public interface IPpScGroupService {

    /**
     * 查询素材分组
     *
     * @param id 主键
     * @return 素材分组
     */
    PpScGroupVo queryById(Long id);


    /**
     * 查询符合条件的素材分组列表
     *
     * @param bo 查询条件
     * @return 素材分组列表
     */
    List<PpScGroupVo> queryList(PpScGroupBo bo);
    List<Tree<Long>> selectScGroupTreeList(PpScGroupBo bo);
    List<Tree<Long>> buildDeptTreeSelect(List<PpScGroupVo> groups);
    /**
     * 新增素材分组
     *
     * @param bo 素材分组
     * @return 是否新增成功
     */
    Boolean insertByBo(PpScGroupBo bo);

    /**
     * 修改素材分组
     *
     * @param bo 素材分组
     * @return 是否修改成功
     */
    Boolean updateByBo(PpScGroupBo bo);

    /**
     * 校验并批量删除素材分组信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);



}
