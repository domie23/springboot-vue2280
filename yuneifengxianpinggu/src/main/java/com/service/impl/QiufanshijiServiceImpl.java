package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.QiufanshijiDao;
import com.entity.QiufanshijiEntity;
import com.entity.view.QiufanshijiView;
import com.service.QiufanshijiService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 囚犯事迹 服务实现类
 */
@Service("qiufanshijiService")
@Transactional
public class QiufanshijiServiceImpl extends ServiceImpl<QiufanshijiDao, QiufanshijiEntity> implements QiufanshijiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<QiufanshijiView> page =new Query<QiufanshijiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
