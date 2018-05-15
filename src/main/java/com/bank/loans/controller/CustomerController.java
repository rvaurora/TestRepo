package com.Bank.Loans.controller;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.Bank.Loans.service.CustomerService;
import com.Bank.Loans.model.Customer;

@RestController
@RequestMapping("/Customer")
class CustomerController{

	@Autowired
	CustomerService service;

	@RequestMapping(value="/createCustomer",method=RequestMethod.POST)
	public void createCustomer(Customer createCustomer){
		service.createCustomer(createCustomer);
	}

	@RequestMapping(value="/getCustomer",method=RequestMethod.GET)
	public List<Customer> getCustomer(){
		List<Customer> list = new ArrayList<Customer>();
		list = service.getCustomer();
		return list;
	}

	@RequestMapping(value="/updateCustomer",method=RequestMethod.POST)
	public void updateCustomer(Customer updateCustomer){
		service.updateCustomer(updateCustomer);
	}

	@RequestMapping(value="/deleteCustomer",method=RequestMethod.POST)
	public void deleteCustomer(Customer deleteCustomer){
		service.deleteCustomer(deleteCustomer);
	}

}