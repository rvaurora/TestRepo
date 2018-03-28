package com.Banking.Operations.repository;

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
import com.Banking.Operations.model.Account;

@Repository
public class AccountRepository{
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
 
 	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	  
	
	public void createAccount(Account obj){
	 String sql = "CREATE TABLE Account ( "+
                                     " CustomerID  varchar   not NULL PRIMARY KEY  " +
                   "  " + 
                   " , " +
                                     " " +
                   "  CustomerName  varchar (255)  " + 
                   " , " +
                                     " " +
                   "  AccountType  varchar (255)  " + 
                   " , " +
                                     " " +
                   "  CustomerAddress  varchar (255)  " + 
                   "  " +
                                    +")";
      jdbcTemplate.execute(sql);
      
   }
	
	public void insertAccount(Account obj){
		jdbcTemplate.execute("insert into Account ( \"CustomerID\" ,  \"CustomerName\" ,  \"AccountType\" ,  \"CustomerAddress\"  ) values ('"+obj.getCustomerID()+"', '"+obj.getCustomerName()+"', '"+obj.getAccountType()+"', '"+obj.getCustomerAddress()+ "');");
	}
	
	public int updateAccount(Account obj){
		String query="update Account set  \"CustomerID\"=? ,  \"CustomerName\"=? ,  \"AccountType\"=? ,  \"CustomerAddress\"=?   where   \"CustomerID\"=?        ";
		int rows=jdbcTemplate.update(query, obj.getCustomerID(), obj.getCustomerName(), obj.getAccountType(), obj.getCustomerAddress()  ,  obj.getCustomerID()        );
		return rows;
	}
	
	public int deleteAccount(Account obj){		
	String query="Delete  from Account where   \"CustomerID\"         =?";
		return jdbcTemplate.update(query,new Object[] {Integer.valueOf(String.valueOf(  obj.getCustomerID()        ))});
	}
	
	public  Account getAccount(Account obj)throws SQLException, DataAccessException{
		String query = "SELECT * FROM Account WHERE  	 \"CustomerID\" = '"+obj.getCustomerID()+"'  	 	 	;";
        
		return jdbcTemplate.query(query, new ResultSetExtractor<Account>() {
            public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
            	Account object = new Account();
                if (rs.next()) {
                                	object.setCustomerID
                	                	(rs.getlong("CustomerID"));
                	                                	object.setCustomerName
                	                	(rs.getString("CustomerName"));
                	                                	object.setAccountType
                	                	(rs.getString("AccountType"));
                	                                	object.setCustomerAddress
                	                	(rs.getString("CustomerAddress"));
                	                                }
                return object;
            }
        });
       }
       
     public List<Customer> getAllAccount() {
		String query="Select * from Account";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

		List<Account> result = new ArrayList<Account>();
		for(Map<String, Object> row:rows){
			Account object = new Account();
						object.setCustomerID
			          		((long)row.get("CustomerID"));
           	           				object.setCustomerName
			          		((String)row.get("CustomerName"));
           	           				object.setAccountType
			          		((String)row.get("AccountType"));
           	           				object.setCustomerAddress
			          		((String)row.get("CustomerAddress"));
           	           	            
			result.add(object);	
		}
		return result;
	}
	}

