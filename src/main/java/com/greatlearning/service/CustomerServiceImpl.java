package com.greatlearning.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.entity.Customers;

@Repository
public class CustomerServiceImpl implements ICustomerService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.session = this.sessionFactory.openSession();
	}

	@Override
	@Transactional
	public void saveCustomer(Customers customers) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(customers);
		transaction.commit();
	}

	@Override
	@Transactional
	public Customers findById(int id) {
		Transaction transaction = session.beginTransaction();
		Customers customer;
		customer = session.get(Customers.class, id);
		transaction.commit();
		return customer;
	}

	@Override
	@Transactional
	public List<Customers> getAllCustomers() {
		Transaction transaction = session.beginTransaction();
		List<Customers> customers = session.createQuery("from Customers order by lastname").list();
		transaction.commit();
		return customers;
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		Transaction transaction = session.beginTransaction();
		Customers customer = session.get(Customers.class, id);
		if (customer != null) {
			session.delete(customer);
		}
		transaction.commit();
	}

}
