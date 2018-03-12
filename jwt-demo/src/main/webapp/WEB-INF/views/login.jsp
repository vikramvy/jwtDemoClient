<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/login.js"></script>

<title>Spring Boot</title>
</head>
<body>
  <h1>Please Login</h1>
  <hr>

  <div class="login">
    <form action="login" method="post" onsubmit="return validate()">
      <table>
        <tr>
          <td> UserName:<td>
          <td><input id="userName" name="userName"></td>
        </tr>
        <tr>
           <td>Password:<td>
          <td><input id="passWord" name="passWord"></td>
         </tr>
         <tr>
          <td><input type="submit" value="Submit"></td>
        </tr>
      </table>
    </form>
  </div>

</body>
</html>
