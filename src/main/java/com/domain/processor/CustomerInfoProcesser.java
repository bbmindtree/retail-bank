package com.domain.processor;

import java.util.Collections;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.beanutils.BeanComparator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import com.domain.constants.CommonConstant;
import com.domain.model.Card;
import com.domain.model.Current;
import com.domain.model.CustomerDetail;
import com.domain.model.Deposit;
import com.domain.model.Loan;
import com.domain.model.Saving;

/**
 * @author Navneet Kumar
 *
 */
/******************************************************************************
 * This class is written to process the response coming from third party. 
 *****************************************************************************/
/**
 * The Class CustomerInfoProcesser.java
 */

@SuppressWarnings("unchecked")
public class CustomerInfoProcesser implements Processor {

    /**
     * Processes the message exchange
     * 
     * @param exchange
     *            the message exchange
     * @throws Exception
     *             if an internal processing error has occurred.
     */
    public void process(Exchange exchange) throws Exception {

	//Get CustomerDetail from exchange object
	CustomerDetail customerDetail = exchange.getIn().getBody(CustomerDetail.class);
	
	//Get properties from camel context
	String inputValue = exchange.getContext().getProperty(CommonConstant.INPUT_VALUE);
	String orderBy = exchange.getContext().getProperty(CommonConstant.ORDER_BY);

	String xmlResponse = generateXmlResponse(Integer.parseInt(inputValue), orderBy, customerDetail);
	exchange.getOut().setBody(xmlResponse);
	    
    }

    
    /**
     * Method intended for generating the response in form of XML to display at
     * console.
     * 
     * @param inputValue
     *            to determine which account to process
     * 
     * @return orderBy wither "name" or "order" to determine the sort order
     * @return customerDetail contains the information of Customer
     */
    private String generateXmlResponse(int inputValue, String orderBy, CustomerDetail customerDetail) {

	String response = "";
	BeanComparator comparator = new BeanComparator(orderBy);

	switch (inputValue) {

	case 1:	//Generate response for all accounts
	    sortAndAssignCards(CommonConstant.INDEX_CARDS, customerDetail, comparator);
	    sortAndAssignSaving(CommonConstant.INDEX_SAVINGS, customerDetail, comparator);
	    sortAndAssignCurrent(CommonConstant.INDEX_CURRENT, customerDetail, comparator);
	    sortAndAssignDeposit(CommonConstant.INDEX_DEPOSIT, customerDetail, comparator);
	    sortAndAssignLoan(CommonConstant.INDEX_LOANS, customerDetail, comparator);
	    response = XML.toString(new JSONArray(customerDetail.getProfile().getAccounts()));
	    if (response == null || response.trim().equals("")) {
		response = "Mr Harry don't have any account.";
	    }
	    break;

	case 2:	//Generate response for cards accounts
	    sortAndAssignCards(CommonConstant.INDEX_CARDS, customerDetail, comparator);
	    response = XML.toString(new JSONObject(customerDetail.getProfile().getAccounts().get(CommonConstant.INDEX_CARDS)));
	    if (response == null || response.trim().equals("")) {
		response = "Mr Harry don't have any card.";
	    }
	    break;

	case 3:	//Generate response for savings accounts
	    sortAndAssignSaving(CommonConstant.INDEX_SAVINGS, customerDetail, comparator);
	    response = XML.toString(new JSONObject(customerDetail.getProfile().getAccounts().get(CommonConstant.INDEX_SAVINGS)));
	    if (response == null || response.trim().equals("")) {
		response = "Mr Harry don't have any saving account.";
	    }
	    break;

	case 4:	//Generate response for current accounts
	    sortAndAssignCurrent(CommonConstant.INDEX_CURRENT, customerDetail, comparator);
	    response = XML.toString(new JSONObject(customerDetail.getProfile().getAccounts().get(CommonConstant.INDEX_CURRENT)));
	    if (response == null || response.trim().equals("")) {
		response = "Mr Harry don't have any current account.";
	    }
	    break;

	case 5:	//Generate response for deposit accounts
	    sortAndAssignDeposit(CommonConstant.INDEX_DEPOSIT, customerDetail, comparator);
	    response = XML.toString(new JSONObject(customerDetail.getProfile().getAccounts().get(CommonConstant.INDEX_DEPOSIT)));
	    if (response == null || response.trim().equals("")) {
		response = "Mr Harry don't have any deposit account.";
	    }
	    break;

	case 6:	//Generate response for loan accounts
	    sortAndAssignLoan(CommonConstant.INDEX_LOANS, customerDetail, comparator);
	    response = XML.toString(new JSONObject(customerDetail.getProfile().getAccounts().get(CommonConstant.INDEX_LOANS)));
	    if (response == null || response.trim().equals("")) {
		response = "Mr Harry don't have any loan account.";
	    }
	    break;
	}

	return response;
    }

    
    /**
     * Method to sort the Card accounts with the help of BeanComparator and then
     * set the sorted Card object to CustomerDetail
     * 
     * @param index
     *            to determine which account to process
     * 
     * @return customerDetail contains the information of Customer
     * 
     * @return beanComparator Used for sorting the Card accounts
     */
    private void sortAndAssignCards(int index, CustomerDetail customerDetail,
	    BeanComparator comparator) {

	List<Card> cardList = customerDetail.getProfile().getAccounts().get(index).getCards();
	Collections.sort(cardList, comparator);
	customerDetail.getProfile().getAccounts().get(index).setCards(cardList);
    }

    
    /**
     * Method to sort the Savings accounts with the help of BeanComparator and
     * then set the sorted Savings object to CustomerDetail
     * 
     * @param index
     *            to determine which account to process
     * 
     * @return customerDetail contains the information of Customer
     * 
     * @return beanComparator Used for sorting the Savings accounts
     */
    private void sortAndAssignSaving(int index, CustomerDetail customerDetail, BeanComparator comparator) {

	List<Saving> savingList = customerDetail.getProfile().getAccounts().get(index).getSavings();
	Collections.sort(savingList, comparator);
	customerDetail.getProfile().getAccounts().get(index).setSavings(savingList);
    }

    
    /**
     * Method to sort the Current accounts with the help of BeanComparator and
     * then set the sorted Current object to CustomerDetail
     * 
     * @param index
     *            to determine which account to process
     * 
     * @return customerDetail contains the information of Customer
     * 
     * @return beanComparator Used for sorting the Current accounts
     */
    private void sortAndAssignCurrent(int index, CustomerDetail customerDetail, BeanComparator comparator) {

	List<Current> currentList = customerDetail.getProfile().getAccounts().get(index).getCurrent();
	Collections.sort(currentList, comparator);
	customerDetail.getProfile().getAccounts().get(index).setCurrent(currentList);
    }

    
    /**
     * Method to sort the Deposit accounts with the help of BeanComparator and
     * then set the sorted Deposit object to CustomerDetail
     * 
     * @param index
     *            to determine which account to process
     * 
     * @return customerDetail contains the information of Customer
     * 
     * @return beanComparator Used for sorting the Deposit accounts
     */
    private void sortAndAssignDeposit(int index, CustomerDetail customerDetail, BeanComparator comparator) {

	List<Deposit> depositList = customerDetail.getProfile().getAccounts().get(index).getDeposits();
	Collections.sort(depositList, comparator);
	customerDetail.getProfile().getAccounts().get(index).setDeposits(depositList);
    }

    
    /**
     * Method to sort the Loan accounts with the help of BeanComparator and then
     * set the sorted Loan object to CustomerDetail
     * 
     * @param index
     *            to determine which account to process
     * 
     * @return customerDetail contains the information of Customer
     * 
     * @return beanComparator Used for sorting the Loan accounts
     */
    private void sortAndAssignLoan(int index, CustomerDetail customerDetail, BeanComparator comparator) {

	List<Loan> loanList = customerDetail.getProfile().getAccounts().get(index).getLoans();
	Collections.sort(loanList, comparator);
	customerDetail.getProfile().getAccounts().get(index).setLoans(loanList);
    }

}
