package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.XuanchuanCollectionEntity;
import com.entity.view.XuanchuanCollectionView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 宣传收藏 Dao 接口
 *
 * @author 
 */
public interface XuanchuanCollectionDao extends BaseMapper<XuanchuanCollectionEntity> {

   List<XuanchuanCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
