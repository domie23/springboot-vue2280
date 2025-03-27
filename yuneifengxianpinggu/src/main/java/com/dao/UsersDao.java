
package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.UsersEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户
 */
public interface UsersDao extends BaseMapper<UsersEntity> {
	
	List<UsersEntity> selectListView(@Param("ew") Wrapper<UsersEntity> wrapper);

	List<UsersEntity> selectListView(Pagination page, @Param("ew") Wrapper<UsersEntity> wrapper);
	
}
