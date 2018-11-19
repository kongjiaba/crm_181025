package com.dao;

import com.bean.BaseDictEntity;

import java.util.List;

/**
 * 字典表的持久层接口
 */
public interface BaseDictDao {
    /**
     * 根据字典类型查询字典表数据
     * @param typeCode
     * @return
     */
    List<BaseDictEntity> findBaseDictTypeCode(String typeCode);
}
