package com.service.impl;

import com.bean.BaseDictEntity;
import com.bean.CstCustomerEntity;
import com.dao.BaseDictDao;
import com.dao.CustomerDao;
import com.service.CustomerService;
import com.web.commons.Page;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WJUN
 * @create 2018/10/25 13:50
 * 客户的业务层实现类
 */
@Service("customerService")
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class CustomerServiceImpl implements CustomerService {
    @Resource(name="customerDao")
    private CustomerDao customerDao;

    @Resource(name = "baseDictDao")
    private BaseDictDao baseDictDao;

    @Override
    public Page findAllCustomer(DetachedCriteria detachedCriteria, Integer num) {
        //准备当前页信息
        int currentPageNum = 1;
        if (num != null){
            currentPageNum = num;
        }
        //获取总记录条数
        int tatolRecords = customerDao.findTatolRecords(detachedCriteria);
        //创建一个page对象
        Page page = new Page(currentPageNum,tatolRecords);
        //使用page对象中的数据，查询带有分页的结果集
        List<CstCustomerEntity> records = customerDao.findAll(detachedCriteria,page.getStartIndex(),page.getPageSize());
        //把查询的结果集封装到page对象中
        page.setRecords(records);
        //返回page对象
        return page;
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void saveCustomer(CstCustomerEntity customerEntity) {
        customerDao.save(customerEntity);
    }

    @Override
    public List<BaseDictEntity> findAllCustomerSources() {
        return baseDictDao.findBaseDictTypeCode("002");
    }

    @Override
    public List<BaseDictEntity> findAllCustomerLevels() {
        return baseDictDao.findBaseDictTypeCode("006");
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void deleteCustomer(long custId) {
        customerDao.deleteCustomer(custId);
    }

    @Override
    public CstCustomerEntity findCustomerById(long custId) {
        return customerDao.findById(custId);
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void updateCustomer(CstCustomerEntity cstCustomerEntity) {
        customerDao.updateCutomer(cstCustomerEntity);
    }

    @Override
    public List<CstCustomerEntity> findAllCustomer() {
        return customerDao.findAll();
    }
}
