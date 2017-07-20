package com.domain.model;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Navneet Kumar
 *
 */
/******************************************************************************
 * This class contains List of all types of bank accounts.  
 *****************************************************************************/
/**
 * The Class Account.java
 */

public class Account {

    private List<Current> current = null;
    private List<Saving> savings = null;
    private List<Deposit> deposits = null;
    private List<Card> cards = null;
    private List<Loan> loans = null;

    public List<Current> getCurrent() {
	return current;
    }

    public void setCurrent(List<Current> current) {
	this.current = current;
    }

    public List<Saving> getSavings() {
	return savings;
    }

    public void setSavings(List<Saving> savings) {
	this.savings = savings;
    }

    public List<Deposit> getDeposits() {
	return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
	this.deposits = deposits;
    }

    public List<Card> getCards() {
	return cards;
    }

    public void setCards(List<Card> cards) {
	this.cards = cards;
    }

    public List<Loan> getLoans() {
	return loans;
    }

    public void setLoans(List<Loan> loans) {
	this.loans = loans;
    }

    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }

}
