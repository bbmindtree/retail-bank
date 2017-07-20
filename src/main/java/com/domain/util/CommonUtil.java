package com.domain.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.context.ApplicationContext;

import com.domain.constants.CommonConstant;

/**
 * @author Prakhar Dwivedi
 *
 */
/******************************************************************************
 * This class is written for common utilities to be used throughout the project. 
 *****************************************************************************/
/**
 * The Class CommonUtil.java
 */

public class CommonUtil {

    /**
     * Method used to start camel context.
     * 
     * @param appContext
     * @param camelContext
     * @param inputValue
     *            to determine which account to process
     * @return orderBy wither "name" or "order" to determine the sort order
     * return void
     */
    public static void startCamelContext(ApplicationContext appContext, CamelContext camelContext, 
	    int inputValue, String orderBy) throws Exception {
	
	//Set properties to Camel Context
	Map<String, String> propertiesMap = new HashMap<String, String>();
	propertiesMap.put(CommonConstant.INPUT_VALUE, Integer.toString(inputValue));
	propertiesMap.put(CommonConstant.ORDER_BY, orderBy);
	camelContext.setProperties(propertiesMap);

	ProducerTemplate template = camelContext.createProducerTemplate();
	
	//Start Camel Context
	camelContext.start();
	template.sendBody("activemq:test.queue", "");
    }

    
    /**
     * Method used to display the options on console.
     * @return void
     */
    public static void displayInputOptionsToConsole() {

	System.out.println("\n" + CommonConstant.MESSAGE_WELCOME);
	System.out.println(CommonConstant.OPTION_ALL_ACCOUNT);
	System.out.println(CommonConstant.OPTION_CARDS);
	System.out.println(CommonConstant.OPTION_SAVINGS_ACCOUNT);
	System.out.println(CommonConstant.OPTION_CURRENT_ACCOUNT);
	System.out.println(CommonConstant.OPTION_DEPOSIT_ACCOUNT);
	System.out.println(CommonConstant.OPTION_LOANS);
	System.out.println(CommonConstant.MESSAGE_EXIT + "\n");
	System.out.print("Please choose one of the above options and press enter : ");
    }
    
}
