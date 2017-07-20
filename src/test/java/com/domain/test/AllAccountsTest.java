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
 * @author Navneet Kumar
 *
 */
/******************************************************************************
 * This class works as a JUnit test case to test AllAccounts display at console. 
 *****************************************************************************/
/**
 * The Class AllAccountsTest.java
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AllAccountsTest {

    @Test
    public void testSeeAllAccountsOrderByName() throws Exception{
	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, true);
	CommonUtil.startCamelContext(appContext, camelContext, 1, "name");
    }
    
    @Test
    public void testSeeAllAccountsOrderByOrder() throws Exception{
	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, true);
	CommonUtil.startCamelContext(appContext, camelContext, 1, "order");
    }

}
