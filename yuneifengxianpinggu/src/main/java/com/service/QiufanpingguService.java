package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.QiufanpingguEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 囚犯评估 服务类
 */
public interface QiufanpingguService extends IService<QiufanpingguEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}