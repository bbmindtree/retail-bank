package com.domain.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Navneet Kumar
 *
 */
/******************************************************************************
 * This class contains savings bank accounts.  
 *****************************************************************************/
/**
 * The Class Saving.java
 */

public class Saving extends GenericAccount {

    private String branch;
    private String balance;
    private String penalty;

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
     * @return the balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * @return the penalty
     */
    public String getPenalty() {
        return penalty;
    }

    /**
     * @param penalty the penalty to set
     */
    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }

    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }

}
