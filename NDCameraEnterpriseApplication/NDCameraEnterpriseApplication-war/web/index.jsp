<%-- 
    Document   : index
    Created on : Apr 5, 2023, 7:07:31 PM
    Author     : NUWAA
--%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ndcamera.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.ndcamera.ejb.ProductSessionBeanRemote"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NDCamera Home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <style>
            a{
                text-decoration: none;
                color: white;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid text-center bg-danger p-2">
            <div class="row">
                <div class="col align-self-start"></div>
                <div class="col align-self-center text-light"><h1>NDCamera</h1></div>
                <div class="col align-self-end"><button class="btn btn-primary"><a href="Logout">Logout</a></div>
            </div>
        </div>


        <div class="row align-items-start p-5">
            <div class="col">
                <div class="container-sm px-4">
                    <h3>Product Management</h3>
                </div>
                <div class="container-sm mt-4 px-4">
                    <form action="InsertProduct" method="post">
                        <div class="form-group">
                            <label for="productName" class="form-label">Product Name:</label>
                            <input type="text" class="form-control" name="productName" required>
                        </div>
                        <div class="form-group mt-2">
                            <label for="productName" class="form-label">Brand:</label>
                            <input type="text" class="form-control" name="brand">
                        </div>
                        <div class="form-group mt-2">
                            <label for="productName" class="form-label">Type:</label>
                            <input type="text" class="form-control" name="type">
                        </div>
                        <div class="form-group mt-2">
                            <label for="productName" class="form-label">Sensor Type:</label>
                            <input type="text" class="form-control" name="sensorType">
                        </div>
                        <br>
                        <button type="submit" class="btn btn-danger">Save</button>
                    </form>
                </div>
            </div>
            <div class="col">
                <div class="container-sm px-4">
                    <form action="index.jsp">
                        <div class="input-group"><input type="text" class="form-control" name="value"></td>
                            <button type="submit" class="btn btn-danger">Search</button></div>
                    </form>
                    <br>
                    <table class="table table-striped">
                        <tr>
                            <th>Product Name</th>
                            <th>Brand</th>
                            <th>Type</th>
                            <th>Sensor Type</th>
                            <th colspan="2">Action</th>

                        </tr>
                        <%
                            InitialContext ic = new InitialContext();
                            ProductSessionBeanRemote psbr = (ProductSessionBeanRemote) ic.lookup("com.ndcamera.ejb.ProductSessionBeanRemote");
                            List<Product> products = new ArrayList<>();
                            if (pageContext.getRequest().getParameter("value") != null && !pageContext.getRequest().getParameter("value").equals("") && psbr.findByProductName(pageContext.getRequest().getParameter("value")) != null) {
                                products.add(psbr.findByProductName(pageContext.getRequest().getParameter("value")));
                            } else {
                                products = psbr.getAllProducts();
                            }
                            pageContext.setAttribute("products", products);
                        %>
                        <c:forEach var="product" items="${products}">
                            <tr>
                            <form action="UpdateProduct" method="post">
                                <td><input type="text" name="productName" value="${product.productName}" required></td>
                                <td><input type="text" name="brand" value="${product.brand}"></td>
                                <td><input type="text" name="type" value="${product.type}"></td>  
                                <td><input type="text" name="sensorType" value="${product.sensorType}"></td> 
                                <input type="hidden" name="id" value="${product.id}">             
                                <td>   
                                    <button type="submit" class="btn btn-primary">Update</button>
                                </td>
                            </form>
                            <td><button class="btn btn-danger"><a href="DeleteProduct?id=${product.id}">Delete</a></button></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </body>
</html>
