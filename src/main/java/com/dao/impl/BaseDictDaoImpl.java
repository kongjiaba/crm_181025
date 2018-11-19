package com.dao.impl;

import com.bean.BaseDictEntity;
import com.dao.BaseDictDao;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 字典表的持久层实现类
 * @author WJUN
 * @create 2018/10/25 20:47
 */
@Repository("baseDictDao")
public class BaseDictDaoImpl implements BaseDictDao {
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    @Override
    public List<BaseDictEntity> findBaseDictTypeCode(String typeCode) {
        return (List<BaseDictEntity>) hibernateTemplate.find("from BaseDictEntity where dictTypeCode = ?",typeCode);
    }
}
