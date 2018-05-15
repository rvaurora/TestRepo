package com.Bank.Loans.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Bank.Loans.model.Customer;
import com.Bank.Loans.repository.CustomerRepository;

@Service
public class CustomerService{

	@Autowired
	CustomerRepository Customerrepository;
	
	List<Customer> Customerlist = null;

	public void createCustomer(Customer obj){
		Customerrepository.createCustomer(obj);
	}

	public List<Customer> getCustomer(){
		Customerlist = Customerrepository.getAllCustomer();
		return Customerlist;
	}

	public void updateCustomer(Customer updatedCustomer){
		Customer newCreatedCustomer = new Customer();
	
				newCreatedCustomer.setFirstname(updatedCustomer.getFirstname());
				Customerrepository.updateCustomer(newCreatedCustomer);
	}

	public void deleteCustomer(Customer deleteCustomer){
		Customerrepository.deleteCustomer(deleteCustomer);
	}

}