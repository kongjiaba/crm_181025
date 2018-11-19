package com.dao;

import com.bean.CstCustomerEntity;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 客户的持久层接口
 */
public interface CustomerDao {
    /**
     * 查询总记录条数
     * @param detachedCriteria 查询的条件
     * @return
     */
    int findTatolRecords(DetachedCriteria detachedCriteria);

    /**
     * 查询客户列表
     * @param detachedCriteria 查询的条件
     * @param firstResult      查询的开始记录索引
     * @param maxResults         每次查询的记录条数
     * @return
     */
    List<CstCustomerEntity> findAll(DetachedCriteria detachedCriteria,int firstResult,int maxResults);

    /**
     * 保存客户
     * @param customerEntity
     */
    void save(CstCustomerEntity customerEntity);

    /**
     * 格局id删除客户
     * @param custId
     */
    void deleteCustomer(long custId);

    /**
     * 根据id查询客户
     * @param custId
     * @return
     */
    CstCustomerEntity findById(long custId);

    /**
     * 修改客户
     * @param cstCustomerEntity
     */
    void updateCutomer(CstCustomerEntity cstCustomerEntity);

    /**
     * 使用投影查询的方式查询所有客户
     * @return
     */
    List<CstCustomerEntity> findAll();
}
