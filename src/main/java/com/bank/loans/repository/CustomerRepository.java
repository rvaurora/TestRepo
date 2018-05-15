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
	  
	
	public void insertCustomer(Customer obj){
		jdbcTemplate.execute("insert into Customer ( \"Firstname\"  ) values ('"+obj.getFirstname()+ "');");
	}
	
	public int updateCustomer(Customer obj){
		String query="update Customer set  \"Firstname\"=?   where   ";
		int rows=jdbcTemplate.update(query, obj.getFirstname()  ,  );
		return rows;
	}
	
	public int deleteCustomer(Customer obj){		
	String query="Delete  from Customer where    =?";
		return jdbcTemplate.update(query,new Object[] {Integer.valueOf(String.valueOf(  ))});
	}
	
	public  Customer getCustomer(Customer obj)throws SQLException, DataAccessException{
		String query = "SELECT * FROM Customer WHERE  	;";
        
		return jdbcTemplate.query(query, new ResultSetExtractor<Customer>() {
            public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
            	Customer object = new Customer();
                if (rs.next()) {
                                	object.setFirstname
                	                	(rs.getString("firstname"));
                	                                }
                return object;
            }
        });
       }
       
     public List<Customer> getAllCustomer() {
		String query="Select * from Customer";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

		List<Customer> result = new ArrayList<Customer>();
		for(Map<String, Object> row:rows){
			Customer object = new Customer();
						object.setFirstname
			          		((String)row.get("firstname"));
           	           	            
			result.add(object);	
		}
		return result;
	}
	}

