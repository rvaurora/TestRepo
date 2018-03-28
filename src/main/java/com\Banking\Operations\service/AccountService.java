package com.Banking.Operations.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Banking.Operations.model.Account;
import com.Banking.Operations.repository.AccountRepository;

@Service
public class AccountService{

	@Autowired
	AccountRepository Accountrepository;
	
	List<Account> Accountlist = null;

	public void createAccount(Account obj){
		Accountrepository.createAccount(obj);
	}

	public List<Account> getAccount(){
		Accountlist = Accountrepository.getAllAccount();
		return Accountlist;
	}

	public void updateAccount(Account updatedAccount){
		Account newCreatedAccount = new Account();
	
				newCreatedAccount.setCustomerID(updatedAccount.getCustomerID());
				newCreatedAccount.setCustomerName(updatedAccount.getCustomerName());
				newCreatedAccount.setAccountType(updatedAccount.getAccountType());
				newCreatedAccount.setCustomerAddress(updatedAccount.getCustomerAddress());
				Accountrepository.updateAccount(newCreatedAccount);
	}

	public void deleteAccount(Account deleteAccount){
		Accountrepository.deleteAccount(deleteAccount);
	}

}