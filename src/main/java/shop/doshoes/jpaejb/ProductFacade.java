/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.doshoes.jpaejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import shop.doshoes.entities.Product;

/**
 *
 * @author Chris
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "edu.ilstu_DoShoes_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
    public List<Product> findClothes(String category) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> q = cb.createQuery(Product.class);
        Root<Product> product = q.from(Product.class);
        predicates.add(cb.equal(product.get("category"), category));
        q.select(product).where(predicates.toArray(new Predicate[]{}));
                if (em.createQuery(q).getResultList().isEmpty()) {
            return null;
        } else {
            return em.createQuery(q).getResultList();
        }
    }
    
    public List<Product> findBrand(String brand) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> q = cb.createQuery(Product.class);
        Root<Product> product = q.from(Product.class);
        predicates.add(cb.equal(product.get("brand"), brand));
        q.select(product).where(predicates.toArray(new Predicate[]{}));
                if (em.createQuery(q).getResultList().isEmpty()) {
            return null;
        } else {
            return em.createQuery(q).getResultList();
        }
    }
    
    public List<Product> findProductTitle(String title) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> q = cb.createQuery(Product.class);
        Root<Product> product = q.from(Product.class);
        predicates.add(cb.equal(product.get("title"), title));
        q.select(product).where(predicates.toArray(new Predicate[]{}));
                if (em.createQuery(q).getResultList().isEmpty()) {
            return null;
        } else {
            return em.createQuery(q).getResultList();
        }
    }
    
}
