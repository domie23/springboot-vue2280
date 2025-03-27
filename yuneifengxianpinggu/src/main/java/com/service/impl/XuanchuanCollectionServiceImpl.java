package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.XuanchuanCollectionDao;
import com.entity.XuanchuanCollectionEntity;
import com.entity.view.XuanchuanCollectionView;
import com.service.XuanchuanCollectionService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 宣传收藏 服务实现类
 */
@Service("xuanchuanCollectionService")
@Transactional
public class XuanchuanCollectionServiceImpl extends ServiceImpl<XuanchuanCollectionDao, XuanchuanCollectionEntity> implements XuanchuanCollectionService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<XuanchuanCollectionView> page =new Query<XuanchuanCollectionView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
