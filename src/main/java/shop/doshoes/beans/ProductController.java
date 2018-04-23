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
import shop.doshoes.entities.Product;
import shop.doshoes.jpaejb.ProductFacade;

/**
 *
 * @author Chris
 */
@Named(value = "productController")
@SessionScoped
public class ProductController implements Serializable {

    @EJB
    ProductFacade productFacade;
    
    @Inject
    ProductManagedBean productBean;
    /**
     * Creates a new instance of ProductController
     */
    public ProductController() {
    }
    
    public List<Product> getAll() {
        return productFacade.findAll();
    }
    
    public int count() {
        return productFacade.count();
    }
}
