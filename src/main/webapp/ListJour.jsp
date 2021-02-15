<%@page  contentType="text/html;charset=UTF-8" %>
<%@page import ="java.util.ArrayList" %>
<%@page import ="java.util.List" %>
<%@page import ="java.util.Iterator" %>
<%@page import ="services.Jour" %>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<meta charset="UTF-8"/>
</head>
<body >
<h2 class="text-center text-success" style="margin-top:50px">Liste des Résultat </h2>
<input id="myInput" type="text" placeholder="Search..">
<div class="container">
<%

List <Jour> lp= (ArrayList<Jour>) request.getAttribute("listJour");
if (lp==null)
{
  out.println("<h1> Aucune information  existante</h1>");
  out.println(" <a class='btn btn-success' href ='FormEtat.jsp'>Ajouter un nouveau  Etat Joueur dans une  journée </a>");
out.println(" <a href='/rest_arc/IndexController'><button class='btn btn-primary'> retour</button></a>");
}
else
{

%>
<a class="btn btn-success" href ="FormEtat.jsp">Ajouter un nouveau  Etat Joueur dans une  journée </a>
<a href="/rest_arc/IndexController"><button class="btn btn-primary"> retour</button></a>
<table style="margin-top:20px" class="table table-striped table-hover">
  <tr class="table-dark">
  <th>N°</th>
  <th>date</th>
  <th>Match</th>
  <th>Equipe 1 </th>
  <th>carte jaune </th>
  <th>carte rouge</th>
   <th>Equipe 2 </th>
    <th>carte jaune </th>
     <th>carte rouge</th>
  <th>Resultat</th>
  <th colspan="2">Action</th>
  </tr>
<tbody id="myTable">
  <%
  int i=1;
  int nb=0;
   for (Iterator it = lp.iterator(); it.hasNext();)
   {

       Jour p= (Jour)it.next();
       nb+=p.getCarte_r()+(p.getCarte_j()/3);
       out.println("<tr><td>"+i+"</td>");

        out.println("<td>"+p.getDate()+"</td>");
        out.println("<td>  <a href='MatchController'>"+p.getId_mat()+"</a></td>");
        out.println("<td > <a href='EquipeController'>"+p.getId_eq()+"</a></td>");
       out.println("<td class='bg-warning'>"+p.getCarte_j()+"</td>");
       out.println("<td class='bg-danger'>"+p.getCarte_r()+"</td>");
       out.println("<td > <a href='EquipeController'>"+p.getId_eq2()+"</a></td>");
 out.println("<td class='bg-warning'>"+p.getCarte_j2()+"</td>");
       out.println("<td class='bg-danger'>"+p.getCarte_r2()+"</td>");
       out.println("<td>"+p.getNb_bute()+"</td>");
       out.println("<td><a  class='btn btn-warning' href='ListEtat?action=editer&id="+p.getId()+"'>Editer</a></td>");
       out.println("<td><a   class='btn btn-danger' href='ListEtat?action=supprimer&id="+p.getId()+"' onclick='return confirm(\"Voulez vous vraiment supprimer ce Joueur ?\")'>Supprimer</a></td></tr>");
       i++;
   }
  %>
</tbody>
</table>
</form>
<%
}
%>


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
</div>

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
