package com.service.impl;

import com.bean.CstLinkman;
import com.dao.LinkManDao;
import com.service.LinkManService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 联系人的业务层实现类
 * @author WJUN
 * @create 2018/10/27 0:21
 */
@Service("linkManService")
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class LinkManServiceImpl implements LinkManService {
    @Resource(name = "linkManDao")
    private LinkManDao linkManDao;

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void addLinkMan(CstLinkman linkman) {
        linkManDao.add(linkman);
    }

    @Override
    public List<CstLinkman> findAllLinkMan(DetachedCriteria detachedCriteria) {
        return linkManDao.findAll(detachedCriteria);
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void deleteLinkMan(Long lkmId) {
        linkManDao.deleteLinkMan(lkmId);
    }

    @Override
    public CstLinkman findLinkManById(Long lkmId) {
        return linkManDao.findById(lkmId);
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void updateLinkMan(CstLinkman linkman) {
        linkManDao.update(linkman);
    }
}
