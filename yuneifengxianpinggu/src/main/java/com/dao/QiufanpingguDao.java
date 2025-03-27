package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.QiufanpingguEntity;
import com.entity.view.QiufanpingguView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 囚犯评估 Dao 接口
 *
 * @author 
 */
public interface QiufanpingguDao extends BaseMapper<QiufanpingguEntity> {

   List<QiufanpingguView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
