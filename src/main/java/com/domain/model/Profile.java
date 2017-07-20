package com.domain.model;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Prakhar Dwivedi
 *
 */
/******************************************************************************
 * This class contains bank customer info.  
 *****************************************************************************/
/**
 * The Class Profile.java
 */

public class Profile {

    private String name;
    private String category;
    private String salutation;
    private String location;
    private String lang;
    private List<Account> accounts = null;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getCategory() {
	return category;
    }

    public void setCategory(String category) {
	this.category = category;
    }

    public String getSalutation() {
	return salutation;
    }

    public void setSalutation(String salutation) {
	this.salutation = salutation;
    }

    public String getLocation() {
	return location;
    }

    public void setLocation(String location) {
	this.location = location;
    }

    public String getLang() {
	return lang;
    }

    public void setLang(String lang) {
	this.lang = lang;
    }

    public List<Account> getAccounts() {
	return accounts;
    }

    public void setAccounts(List<Account> accounts) {
	this.accounts = accounts;
    }

    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }

}
