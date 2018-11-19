package com.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author WJUN
 * @create 2018/10/25 19:55
 */
@Entity
@Table(name = "base_dict", schema = "costomer", catalog = "")
public class BaseDictEntity implements Serializable {
    @Id
    @Column(name = "dict_id", nullable = false, length = 32)
    private String dictId;
    @Column(name = "dict_type_code", nullable = false, length = 10)
    private String dictTypeCode;
    @Column(name = "dict_type_name", nullable = false, length = 64)
    private String dictTypeName;
    @Column(name = "dict_item_code", nullable = true, length = 10)
    private String dictItemCode;
    @Column(name = "dict_item_name", nullable = false, length = 64)
    private String dictItemName;
    @Column(name = "dict_sort", nullable = true)
    private Integer dictSort;
    @Column(name = "dict_enable", nullable = false, length = 1)
    private String dictEnable;
    @Column(name = "dict_memo", nullable = true, length = 64)
    private String dictMemo;

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode;
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName;
    }

    public String getDictItemCode() {
        return dictItemCode;
    }

    public void setDictItemCode(String dictItemCode) {
        this.dictItemCode = dictItemCode;
    }

    public String getDictItemName() {
        return dictItemName;
    }

    public void setDictItemName(String dictItemName) {
        this.dictItemName = dictItemName;
    }

    public Integer getDictSort() {
        return dictSort;
    }

    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    public String getDictEnable() {
        return dictEnable;
    }

    public void setDictEnable(String dictEnable) {
        this.dictEnable = dictEnable;
    }

    public String getDictMemo() {
        return dictMemo;
    }

    public void setDictMemo(String dictMemo) {
        this.dictMemo = dictMemo;
    }

    @Override
    public String toString() {
        return "BaseDictEntity{" +
                "dictId='" + dictId + '\'' +
                ", dictTypeCode='" + dictTypeCode + '\'' +
                ", dictTypeName='" + dictTypeName + '\'' +
                ", dictItemCode='" + dictItemCode + '\'' +
                ", dictItemName='" + dictItemName + '\'' +
                ", dictSort=" + dictSort +
                ", dictEnable='" + dictEnable + '\'' +
                ", dictMemo='" + dictMemo + '\'' +
                '}';
    }
}
