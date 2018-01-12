/*
 * FileName: BizServiceImpl.java
 * Author:   Arshle
 * Date:     2018年01月12日
 * Description: 业务整合服务实现
 */
package com.chezhibao.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chezhibao.boss.entity.Detect;
import com.chezhibao.boss.intf.DetectService;
import com.chezhibao.crm.entity.Customer;
import com.chezhibao.crm.intf.CustomerService;
import com.chezhibao.service.BizService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 〈业务整合服务实现〉<br>
 * 〈业务整合服务实现类〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
@Service("bizService")
public class BizServiceImpl implements BizService{

    /**
     * 客户服务
     */
    @SuppressWarnings("unused")
    @Reference
    private CustomerService customerService;
    /**
     * 检测服务
     */
    @SuppressWarnings("unused")
    @Reference
    private DetectService detectService;

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    @Override
    public void invoke() {
        Customer customer = new Customer();
        customer.setName("华念文");
        customer.setSex(1);
        customer.setRegion(2072);
        customer.setMobile("13813812300");
        customer.setEmail("sadasdasd");
        customer.setServiceId(2);
        customer.setServiceName("吴静");
        customerService.addCustomer(customer);
        Detect detect = new Detect();
        detect.setStatus(302);
        detect.setAddress("南京市软件大道");
        detect.setEngineerName("南京南京南京南京南京南京南京");
        detect.setEngineerId(3);
        detect.setRegion(2072);
        detectService.addDetect(detect);
    }
}