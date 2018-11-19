package com.web.action;

import com.bean.CstCustomerEntity;
import com.bean.CstLinkman;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CustomerService;
import com.service.LinkManService;
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
 * @create 2018/10/26 22:54
 */
@Controller("linkManAction")
@Scope("propotype")
@ParentPackage("struts-default")
@Namespace("/linkman")
@Results({
        @Result(name = "addUI",type = "dispatcher",location="/jsp/linkman/add.jsp"),
        @Result(name = "success", type = "dispatcher", location="/jsp/success.jsp"),
        @Result(name = "findAll", type = "dispatcher", location="/jsp/linkman/list.jsp"),
        @Result(name = "listLinkMan", type = "redirectAction", location="findAllLinkMan"),
        @Result(name = "editUI", type = "dispatcher", location="/jsp/linkman/edit.jsp"),
        @Result(name = "update", type = "redirectAction", location="findAllLinkMan")
}
)
public class LinkManAction extends ActionSupport implements ModelDriven {
    private CstLinkman linkman = new CstLinkman();
    private List<CstCustomerEntity> customerEntities;
    private List<CstLinkman> linkmans;
    @Resource(name = "customerService")
    private CustomerService customerService;
    @Resource(name = "linkManService")
    private LinkManService linkManService;
    @Override
    public Object getModel() {
        return linkman;
    }

    /**
     * 获取添加联系人页面
     * @return
     */
    @Action("addUILinkMan")
    public String addUILinkMan(){
        customerEntities = customerService.findAllCustomer();
        return "addUI";
    }

    /**
     * 添加联系人
     * @return
     */
    @Action("addLinkMan")
    public String addLinkMan(){
        linkManService.addLinkMan(linkman);
        return SUCCESS;
    }

    /**
     * 查询所有联系人
     * @return
     */
    @Action("findAllLinkMan")
    public String findAllLinkMan(){
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CstLinkman.class);
       //模糊查询联系人名称
        if (StringUtils.isNotBlank(linkman.getLkmName())){
            detachedCriteria.add(Restrictions.like("lkmName","%"+linkman.getLkmName()+"%"));
        }
        //模糊查询联系人职位
        if (StringUtils.isNotBlank(linkman.getLkmPosition())){
            detachedCriteria.add(Restrictions.like("lkmPosition","%"+linkman.getLkmPosition()+"%"));
        }
        //精确查询联系人所属客户
        if (linkman.getCustomerEntity() !=null && (Long )(linkman.getCustomerEntity().getCustId()) != null && linkman.getCustomerEntity().getCustId() != 0){
            detachedCriteria.add(Restrictions.eq("customerEntity.custId",linkman.getCustomerEntity().getCustId()));
        }
        //精确查询联系人性别
        if (StringUtils.isNotBlank(linkman.getLkmGender())){
            detachedCriteria.add(Restrictions.eq("lkmGender",linkman.getLkmGender()));
        }
        customerEntities = customerService.findAllCustomer();
        linkmans = linkManService.findAllLinkMan(detachedCriteria);
        return "findAll";
    }

    /**
     * 删除联系人
     * @return
     */
    @Action("deleteLinkMan")
    public String deleteLinkMan(){
        linkManService.deleteLinkMan(linkman.getLkmId());
        return "listLinkMan";
    }

    /**
     * 获取修改编辑页面
     * @return
     */
    @Action("editUILinkMan")
    public String editUILinkMan(){
        customerEntities = customerService.findAllCustomer();
        CstLinkman cstLinkman = linkManService.findLinkManById(linkman.getLkmId());
        //压栈
        ActionContext.getContext().getValueStack().push(cstLinkman);
        return "editUI";
    }

    /**
     * 修改联系人
     * @return
     */
    @Action("updateLinkMan")
    public String updateLinkMan(){
        linkManService.updateLinkMan(linkman);
        return "update";
    }

    public CstLinkman getLinkman() {
        return linkman;
    }
    public void setLinkman(CstLinkman linkman) {
        this.linkman = linkman;
    }
    public List<CstCustomerEntity> getCustomerEntities() {
        return customerEntities;
    }
    public void setCustomerEntities(List<CstCustomerEntity> customerEntities) {
        this.customerEntities = customerEntities;
    }
    public List<CstLinkman> getLinkmans() {
        return linkmans;
    }
    public void setLinkmans(List<CstLinkman> linkmans) {
        this.linkmans = linkmans;
    }
}
