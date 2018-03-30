package com.Banking.Operations.controller;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.Banking.Operations.service.AccountService;
import com.Banking.Operations.model.Account;

@RestController
@RequestMapping("/Account")
class AccountController{

	@Autowired
	AccountService service;

	@RequestMapping(value="/createAccount",method=RequestMethod.POST)
	public void createAccount(Account createAccount){
		service.createAccount(createAccount);
	}

	@RequestMapping(value="/getAccount",method=RequestMethod.GET)
	public List<Account> getAccount(){
		List<Account> list = new ArrayList<Account>();
		list = service.getAccount();
		return list;
	}

	@RequestMapping(value="/updateAccount",method=RequestMethod.POST)
	public void updateAccount(Account updateAccount){
		service.updateAccount(updateAccount);
	}

	@RequestMapping(value="/deleteAccount",method=RequestMethod.POST)
	public void deleteAccount(Account deleteAccount){
		service.deleteAccount(deleteAccount);
	}

}