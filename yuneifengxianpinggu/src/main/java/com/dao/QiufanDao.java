package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.QiufanEntity;
import com.entity.view.QiufanView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 囚犯 Dao 接口
 *
 * @author 
 */
public interface QiufanDao extends BaseMapper<QiufanEntity> {

   List<QiufanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
