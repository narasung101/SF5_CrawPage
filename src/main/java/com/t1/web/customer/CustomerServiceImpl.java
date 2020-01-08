package com.t1.web.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired CustomerMapper mapper;

	@Override
	public int customerCount() {
		// TODO Auto-generated method stub
		return mapper.customerCount();
	}

	@Override
	public void insertCustomerJoin(Customer param) {
		mapper.insertCustomerJoin(param);
		
	}

	@Override
	public Customer selectCustomerLogin(Customer param) {
		
		return mapper.selectCustomerLogin(param);
	}

}
