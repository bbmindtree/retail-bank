package com.domain.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Prakhar Dwivedi
 *
 */
/******************************************************************************
 * This class contains Customer Detail.  
 *****************************************************************************/
/**
 * The Class CustomerDetail.java
 */

public class CustomerDetail {

    private Profile profile;

    public Profile getProfile() {
	return profile;
    }

    public void setProfile(Profile profile) {
	this.profile = profile;
    }

    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }

}
