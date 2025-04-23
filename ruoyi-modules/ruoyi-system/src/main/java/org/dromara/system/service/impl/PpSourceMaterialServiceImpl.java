package org.dromara.system.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.dromara.system.domain.bo.PpSourceMaterialBo;
import org.dromara.system.domain.vo.PpSourceMaterialVo;
import org.dromara.system.domain.PpSourceMaterial;
import org.dromara.system.mapper.PpSourceMaterialMapper;
import org.dromara.system.service.IPpSourceMaterialService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 素材库Service业务层处理
 *
 * @author Pp
 * @date 2025-04-23
 */
@RequiredArgsConstructor
@Service
public class PpSourceMaterialServiceImpl implements IPpSourceMaterialService {

    private final PpSourceMaterialMapper baseMapper;

    /**
     * 查询素材库
     *
     * @param id 主键
     * @return 素材库
     */
    @Override
    public PpSourceMaterialVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询素材库列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 素材库分页列表
     */
    @Override
    public TableDataInfo<PpSourceMaterialVo> queryPageList(PpSourceMaterialBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<PpSourceMaterial> lqw = buildQueryWrapper(bo);
        Page<PpSourceMaterialVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的素材库列表
     *
     * @param bo 查询条件
     * @return 素材库列表
     */
    @Override
    public List<PpSourceMaterialVo> queryList(PpSourceMaterialBo bo) {
        LambdaQueryWrapper<PpSourceMaterial> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<PpSourceMaterial> buildQueryWrapper(PpSourceMaterialBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<PpSourceMaterial> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(PpSourceMaterial::getId);
        lqw.eq(bo.getGroupId() != null, PpSourceMaterial::getGroupId, bo.getGroupId());
        lqw.eq(StringUtils.isNotBlank(bo.getOriginalData()), PpSourceMaterial::getOriginalData, bo.getOriginalData());
        lqw.eq(StringUtils.isNotBlank(bo.getType()), PpSourceMaterial::getType, bo.getType());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), PpSourceMaterial::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增素材库
     *
     * @param bo 素材库
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(PpSourceMaterialBo bo) {
        PpSourceMaterial add = MapstructUtils.convert(bo, PpSourceMaterial.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改素材库
     *
     * @param bo 素材库
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(PpSourceMaterialBo bo) {
        PpSourceMaterial update = MapstructUtils.convert(bo, PpSourceMaterial.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(PpSourceMaterial entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除素材库信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
