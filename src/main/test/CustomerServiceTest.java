import com.bean.CstCustomerEntity;
import com.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author WJUN
 * @create 2018/10/25 14:45
 * 测试业务层的俩个方法
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:applicationContext.xml"})
public class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;
    @Test
    public void testFindAll(){
        /*DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CstCustomerEntity.class);
        List list = customerService.findAllCustomer(detachedCriteria);
        if (list.size() > 0){
            for (Object o:list){
                System.out.println(o);
            }
        }*/
    }
    @Test
    public void testSave(){
        CstCustomerEntity cstCustomerEntity = new CstCustomerEntity();
        cstCustomerEntity.setCustName("CRM CUSTOMER");
        customerService.saveCustomer(cstCustomerEntity);
    }
}
