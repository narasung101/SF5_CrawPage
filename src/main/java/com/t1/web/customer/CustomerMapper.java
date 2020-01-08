package com.t1.web.customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {

	public int customerCount();
	public void insertCustomerJoin(Customer param);
	public Customer selectCustomerLogin(Customer param);
		
}