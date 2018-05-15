
package com.Bank.Loans.model;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable{

		private String firstname;

	
		
	public String getFirstname(){
		return this.firstname;
	}
	
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	}