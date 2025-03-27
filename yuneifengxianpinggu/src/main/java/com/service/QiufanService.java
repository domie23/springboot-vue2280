package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.QiufanEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 囚犯 服务类
 */
public interface QiufanService extends IService<QiufanEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}