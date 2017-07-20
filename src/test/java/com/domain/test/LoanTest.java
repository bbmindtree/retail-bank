package com.domain.test;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.domain.util.CommonUtil;

/**
 * @author Prakhar Dwivedi
 *
 */
/******************************************************************************
 * This class works as a JUnit test case to test Loan accounts display at console. 
 *****************************************************************************/
/**
 * The Class LoanTest.java
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class LoanTest {

    @Test
    public void testDisplayLoanOrderByName() throws Exception{
	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, true);
	CommonUtil.startCamelContext(appContext, camelContext, 6, "name");
    }
    
    @Test
    public void testDisplayLoanOrderByOrder() throws Exception{
	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, true);
	CommonUtil.startCamelContext(appContext, camelContext, 6, "order");
    }

}
