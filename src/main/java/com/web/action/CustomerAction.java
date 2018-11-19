package com.web.action;

import com.bean.BaseDictEntity;
import com.bean.CstCustomerEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CustomerService;
import com.web.commons.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WJUN
 * @create 2018/10/25 15:59
 * 客户的动作类
 */
@Controller("customerAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/customer")
@Results({
        @Result(name="addUI",type = "dispatcher",location = "/jsp/customer/add.jsp"),
        @Result(name="findAll",type = "dispatcher",location = "/jsp/customer/list.jsp"),
        @Result(name="listCustomer",type = "redirectAction",location = "findAllCustomer"),
        @Result(name="editUI",type = "dispatcher",location = "/jsp/customer/edit.jsp"),
        @Result(name="updateUI",type = "redirectAction",location = "findAllCustomer")
})
public class CustomerAction extends ActionSupport implements ModelDriven<CstCustomerEntity> {
    private CstCustomerEntity cstCustomerEntity = new CstCustomerEntity();
//    private List<CstCustomerEntity> customerEntities;
    private List<BaseDictEntity> custSources;
    private List<BaseDictEntity> custLevels;
    private Page page;
    private Integer num;
    @Resource(name = "customerService")
    private CustomerService customerService;
    @Override
    public CstCustomerEntity getModel() {
        return cstCustomerEntity;
    }

    @Action("addCustomer")
    public String addCustomer(){
        customerService.saveCustomer(cstCustomerEntity);
        return "listCustomer";
    }

    /**
     * 查询客户列表
     * @return
     */
    @Action("findAllCustomer")
    public String findAllCustomer(){
        //定义离线对象
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CstCustomerEntity.class);
        //拼装查询条件
        //判断是否输入了客户名称
//        if (cstCustomerEntity.getCustName() != null && !cstCustomerEntity.getCustName().equals(""))
        if (StringUtils.isNotBlank(cstCustomerEntity.getCustName())){//isBlank是判断是否为空null "" " "
            //模糊查询客户名称
            detachedCriteria.add(Restrictions.like("custName","%"+cstCustomerEntity.getCustName()+"%"));
        }
        //判断是否输入了客户行业
        if (StringUtils.isNotBlank(cstCustomerEntity.getCustIndustry())){//isBlank是判断是否为空null "" " "
            //模糊查询客户行业
            detachedCriteria.add(Restrictions.like("custIndustry","%"+cstCustomerEntity.getCustIndustry()+"%"));
        }
        //判断是否选择了客户级别
        if (cstCustomerEntity.getCustLevel() !=null && StringUtils.isNotBlank(cstCustomerEntity.getCustLevel().getDictId())){//isBlank是判断是否为空null "" " "
            //精确查询客户级别
            detachedCriteria.add(Restrictions.eq("custLevel.dictId",cstCustomerEntity.getCustLevel().getDictId()));
        }
        //判断是否选择了客户来源
        if (cstCustomerEntity.getCustSource()!= null && StringUtils.isNotBlank(cstCustomerEntity.getCustSource().getDictId())){//isBlank是判断是否为空null "" " "
            //精确查询客户来源
            detachedCriteria.add(Restrictions.eq("custSource.dictId",cstCustomerEntity.getCustSource().getDictId()));
        }
        //根据离线对象查询客户信息
        page = customerService.findAllCustomer(detachedCriteria,num);
        //        查询所有客户来源
        custSources = customerService.findAllCustomerSources();
//        查询所有客户级别
        custLevels = customerService.findAllCustomerLevels();
        return "findAll";
    }

    /**
     * 获取添加客户页面
     * @return
     */
    @Action("addUICustomer")
    public String addUICustomer(){
//        查询所有客户来源
        custSources = customerService.findAllCustomerSources();
//        查询所有客户级别
        custLevels = customerService.findAllCustomerLevels();
        return "addUI";
    }

    /**
     * 删除客户
     * @return
     */
    @Action("deleteCustomer")
    public String deleteCustomer(){
        customerService.deleteCustomer(cstCustomerEntity.getCustId());
        return "listCustomer";
    }

    /**
     * 获取编辑页面
     * @return
     */
    @Action("editUICustomer")
    public String editUICustomer(){
        //        查询所有客户来源
        custSources = customerService.findAllCustomerSources();
//        查询所有客户级别
        custLevels = customerService.findAllCustomerLevels();
//        根据id获取想要编辑的客户信息
        CstCustomerEntity c = customerService.findCustomerById(cstCustomerEntity.getCustId());
        ActionContext.getContext().getValueStack().push(c);//压栈
        return "editUI";
    }

    @Action("updateCustomer")
    public String updateCustomer(){
        customerService.updateCustomer(cstCustomerEntity);
        return "updateUI";
    }
    public CstCustomerEntity getCstCustomerEntity() {
        return cstCustomerEntity;
    }
    public void setCstCustomerEntity(CstCustomerEntity cstCustomerEntity) {
        this.cstCustomerEntity = cstCustomerEntity;
    }
    public List<BaseDictEntity> getCustSources() {
        return custSources;
    }
    public void setCustSources(List<BaseDictEntity> custSources) {
        this.custSources = custSources;
    }
    public List<BaseDictEntity> getCustLevels() {
        return custLevels;
    }
    public void setCustLevels(List<BaseDictEntity> custLevels) {
        this.custLevels = custLevels;
    }
    public Page getPage() {
        return page;
    }
    public void setPage(Page page) {
        this.page = page;
    }
    public Integer getNum() {
        return num;
    }
    public void setNum(Integer num) {
        this.num = num;
    }
}
