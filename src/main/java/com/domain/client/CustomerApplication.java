package com.domain.client;

import java.util.Scanner;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.domain.constants.CommonConstant;
import com.domain.util.CommonUtil;

/**
 * @author Prakhar Dwivedi
 *
 */
/******************************************************************************
 * This class works as a client application and get required input from console. 
 *****************************************************************************/
/**
 * The Class CustomerApplication.java
 */

public class CustomerApplication {

    public static void main(String[] args) throws Exception {

	int inputValue = 0;
	String sortByName;
	Scanner scanner = new Scanner(System.in);
	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, true);

	while (inputValue != CommonConstant.OPTION_EXIT) {

	    //Display input options at console
	    CommonUtil.displayInputOptionsToConsole();

	    try {

		inputValue = Integer.parseInt(scanner.next());
		System.out.println("");
		
		if (inputValue == CommonConstant.OPTION_EXIT) {
		    //Block of code is executed to exit from the application

		    scanner.close();
		    camelContext.stop();

		} else if (inputValue < 1 || inputValue > 6) {
		    //Block of code is executed in case of wrong input
		    
		    System.out.println("\n****************************************************************************\n");
		    System.out.println(CommonConstant.MESSAGE_CORRECT_OPTION);
		    inputValue = 0;

		} else {
		    //Block of code is executed process the correct input option
		    
		    System.out.print(CommonConstant.MESSAGE_SORT_BY_NAME);
		    sortByName = scanner.next();
		    System.out.println("");
		    
		    if (sortByName != null && (sortByName.equalsIgnoreCase("yes") || sortByName.equalsIgnoreCase("no"))) {
			
			String orderBy;
			if (sortByName.equalsIgnoreCase("yes")) {
			    orderBy = "name";
			} else {
			    orderBy = "order";
			}
			
			//Start Camel Context
			CommonUtil.startCamelContext(appContext, camelContext, inputValue, orderBy);
			Thread.sleep(5000);
			
			System.out.println("\n****************************************************************************\n");
			
		    } else {
			//Block of code is executed in case of wrong order type is given
			
			System.out.println("\n****************************************************************************\n");
			System.out.println(CommonConstant.MESSAGE_YES_OR_NO);
			inputValue = 0;
			
		    }
		}

	    } catch (NumberFormatException e) {

		System.out.println("\n****************************************************************************\n");
		System.out.println(CommonConstant.MESSAGE_NUMBER_ONLY);
		inputValue = 0;
		
	    } catch (Exception e) {
		
		System.out.println(CommonConstant.MESSAGE_SYSTEM_UNAVAILABLE);
		inputValue = CommonConstant.OPTION_EXIT;
		
	    }
	}

	System.out.println(CommonConstant.MESSAGE_LOGOUT);
    }
}
