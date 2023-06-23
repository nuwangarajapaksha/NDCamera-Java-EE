/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ndcamera.web;

import com.ndcamera.ejb.ProductSessionBeanRemote;
import com.ndcamera.entity.Product;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ejb.EJBAccessException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NUWAA
 */
@WebServlet(name = "InsertProduct", urlPatterns = {"/InsertProduct"})
public class InsertProduct extends HttpServlet {

    @EJB
    private ProductSessionBeanRemote psbr;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String productName = request.getParameter("productName");
            String brand = request.getParameter("brand");
            String type = request.getParameter("type");
            String sensorType = request.getParameter("sensorType");

            Product product = new Product();
            product.setProductName(productName);
            product.setBrand(brand);
            product.setType(type);
            product.setSensorType(sensorType);
            psbr.insertProduct(product);
            response.sendRedirect("index.jsp");
        } catch (EJBAccessException ex) {
            ex.printStackTrace();
            response.sendRedirect("403.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
