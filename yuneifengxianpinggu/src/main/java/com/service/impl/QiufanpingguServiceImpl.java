package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.QiufanpingguDao;
import com.entity.QiufanpingguEntity;
import com.entity.view.QiufanpingguView;
import com.service.QiufanpingguService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 囚犯评估 服务实现类
 */
@Service("qiufanpingguService")
@Transactional
public class QiufanpingguServiceImpl extends ServiceImpl<QiufanpingguDao, QiufanpingguEntity> implements QiufanpingguService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<QiufanpingguView> page =new Query<QiufanpingguView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
