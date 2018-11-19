package com.dao.impl;

import com.bean.CstCustomerEntity;
import com.dao.CustomerDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WJUN
 * @create 2018/10/25 13:58
 * 客户的持久层实现类
 */
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {
    @Resource(name="hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    @Override
    public int findTatolRecords(DetachedCriteria detachedCriteria) {
        detachedCriteria.setProjection(Projections.count("custId"));
        List<Long> list = (List<Long>) hibernateTemplate.findByCriteria(detachedCriteria);
        return list.isEmpty() ? 0 : list.get(0).intValue();
    }

    @Override
    public List<CstCustomerEntity> findAll(DetachedCriteria detachedCriteria,int firstResult,int maxResults) {
        //把之前的清除掉
        detachedCriteria.setProjection(null);
        return (List<CstCustomerEntity>) hibernateTemplate.findByCriteria(detachedCriteria,firstResult,maxResults);
    }

    @Override
    public void save(CstCustomerEntity customerEntity) {
        hibernateTemplate.save(customerEntity);
    }

    @Override
    public void deleteCustomer(long custId) {
        hibernateTemplate.delete(findById(custId));
    }

    @Override
    public CstCustomerEntity findById(long custId) {
        CstCustomerEntity cstCustomerEntity = hibernateTemplate.get(CstCustomerEntity.class,custId);
        return cstCustomerEntity;
    }

    @Override
    public void updateCutomer(CstCustomerEntity cstCustomerEntity) {
        hibernateTemplate.update(cstCustomerEntity);
    }

    @Override
    public List<CstCustomerEntity> findAll() {
        return (List<CstCustomerEntity>) hibernateTemplate.find("select new CstCustomerEntity(custId,custName) from CstCustomerEntity ");
    }
}
