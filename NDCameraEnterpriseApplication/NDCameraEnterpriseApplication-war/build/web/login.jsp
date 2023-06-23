<%-- 
    Document   : login
    Created on : Apr 5, 2023, 7:19:45 PM
    Author     : NUWAA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NDCamera Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid text-center bg-danger p-2">
            <div class="row">
                <div class="col-12 text-light"><h1>NDCamera</h1></div>
            </div>
        </div>

        <div class="row m-5 p-5 text-center">
            <div class="col-4 m-auto">
                <h1>Login</h1>
                <form action="j_security_check" method="post" class="mt-5">
                    <div class="form-outline mb-4">
                        <input type="text" name="j_username" id="form2Example1" class="form-control" placeholder="username" required/>
                    </div>
                    <div class="form-outline mb-4">
                        <input type="password" name="j_password" id="form2Example2" class="form-control" placeholder="password" required/>
                    </div>
                    <button type="submit" class="btn btn-danger">Login</button>
                </form>
            </div>
        </div>
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </body>
</html>
