package com.service;

import com.bean.BaseDictEntity;
import com.bean.CstCustomerEntity;
import com.web.commons.Page;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 客户的业务层接口
 */
public interface CustomerService {
    /**
     * 查村客户列表
     * @param detachedCriteria 查询条件
     * @param num 当前页
     * @return  page 封装好的分页信息
     */
    Page findAllCustomer(DetachedCriteria detachedCriteria, Integer num);

    void saveCustomer(CstCustomerEntity customerEntity);

    List<BaseDictEntity> findAllCustomerSources();

    List<BaseDictEntity> findAllCustomerLevels();

    void deleteCustomer(long custId);

    CstCustomerEntity findCustomerById(long custId);

    void updateCustomer(CstCustomerEntity cstCustomerEntity);

    List<CstCustomerEntity> findAllCustomer();
}
