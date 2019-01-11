
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="Header.jsp"%>
   

<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width,initial-scale=1"/>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<body>
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Sign In</h5>
             <form id="Login" action="<c:url value="/perform_login" ></c:url>" method="post">
              <div class="form-group">
              <label for="inputEmail">User Name</label>
                <input type="text" id="inputEmail" name="username" class="form-control" placeholder="User Name" required autofocus>
                
              </div>
              <div class="form-group">
              <label for="inputPassword">Password</label>
              
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
                
              </div>

              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Login</button>
               </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>



</head>
</html>