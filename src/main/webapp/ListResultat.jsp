<%@page  contentType="text/html;charset=UTF-8" %>
<%@page import ="java.util.ArrayList" %>
<%@page import ="java.util.List" %>
<%@page import ="java.util.Iterator" %>
<%@page import ="services.Result" %>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body >
<h2 class="text-center text-success" style="margin-top:50px">Liste des Cartes pour chaque joueur dasn une journée </h2>
<input id="myInput" type="text" placeholder="Search..">
<div class="container">
<%
// récupérer la liste des result
List <Result> lp= (ArrayList<Result>) request.getAttribute("listResultat");
if (lp==null)
{
  out.println("<h1> Aucune Carte existante</h1>");
  out.println("  <a class='btn btn-success' href ='FormCarte.jsp'>Ajouter un nouveau Joueur </a>");
out.println("  <a href='/rest_arc/IndexController'><button class='btn btn-primary'> retour</button></a>");

}
else
{

%>
<a class="btn btn-success" href ="FormCarte.jsp">Ajouter un nouveau Joueur </a>
<a href="/rest_arc/IndexController"><button class="btn btn-primary"> retour</button></a>
<table style="margin-top:20px" class="table table-striped table-hover">
  <tr class="table-dark">
  <th>N°</th>
  <th>Equipe</th>
  <th> Match</th>
  <th>Journée</th>
  <th>Nom Joueur </th>
  <th>Carte Jaune </th>
  <th> carte Rouge </th>
  <th> Etat</th>
  </tr>
<tbody id="myTable">
  <%
  int i=1;
   for (Iterator it = lp.iterator(); it.hasNext();)
   {

       Result r= (Result)it.next();
       out.println("<tr><td>"+i+"</td>");

       out.println("<td><a href='EquipeController'>"+r.getId_eq()+"</a></td>");
       out.println("<td><a href='MatchController'> "+r.getId_mat()+"</a></td>");
       out.println("<td><a href='EtatJoueurController'>"+r.getId_jour()+"</a></td>");
       out.println("<td>"+r.getNom_joueur()+"</td>");
       out.println("<td> <img src='https://image.freepik.com/photos-gratuite/main-arbitre-carton-jaune_9083-2170.jpg' width='100px'/>  "+r.getCarte_j()+"</td>");
       out.println("<td> <img src='https://img2.freepng.fr/20180626/afo/kisspng-red-card-yellow-card-credit-card-association-footb-5b3284f56d8bc2.8815497515300374934487.jpg' width='100px'/>"+r.getCarte_r()+"</td>");

       out.println("<td>"+r.getEtat()+"</td>");

       i++;
   }
  %>
</tbody>
</table>
</form>
<%
}
%>

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
