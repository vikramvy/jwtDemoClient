<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/registration.js"></script>

<title>Spring Boot</title>
</head>
<body>
  <h1>Patient Insurance Registration Form</h1>
  <p style="color:blue;background-color:yellow;">Token : ${token}</p>
  <hr>

  <div class="registration">
    <form action="registration" method="post" onsubmit="return validate()">
      <table>
        <tr>
          <td>First Name:<td>
          <td><input id="firstName" name="firstName"></td>
        </tr>
        <tr>
           <td>Last Name:<td>
          <td><input id="lastName" name="lastName"></td>
         </tr>
        <tr>
         <tr>
           <td>Street:<td>
          <td><input id="street" name="street"></td>
         </tr>
        <tr>
        <tr>
         <tr>
           <td>city:<td>
          <td><input id="city" name="city"></td>
         </tr>
        <tr>
        
        <tr>
         <tr>
           <td>ZipCode:<td>
          <td><input id="zipCode" name="zipCode"></td>
         </tr>
        <tr>
        
        <tr>
         <tr>
           <td>State :<td>
          <td><input id="state" name="state"></td>
         </tr>
        <tr>
        <tr>
           <td>Email:<td>
          <td><input id="email" name="email"></td>
         </tr>
        <tr>
           
         <tr>
           <td>Phone:<td>
          <td><input id="phone" name="phone"></td>
         </tr>
        <tr>
          <td><input type="submit" value="Submit"></td>
        </tr>
      </table>
    </form>
  </div>

</body>
</html>
