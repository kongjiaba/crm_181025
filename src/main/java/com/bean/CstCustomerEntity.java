package com.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author WJUN
 * @create 2018/10/25 13:21
 */
@Entity
@Table(name = "cst_customer", schema = "costomer", catalog = "")
public class CstCustomerEntity implements Serializable {
    @Id
    @Column(name = "cust_id")
    private long custId;
    @Column(name = "cust_name")
    private String custName;
//    private String custSource;
    @Column(name = "cust_industry")
    private String custIndustry;
//    private String custLevel;
    @Column(name = "cust_address")
    private String custAddress;
    @Column(name = "cust_phone")
    private String custPhone;

    public CstCustomerEntity() {
    }
    public CstCustomerEntity(long custId, String custName) {
        this.custId = custId;
        this.custName = custName;
    }

    //多对一关系映射；多个客户可以是一个来源
    @ManyToOne(targetEntity = BaseDictEntity.class)
    @JoinColumn(name = "cust_source",referencedColumnName = "dict_id")
    private BaseDictEntity custSource;

//    多对一关系映射，多个用户可以是同一个级别
    @ManyToOne(targetEntity = BaseDictEntity.class)
    @JoinColumn(name = "cust_level",referencedColumnName = "dict_id")
    private BaseDictEntity custLevel;

    //一对多映射关系：一个客户可以有多个联系人
    @OneToMany(mappedBy = "customerEntity")
    private Set<CstLinkman> linkmans = new HashSet<>();

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }


    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

//    @Basic
//    @Column(name = "cust_source")
//    public String getCustSource() {
//        return custSource;
//    }
//
//    public void setCustSource(String custSource) {
//        this.custSource = custSource;
//    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

//    @Basic
//    @Column(name = "cust_level")
//    public String getCustLevel() {
//        return custLevel;
//    }
//
//    public void setCustLevel(String custLevel) {
//        this.custLevel = custLevel;
//    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public BaseDictEntity getCustSource() {
        return custSource;
    }

    public void setCustSource(BaseDictEntity custSource) {
        this.custSource = custSource;
    }

    public BaseDictEntity getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(BaseDictEntity custLevel) {
        this.custLevel = custLevel;
    }

    public Set<CstLinkman> getLinkmans() {
        return linkmans;
    }

    public void setLinkmans(Set<CstLinkman> linkmans) {
        this.linkmans = linkmans;
    }

    @Override
    public String toString() {
        return "CstCustomerEntity{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }
}
