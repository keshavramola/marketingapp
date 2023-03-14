<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>new leads</title>
</head>
<body>
    <h2>New Leads</h2>
    <form action="saveLead" method = "post">
          <pre>
               First Name  <input type = "text" name = "firstName"/>
               Last Name   <input type = "text" name = "lastName"/>
               Email       <input type = "text" name = "email"/>
               Mobile      <input type = "text" name = "mobile"/>
               
                     <input type = "submit" value = "save"/>
          </pre>
    </form>
    ${msg}
</body>
</html>