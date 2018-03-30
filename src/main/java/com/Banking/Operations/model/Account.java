
package com.Banking.Operations.model;

import java.io.Serializable;

public class Account implements Serializable{

		private long CustomerID;

		private String CustomerName;

		private String AccountType;

		private String CustomerAddress;

	
		
	public long getCustomerID(){
		return this.CustomerID;
	}
	
	public void setCustomerID(long CustomerID){
		this.CustomerID = CustomerID;
	}
		
	public String getCustomerName(){
		return this.CustomerName;
	}
	
	public void setCustomerName(String CustomerName){
		this.CustomerName = CustomerName;
	}
		
	public String getAccountType(){
		return this.AccountType;
	}
	
	public void setAccountType(String AccountType){
		this.AccountType = AccountType;
	}
		
	public String getCustomerAddress(){
		return this.CustomerAddress;
	}
	
	public void setCustomerAddress(String CustomerAddress){
		this.CustomerAddress = CustomerAddress;
	}
	}