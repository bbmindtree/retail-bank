package com.domain.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Prakhar Dwivedi
 *
 */
/******************************************************************************
 * This class contains accounts general info and extended by all other types of accounts.  
 *****************************************************************************/
/**
 * The Class GenericAccount.java
 */

public class GenericAccount {

    private String id;
    private String name;
    private String currency;
    private String order;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return the order
     */
    public String getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }
    
}
