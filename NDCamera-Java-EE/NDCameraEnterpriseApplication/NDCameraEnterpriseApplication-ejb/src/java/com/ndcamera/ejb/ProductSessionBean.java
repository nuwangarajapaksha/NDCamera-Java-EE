/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.ndcamera.ejb;

import com.ndcamera.entity.Product;
import com.ndcamera.exception.AuthException;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

/**
 *
 * @author NUWAA
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ProductSessionBean implements ProductSessionBeanRemote {

    @PersistenceContext(unitName = "NDCameraEnterpriseApplication-ejbPU")
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public UserTransaction getUt() {
        return ut;
    }

    public void setUt(UserTransaction ut) {
        this.ut = ut;
    }

    @Interceptors(LoggingInterceptor.class)
    @RolesAllowed({"superadmin", "admin"})
    @Override
    public void insertProduct(Product product) throws AuthException {
        try {
            ut.begin();
            em.persist(product);
            ut.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Interceptors(LoggingInterceptor.class)
    @RolesAllowed({"superadmin", "admin"})
    @Override
    public void updateProduct(Product product) throws AuthException {
        try {
            ut.begin();
            em.merge(product);
            ut.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Interceptors(LoggingInterceptor.class)
    @RolesAllowed({"superadmin"})
    @Override
    public void deleteProduct(int id) throws AuthException {
        Product product = findById(id);
        try {
            ut.begin();
            if (!em.contains(product)) {
                product = em.merge(product);
            }
            em.remove(product);
            ut.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Interceptors(LoggingInterceptor.class)
    @PermitAll
    @Override
    public List<Product> getAllProducts() throws AuthException {
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Interceptors(LoggingInterceptor.class)
    @PermitAll
    @Override
    public Product findById(int id) throws AuthException {
        return em.find(Product.class, id);
    }

    @Interceptors(LoggingInterceptor.class)
    @PermitAll
    @Override
    public Product findByProductName(String productName) throws AuthException {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.productName=:productName", Product.class);
        query.setParameter("productName", productName);
        Product product = query.getSingleResult();
        return product;
    }

    @Interceptors(LoggingInterceptor.class)
    @PermitAll
    @Override
    public List<Product> findByBrand(String brand) throws AuthException {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.brand=:brand", Product.class);
        query.setParameter("brand", brand);
        List<Product> product = query.getResultList();
        return product;
    }

    @Interceptors(LoggingInterceptor.class)
    @PermitAll
    @Override
    public List<Product> findByType(String type) throws AuthException {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.brand=:brand", Product.class);
        query.setParameter("type", type);
        List<Product> product = query.getResultList();
        return product;
    }

    @Interceptors(LoggingInterceptor.class)
    @PermitAll
    @Override
    public List<Product> findBySensorType(String sensorType) throws AuthException {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.brand=:brand", Product.class);
        query.setParameter("sensorType", sensorType);
        List<Product> product = query.getResultList();
        return product;
    }
}
