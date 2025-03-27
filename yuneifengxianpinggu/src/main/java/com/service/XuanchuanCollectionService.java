package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.XuanchuanCollectionEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 宣传收藏 服务类
 */
public interface XuanchuanCollectionService extends IService<XuanchuanCollectionEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}