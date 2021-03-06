<%@page  contentType="text/html;charset=UTF-8" %>
<%@page import ="java.util.ArrayList" %>
<%@page import ="java.util.List" %>
<%@page import ="java.util.Iterator" %>
<%@page import ="services.Tournoir" %>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body >
<h2 class="text-center text-sucess" style="margin-top:50px">Liste des Tournois</h2>
<input id="myInput" type="text" placeholder="Search..">
<div class="container">
<%
// récupérer la liste des result
List <Tournoir> lp= (ArrayList<Tournoir>) request.getAttribute("listTournoir");
if (lp==null)
{
  out.println("<h1> Aucune Tournoi existante</h1>");
}
else
{

%>
<table style="margin-top:100px" class="table table-striped table-hover">
  <tr class="table-dark">
  <th>N°</th>
  <th> Libelle</th>
  <th>date</th>

  </tr>
<tbody id="myTable">
  <%
  int i=1;
   for (Iterator it = lp.iterator(); it.hasNext();)
   {

       Tournoir r= (Tournoir)it.next();
       out.println("<tr><td>"+i+"</td>");
       out.println("<td>"+r.getLibelle()+"</td>");
       out.println("<td>"+r.getDate()+"</td>");




       i++;
   }
  %>
</tbody>
</table>
</form>
<%
}
%>
<a href="/rest_arc/IndexController"><button class="btn btn-primary"> retour</button></a>
</div>
<nav class="navbar navbar-expand-lg navbar-light bg-success fixed-bottom ">
  <div class="container-fluid">
 <a class="nav-link active text-white text-center" style="font-size:20px;font-wieght:boold"aria-current="page" href="#">© Mariem Marrekchi</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">

    </div>
  </div>
</nav>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>
