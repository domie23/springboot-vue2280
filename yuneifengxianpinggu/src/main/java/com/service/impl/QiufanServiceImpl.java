package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.QiufanDao;
import com.entity.QiufanEntity;
import com.entity.view.QiufanView;
import com.service.QiufanService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 囚犯 服务实现类
 */
@Service("qiufanService")
@Transactional
public class QiufanServiceImpl extends ServiceImpl<QiufanDao, QiufanEntity> implements QiufanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<QiufanView> page =new Query<QiufanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
