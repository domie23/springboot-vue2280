package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.YujingEntity;
import com.entity.view.YujingView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 狱警 Dao 接口
 *
 * @author 
 */
public interface YujingDao extends BaseMapper<YujingEntity> {

   List<YujingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
