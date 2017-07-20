package com.domain.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Navneet Kumar
 *
 */
/******************************************************************************
 * This class contains Deposit bank accounts.  
 *****************************************************************************/
/**
 * The Class Deposit.java
 */

public class Deposit extends GenericAccount {

    private String branch;
    private String initial;
    private String interest;
    private String maturityDate;
    private String taxsaver;

    /**
     * @return the branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * @return the initial
     */
    public String getInitial() {
        return initial;
    }

    /**
     * @param initial the initial to set
     */
    public void setInitial(String initial) {
        this.initial = initial;
    }

    /**
     * @return the interest
     */
    public String getInterest() {
        return interest;
    }

    /**
     * @param interest the interest to set
     */
    public void setInterest(String interest) {
        this.interest = interest;
    }

    /**
     * @return the maturityDate
     */
    public String getMaturityDate() {
        return maturityDate;
    }

    /**
     * @param maturityDate the maturityDate to set
     */
    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

    /**
     * @return the taxsaver
     */
    public String getTaxsaver() {
        return taxsaver;
    }

    /**
     * @param taxsaver the taxsaver to set
     */
    public void setTaxsaver(String taxsaver) {
        this.taxsaver = taxsaver;
    }

    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }
}
