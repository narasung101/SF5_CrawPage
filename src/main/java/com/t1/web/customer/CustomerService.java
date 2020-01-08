package com.t1.web.customer;

import org.springframework.stereotype.Component;

@Component
public interface CustomerService {
	public int customerCount();
	public void insertCustomerJoin(Customer param);
	public Customer selectCustomerLogin(Customer param);
}
