


<%@page  contentType="text/html;charset=UTF-8" %>

<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<meta-charset="utf-8"/>
<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.0.0/mdb.min.css"
  rel="stylesheet"
/>
</head>
<body style="background-image:url('https://cdn.ttgtmedia.com/visuals/ComputerWeekly/Hero%20Images/sport-football-1-adobe.jpeg');background-size:cover;background-attachment:fixed;background-position:center">
<nav class="navbar navbar-expand-lg navbar-light bg-success ">
  <div class="container-fluid">
 <a class="nav-link active text-white text-center fixed-center" style="font-size:25px;font-wieght:boold" href="#">Football <span>2021</span> </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">

    </div>
  </div>
</nav>
<div class="container">
<div class="row">

<div class="row row-cols-1 row-cols-md-3 g-4">

 <div class="col">
    <div class="card">
      <img height="300px"
        src="https://media2.giphy.com/media/238t8hkKbZombOLDks/giphy.gif"
        class="card-img-top"
        alt="..."
      />
      <div class="card-body">
        <h5 class="card-title">Joueur</h5>
       <a href="JoueurController"  > <li class="list-group-item  ">Gestion Joueur</li></a>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <img height="300px"
        src="https://www.lequipe.fr/_medias/img-photo-jpg/la-selection-du-portugal-solidaire-du-football-amateur-franck-faugere-l-equipe/1500000001326871/0:0,1995:1330-624-416-75/5a052.jpg"
        class="card-img-top"
        alt="..."
      />
      <div class="card-body">
        <h5 class="card-title">Equipe</h5>
         <a href="EquipeController"> <li class="list-group-item ">Equipe</li></a>
      </div>
    </div>
  </div>

  <div class="col">
    <div class="card">
      <img
        src="https://i.makeagif.com/media/3-05-2018/of6vl_.gif"
        class="card-img-top" height="300px"
        alt="..."
      />
      <div class="card-body">
        <h5 class="card-title">Match</h5>
          <a href="MatchController"> <li class="list-group-item   ">Match</li></a>
      </div>
    </div>
  </div>
 <div class="col">
      <div class="card">
        <img
          src="https://media.istockphoto.com/vectors/cartoon-soccer-referee-giving-red-card-vector-id968704042" height="300px"
          class="card-img-top"
          alt="..."
        />
        <div class="card-body">
          <h5 class="card-title">Les Cartes </h5>
    <a href="ResultatController"><li class="list-group-item ">Cartes</li></a>

        </div>
      </div>
    </div>

    <div class="col">
      <div class="card">
        <img
          src="https://media.toucharger.com/web/toucharger/upload/image_domain/7/6/76429/76429.gif" height="300px"
          class="card-img-top"
          alt="..."
        />
        <div class="card-body">
          <h5 class="card-title">Tournoi </h5>
             <a href="TournoiController"> <li class="list-group-item ">Tournoi</li></a>

        </div>
      </div>
    </div>
    <div class="col">
      <div class="card">
        <img
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZ71-Z7EXA1jTrhdqBIWFXfr_Pi1XI9O4oaA&usqp=CAU"
          class="card-img-top" height="300px"
          alt="..."
        />
        <div class="card-body">
          <h5 class="card-title">Resultat du Match </h5>
             <a href="EtatJoueurController"><li class="list-group-item ">Les Resultats finale  </li></a>

        </div>
      </div>
    </div>



<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.0.0/mdb.min.js"
></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</div>
</div>
</body>
</html>
