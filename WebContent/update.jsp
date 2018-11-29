<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
      import="cz.directory.bean.Entry"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Upravit  záznam</title>
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
  <div class="block2">
    <h1>Upravit  záznam</h1>
    <form action="actionservlet" method="get">
    
    <jsp:useBean id="loadedEntry" scope="request" class="cz.directory.bean.Entry"/>

		<input type="hidden" name="idDir" value="<jsp:getProperty name="loadedEntry" property="idDir"/>"/>		
    <label for="firstname">Uprav jméno</label>
    <br/>
   <input type="text" name="firstname"  class="fulltext1" value="<jsp:getProperty name="loadedEntry" property="firstname"/>">
      <br/>
      <label for="firstname">Uprav příjmení</label>
      <br/>
      <input type="text" name="surname" class="fulltext1"  value="<jsp:getProperty name="loadedEntry" property="surname"/>">
      <br/>
      <label for="firstname">Uprav telefonní číslo</label>
      <br/>
      <input type="text" name="phoneNumber" class="fulltext1"  value="<jsp:getProperty name="loadedEntry" property="phoneNumber"/>">
      <br/>
      <br/>
      <button type="submit" name="action" value="update" class="button">Upravit</button>
    </form>
     </div>
  </body>
</html>