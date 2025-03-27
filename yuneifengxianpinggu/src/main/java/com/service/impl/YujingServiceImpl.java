package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.YujingDao;
import com.entity.YujingEntity;
import com.entity.view.YujingView;
import com.service.YujingService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 狱警 服务实现类
 */
@Service("yujingService")
@Transactional
public class YujingServiceImpl extends ServiceImpl<YujingDao, YujingEntity> implements YujingService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<YujingView> page =new Query<YujingView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
