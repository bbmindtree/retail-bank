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
 * This class works as a JUnit test case to test Current accounts display at console. 
 *****************************************************************************/
/**
 * The Class CurrentTest.java
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class CurrentTest {

    @Test
    public void testDisplayCurrentOrderByName() throws Exception{
	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, true);
	CommonUtil.startCamelContext(appContext, camelContext, 4, "name");
    }
    
    @Test
    public void testDisplayCurrentOrderByOrder() throws Exception{
	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, true);
	CommonUtil.startCamelContext(appContext, camelContext, 4, "order");
    }

}
