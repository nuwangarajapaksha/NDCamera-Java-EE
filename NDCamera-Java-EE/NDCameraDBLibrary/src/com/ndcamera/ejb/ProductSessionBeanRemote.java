/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.ndcamera.ejb;

import com.ndcamera.entity.Product;
import com.ndcamera.exception.AuthException;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author NUWAA
 */
@Remote
public interface ProductSessionBeanRemote {

    void insertProduct(Product product) throws AuthException;

    void updateProduct(Product product) throws AuthException;

    void deleteProduct(int id) throws AuthException;

    List<Product> getAllProducts() throws AuthException;

    Product findById(int id) throws AuthException;

    Product findByProductName(String productName) throws AuthException;

    List<Product> findByBrand(String brand) throws AuthException;

    List<Product> findByType(String type) throws AuthException;

    List<Product> findBySensorType(String sensorType) throws AuthException;
}
