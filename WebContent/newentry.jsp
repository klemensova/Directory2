<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Vytvořit nový záznam</title>
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
  <div class="block2">
    <h1>Nový záznam</h1>
    <form action="actionservlet" method="get">
    <label for="firstname">Zadej jméno</label>
    <br/>
   <input type="text" name="firstname" class="fulltext1" maxlength="12" required>
      <br/>
      <label for="surname">Zadej příjmení</label>
      <br/>
      <input type="text" name="surname" class="fulltext1" maxlength="18" required>
      <br/>
      <label for="phoneNumber">Zadej telefonní číslo</label>
      <br/>
      <input type="text" name="phoneNumber" class="fulltext1" maxlength="13" required>
      <br/>
      <br/>
      <button type="submit" name="action" value="add" class="button">Vložit</button>
    </form>
    </div>
  </body>
</html>