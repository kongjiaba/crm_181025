package com.service;

import com.bean.CstLinkman;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 联系人的业务层接口
 */
public interface LinkManService {
    void addLinkMan(CstLinkman linkman);

    List<CstLinkman> findAllLinkMan(DetachedCriteria detachedCriteria);

    void deleteLinkMan(Long lkmId);

    CstLinkman findLinkManById(Long lkmId);

    void updateLinkMan(CstLinkman linkman);
}
