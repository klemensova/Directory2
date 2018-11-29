<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="cz.directory.bean.Entry"
    import="cz.directory.bean.EntryList"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Telephone Directory</title>
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
  <div class ="block">
    <h1>Telephone Directory</h1>
    <form action="actionservlet" method="post">
    <button type="submit" name="action" value="writeList" class="button">Zobrazit</button>
    
     <button type="submit" name="action" value="select" class="button2">Vyhledat</button>
     <input type="text" name="select" placeholder="hledat" value="" class="fulltext">
    <br/>
    <br/>
   <br/>
   
   <a href="newentry.jsp" class="light">Vytvořit nový záznam</a>
    <br/>
    <br/>
   <br/>
    <table>
      <thead>
        <tr>
          <td class="slim">Aktivní</td>
          <td class="slim">ID</td>
          <td class="wide">Jméno</td>
          <td class="wide">Příjmení</td>
          <td class="wide">Tel.číslo</td>
        </tr>
      </thead>
      <tbody>
      
	<%
						EntryList entrylist = (EntryList) request.getAttribute("entrylist");
						if (entrylist  != null) {
							for (Entry entry : entrylist.getEntrylist()) {
					%>
	
	  <tr>
        <td class="slim"><input type="radio" name="idRadio" value="<%=entry.getIdDir()%>"></td>
        <td class="slim"><%=entry.getIdDir()%></td>
        <td class="wide"><%=entry.getFirstname()%></td>
        <td class="wide"><%=entry.getSurname()%></td>
        <td class="wide"><a href="" class="dark">tel:<%=entry.getPhoneNumber()%></a></td>
          </tr>
          	<%
						}
							
						}
						
					
					%>
				
      </tbody>
    
    </table>
          
          <button type="submit" name="action" value= "edit" class="button">Upravit</button>
          <button type="submit" name="action" value= "del" class="button">Smazat</button>
      </form>
      </div>
  </body>
</html>