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
import shop.doshoes.beans.CartManagedBean;
import shop.doshoes.beans.ProductManagedBean;
import shop.doshoes.entities.Cart;
import shop.doshoes.jpaejb.CartFacade;

/**
 *
 * @author Chris
 */
@Named(value = "cartController")
@SessionScoped
public class CartController implements Serializable {

	@EJB
	CartFacade cartFacade;
	
	@Inject
	CartManagedBean cartBean;
	@Inject
	ProductManagedBean prodBean;

	
	public CartController() {
	}
	
	public String insertItemToCart(int pid) {
		Cart cart = new Cart();
		System.out.println("product id is " + pid);
		cart.setProductId(pid);
		cartFacade.create(cart);
		
		return "cart";
	}
}
