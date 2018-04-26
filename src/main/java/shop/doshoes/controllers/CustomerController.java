/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.doshoes.controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Inject;
import java.util.*;
import javax.faces.context.FacesContext;
import shop.doshoes.beans.CustomerManagedBean;
import shop.doshoes.jpaejb.CustomerFacade;
import shop.doshoes.entities.Customer;

/**
 *
 * @author Chris
 */
@Named(value = "customerController")
@SessionScoped
public class CustomerController implements Serializable {

	@EJB
	CustomerFacade custFacade;
	
	@Inject
	CustomerManagedBean customerBean;
	
	
	public CustomerController() {
	}
	
	public String validateCustomer() {
            Customer c = new Customer();
            c = custFacade.getValidUser(customerBean);
            System.out.println("customer login fn = " + c.getFirstname());
            if (c != null) {
                customerBean.setEmail(c.getEmail());
                customerBean.setFirstname(c.getFirstname());
                customerBean.setLastname(c.getLastname());
    //            custBean.setPassword(c.getPassword());
                customerBean.setAddress(c.getAddress());
                customerBean.setCity(c.getCity());
                customerBean.setState(c.getState());
                customerBean.setZip(c.getZip());
            }
            
            return "index";
	}
        
	public List<Customer> getAll() {
            return custFacade.findAll();
	}
	
	
	public int count() {
            return custFacade.count();
	}
	
	public void remove(Customer c) {
            custFacade.remove(c);
	}
	
	public String add() {
            Customer c = new Customer();
            c.setCustId(customerBean.getCustId());
            c.setEmail(customerBean.getEmail());
            c.setFirstname(customerBean.getFirstname());
            c.setLastname(customerBean.getLastname());
            c.setPassword(customerBean.getPassword());
            c.setAddress(customerBean.getAddress());
            c.setCity(customerBean.getCity());
            c.setState(customerBean.getState());
            c.setZip(customerBean.getZip());
            System.out.println("custBean's firstname " + customerBean.getFirstname());
            custFacade.create(c);

            return "index";
	}
	
	public String edit(Customer c) {
            customerBean.setEmail(c.getEmail());
            customerBean.setFirstname(c.getFirstname());
            customerBean.setLastname(c.getLastname());
            customerBean.setPassword(c.getPassword());
            customerBean.setAddress(c.getAddress());
            customerBean.setCity(c.getCity());
            customerBean.setState(c.getState());
            customerBean.setZip(c.getZip());

            return "index";
	}
	
	public String save() {
            Customer c = new Customer();
            c.setCustId(customerBean.getCustId());
            c.setEmail(customerBean.getEmail());
            c.setFirstname(customerBean.getFirstname());
            c.setLastname(customerBean.getLastname());
            c.setPassword(customerBean.getPassword());
            c.setAddress(customerBean.getAddress());
            c.setCity(customerBean.getCity());
            c.setState(customerBean.getState());
            c.setZip(customerBean.getZip());

            custFacade.edit(c);

            return "index";
	}
        
        public String logout() {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "/index.xhtml?faces-redirect=true";
        }
}
