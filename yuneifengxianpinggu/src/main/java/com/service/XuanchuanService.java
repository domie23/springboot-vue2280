package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.XuanchuanEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 宣传 服务类
 */
public interface XuanchuanService extends IService<XuanchuanEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}