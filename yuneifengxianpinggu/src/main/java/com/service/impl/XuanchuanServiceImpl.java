package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.XuanchuanDao;
import com.entity.XuanchuanEntity;
import com.entity.view.XuanchuanView;
import com.service.XuanchuanService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 宣传 服务实现类
 */
@Service("xuanchuanService")
@Transactional
public class XuanchuanServiceImpl extends ServiceImpl<XuanchuanDao, XuanchuanEntity> implements XuanchuanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<XuanchuanView> page =new Query<XuanchuanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
