package com.dao.impl;

import com.bean.CstLinkman;
import com.dao.LinkManDao;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 联系人持久层实现类
 * @author WJUN
 * @create 2018/10/27 0:23
 */
@Repository("linkManDao")
public class LinkManDaoImpl implements LinkManDao {
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    @Override
    public void add(CstLinkman linkman) {
        hibernateTemplate.save(linkman);
    }

    @Override
    public List<CstLinkman> findAll(DetachedCriteria detachedCriteria) {
        return (List<CstLinkman>) hibernateTemplate.findByCriteria(detachedCriteria);
    }

    @Override
    public void deleteLinkMan(Long lkmId) {
        hibernateTemplate.delete(findById(lkmId));
    }

    @Override
    public CstLinkman findById(Long lkmId) {
        return hibernateTemplate.get(CstLinkman.class,lkmId);
    }

    @Override
    public void update(CstLinkman linkman) {
        hibernateTemplate.update(linkman);
    }
}
