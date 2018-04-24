/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.doshoes.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Inject;
import java.util.*;
import javax.faces.context.FacesContext;
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
	CustomerManagedBean custBean;
	
	
	public CustomerController() {
	}
	
	public String validateCustomer() {
            Customer c = new Customer();
            c = custFacade.getValidUser(custBean);
            System.out.println("customer login fn = " + c.getFirstname());
            if (c != null) {
                custBean.setEmail(c.getEmail());
                custBean.setFirstname(c.getFirstname());
                custBean.setLastname(c.getLastname());
    //            custBean.setPassword(c.getPassword());
                custBean.setAddress(c.getAddress());
                custBean.setCity(c.getCity());
                custBean.setState(c.getState());
                custBean.setZip(c.getZip());
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
            c.setCustId(custBean.getCustId());
            c.setEmail(custBean.getEmail());
            c.setFirstname(custBean.getFirstname());
            c.setLastname(custBean.getLastname());
            c.setPassword(custBean.getPassword());
            c.setAddress(custBean.getAddress());
            c.setCity(custBean.getCity());
            c.setState(custBean.getState());
            c.setZip(custBean.getZip());
            System.out.println("custBean's firstname " + custBean.getFirstname());
            custFacade.create(c);

            return "index";
	}
	
	public String edit(Customer c) {
            custBean.setEmail(c.getEmail());
            custBean.setFirstname(c.getFirstname());
            custBean.setLastname(c.getLastname());
            custBean.setPassword(c.getPassword());
            custBean.setAddress(c.getAddress());
            custBean.setCity(c.getCity());
            custBean.setState(c.getState());
            custBean.setZip(c.getZip());

            return "index";
	}
	
	public String save() {
            Customer c = new Customer();
            c.setCustId(custBean.getCustId());
            c.setEmail(custBean.getEmail());
            c.setFirstname(custBean.getFirstname());
            c.setLastname(custBean.getLastname());
            c.setPassword(custBean.getPassword());
            c.setAddress(custBean.getAddress());
            c.setCity(custBean.getCity());
            c.setState(custBean.getState());
            c.setZip(custBean.getZip());

            custFacade.edit(c);

            return "index";
	}
        
        public String logout() {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "/index.xhtml?faces-redirect=true";
        }
}
