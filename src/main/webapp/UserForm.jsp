<%@ page language="java"
	import="java.util.ArrayList, java.util.Iterator"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Connexion</title>
 <link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/styl.css" />
	<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous" />
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-info">
  <div class="container">
    <a class="navbar-brand text-white" href="#">Administration :<h3><i class="text-danger">Clinique El Aliya</i></h3></a>
  </div>
</nav>
<div class="container">
<div class="row">

	<div class="col-sm-8 card text-center" style="margin-top:50px">
  <div class="card-header text-blod">Veuillez saisir vos cordonnées </div>
  <div class="card-body text-danger">


    <form class="form-group" action="PersonneController" method="POST">
    <p><label> Nom :</label>
   <input  type="text" name="nom" /></p>
    <p><label>Age :</label>
    <input type="text" name="age"
						/></p>
						<p><input class="btn btn-info" type="submit"
						value="ok " /> &nbsp <input class="btn btn-dark" type="reset" value="Annuler" /></p>
     </form>

  </div>
</div>




</div>

</div>


</div>
</div>

<nav class="navbar navbar-expand-lg navbar-light bg-info fixed-bottom" style="margin-top:100px" >
  <div class="container">
    <a class="navbar-brand text-white" href="#">© Mariem Marrekchi</a>
  </div>
</nav>
	 <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>
<div class="card bg-success hover" style="width:50rem;margin-left:20px;margin-top:200px">
  <div class="card-body">
<div class="card  text-center" >
  <ul class="list-group list-group-flush ">

    <a href="JoueurController"  > <li class="list-group-item  ">Gestion Joueur</li></a>
   <a href="EquipeController"> <li class="list-group-item ">Equipe</li></a>
   <a href="MatchController"> <li class="list-group-item   ">Match</li></a>
    <a href="ResultatController"><li class="list-group-item ">Resultat</li></a>
    <a href="EtatJoueurController"><li class="list-group-item ">Etat Joueur dans une journée d'un match </li></a>
   <a href="TournoiController"> <li class="list-group-item ">Tournoi</li></a>
  </ul>
</div>
</div>
</div>
</div>
</div>
