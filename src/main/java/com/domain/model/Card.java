package com.domain.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Prakhar Dwivedi
 *
 */
/******************************************************************************
 * This class contains Card information.  
 *****************************************************************************/
/**
 * The Class Card.java
 */

public class Card extends GenericAccount {

    private String type;
    private String limit;
    private String consumedLimit;

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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

    /**
     * @return the consumedLimit
     */
    public String getConsumedLimit() {
        return consumedLimit;
    }

    /**
     * @param consumedLimit the consumedLimit to set
     */
    public void setConsumedLimit(String consumedLimit) {
        this.consumedLimit = consumedLimit;
    }

    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }

}
