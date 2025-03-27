package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.XuanchuanEntity;
import com.entity.view.XuanchuanView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 宣传 Dao 接口
 *
 * @author 
 */
public interface XuanchuanDao extends BaseMapper<XuanchuanEntity> {

   List<XuanchuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
