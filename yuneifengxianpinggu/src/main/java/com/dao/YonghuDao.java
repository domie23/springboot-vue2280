package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.YonghuEntity;
import com.entity.view.YonghuView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户 Dao 接口
 *
 * @author 
 */
public interface YonghuDao extends BaseMapper<YonghuEntity> {

   List<YonghuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
