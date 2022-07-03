package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.entity.Customers;
import com.greatlearning.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ICustomerService customerService;

	@RequestMapping("/addCustomerForm")
	public String addCustomer(Model model) {
		Customers customer = new Customers();
		model.addAttribute("Customer", customer);
		return "customer-form";
	}

	@RequestMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Customers customer;
		if (id != 0) {
			customer = customerService.findById(id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
		} else {
			customer = new Customers(firstName, lastName, email);
		}
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		Customers customer = customerService.findById(id);
		model.addAttribute("Customer", customer);
		return "customer-form";
	}

	@RequestMapping("/list")
	public String showAllCustomers(Model model) {
		List<Customers> customers = customerService.getAllCustomers();
		model.addAttribute("Customers", customers);
		return "list-customers";
	}

	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}

}
