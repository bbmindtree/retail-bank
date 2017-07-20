package com.domain.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Prakhar Dwivedi
 *
 */
/******************************************************************************
 * This class contains Current bank accounts.  
 *****************************************************************************/
/**
 * The Class Current.java
 */

public class Current extends GenericAccount {

    private String branch;
    private String balance;
    private String limit;

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
     * @return the limit
     */
    public String getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(String limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }
    
}
