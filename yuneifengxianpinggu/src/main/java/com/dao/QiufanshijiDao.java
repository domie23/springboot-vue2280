package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.QiufanshijiEntity;
import com.entity.view.QiufanshijiView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 囚犯事迹 Dao 接口
 *
 * @author 
 */
public interface QiufanshijiDao extends BaseMapper<QiufanshijiEntity> {

   List<QiufanshijiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
