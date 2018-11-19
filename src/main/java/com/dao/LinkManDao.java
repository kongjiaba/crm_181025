package com.dao;

import com.bean.CstLinkman;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 联系人持久层接口类
 */
public interface LinkManDao {
    /**
     * 添加联系人
     * @param linkman
     */
    void add(CstLinkman linkman);

    /**
     * 查询所有联系人
     * @param detachedCriteria
     * @return
     */
    List<CstLinkman> findAll(DetachedCriteria detachedCriteria);

    /**
     * 通过L=lkmId删除联系人
     * @param lkmId
     */
    void deleteLinkMan(Long lkmId);

    /**
     * 通过id查询联系人
     * @param lkmId
     * @return
     */
    CstLinkman findById(Long lkmId);

    /**
     * 修改联系人
     * @param linkman
     */
    void update(CstLinkman linkman);
}
