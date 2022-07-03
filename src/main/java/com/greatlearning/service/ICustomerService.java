package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.Customers;

public interface ICustomerService {

	public void saveCustomer(Customers customers);

	public Customers findById(int id);

	public List<Customers> getAllCustomers();

	public void deleteCustomer(int id);

}
