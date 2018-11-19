package com.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 联系人实体类
 * @author WJUN
 * @create 2018/10/26 22:05
 */
@Entity
@Table(name = "cst_linkman")
public class CstLinkman implements Serializable {
    private Long lkmId;
    private String lkmName;
    private String lkmGender;
    private String lkmPhone;
    private String lkmMobile;
    private String lkmEmail;
    private String lkmPosition;
    private String lkmMemo;
    //多对一关系映射：多个联系人可以是一个客户
    private CstCustomerEntity customerEntity;

    @Id
    @Column(name = "lkm_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getLkmId() {
        return lkmId;
    }

    public void setLkmId(Long lkmId) {
        this.lkmId = lkmId;
    }

    @Basic
    @Column(name = "lkm_name", nullable = true, length = 16)
    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    @Basic
    @Column(name = "lkm_gender", nullable = true, length = 1)
    public String getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(String lkmGender) {
        this.lkmGender = lkmGender;
    }

    @Basic
    @Column(name = "lkm_phone", nullable = true, length = 16)
    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone;
    }

    @Basic
    @Column(name = "lkm_mobile", nullable = true, length = 16)
    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile;
    }

    @Basic
    @Column(name = "lkm_email", nullable = true, length = 64)
    public String getLkmEmail() {
        return lkmEmail;
    }

    public void setLkmEmail(String lkmEmail) {
        this.lkmEmail = lkmEmail;
    }

    @Basic
    @Column(name = "lkm_position", nullable = true, length = 16)
    public String getLkmPosition() {
        return lkmPosition;
    }

    public void setLkmPosition(String lkmPosition) {
        this.lkmPosition = lkmPosition;
    }

    @Basic
    @Column(name = "lkm_memo", nullable = true, length = 512)
    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo;
    }

    @ManyToOne
    @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")
    public CstCustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CstCustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CstLinkman that = (CstLinkman) o;

        if (lkmId != null ? !lkmId.equals(that.lkmId) : that.lkmId != null) return false;
        if (lkmName != null ? !lkmName.equals(that.lkmName) : that.lkmName != null) return false;
        if (lkmGender != null ? !lkmGender.equals(that.lkmGender) : that.lkmGender != null) return false;
        if (lkmPhone != null ? !lkmPhone.equals(that.lkmPhone) : that.lkmPhone != null) return false;
        if (lkmMobile != null ? !lkmMobile.equals(that.lkmMobile) : that.lkmMobile != null) return false;
        if (lkmEmail != null ? !lkmEmail.equals(that.lkmEmail) : that.lkmEmail != null) return false;
        if (lkmPosition != null ? !lkmPosition.equals(that.lkmPosition) : that.lkmPosition != null) return false;
        if (lkmMemo != null ? !lkmMemo.equals(that.lkmMemo) : that.lkmMemo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lkmId != null ? lkmId.hashCode() : 0;
        result = 31 * result + (lkmName != null ? lkmName.hashCode() : 0);
        result = 31 * result + (lkmGender != null ? lkmGender.hashCode() : 0);
        result = 31 * result + (lkmPhone != null ? lkmPhone.hashCode() : 0);
        result = 31 * result + (lkmMobile != null ? lkmMobile.hashCode() : 0);
        result = 31 * result + (lkmEmail != null ? lkmEmail.hashCode() : 0);
        result = 31 * result + (lkmPosition != null ? lkmPosition.hashCode() : 0);
        result = 31 * result + (lkmMemo != null ? lkmMemo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CstLinkman{" +
                "lkmId=" + lkmId +
                ", lkmName='" + lkmName + '\'' +
                ", lkmGender='" + lkmGender + '\'' +
                ", lkmPhone='" + lkmPhone + '\'' +
                ", lkmMobile='" + lkmMobile + '\'' +
                ", lkmEmail='" + lkmEmail + '\'' +
                ", lkmPosition='" + lkmPosition + '\'' +
                ", lkmMemo='" + lkmMemo + '\'' +
                '}';
    }
}
