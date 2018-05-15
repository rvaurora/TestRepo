package com.Bank.Loans.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import com.Bank.Loans.model.Customer;

@Repository
public class CustomerRepository{
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
 
 	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	  
		public void createCustomer(Customer obj){
	 String sql = "CREATE TABLE Customer ( "+
                                                        "  firstname  VARCHAR(0)   " + 
                   " "+")";
      jdbcTemplate.execute(sql);
      
   }	}

