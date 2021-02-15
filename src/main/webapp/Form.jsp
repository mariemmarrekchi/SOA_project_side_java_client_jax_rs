<%@page  contentType="text/html;charset=UTF-8" %>
<%@page import ="services.Joueur" %>
<%@page import ="java.util.ArrayList" %>
<%@page import ="java.util.List" %>
<%@page import ="java.util.Iterator" %>
<%@page import ="services.Equipe" %>
<%@page import="com.TransportPortal.MyFunctions.* "%>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body >
<h2 class="text-center"> Remplir les cordonnées d'un joueur </h2>

<%

// Déclarer des variables pour les valeurs des champs du formulaire
String id="0";
String nom ="";
String id_eq ="";
String prenom ="";
String age ="";
// Récupérer l'objet "Personne" s'il existe (en cas de mise à jour d'un objet existant)

Joueur p = (Joueur) request.getAttribute("joueur");
if (p!=null)
{
System.out.println("id="+p.getId());
System.out.println("nom="+p.getNom());
System.out.println("id_eq="+p.getId_eq());
System.out.println("prenom="+p.getPrenom());
System.out.println("age="+p.getAge());

id=String.valueOf(p.getId());
nom =p.getNom();
prenom=p.getPrenom();
id_eq=String.valueOf(p.getId_eq());
 age=String.valueOf(p.getAge());
}

%>
<div class="container">
<form action ="JoueurController" method ="post" >
<input type="hidden"  name ="mode" <%  if (p!=null) {out.println("value='edit'");} else {out.println("value='ajout'"); }  %>/>
  <div class="mb-3">
    <input type="hidden"  class="form-control"  name="id" value="<%=id%>"  id="exampleInputId"  <%  if (p!=null) out.println("readonly"); %>>

  </div>
  <div class="mb-3">
    <label for="exampleInputNom" class="form-label">Nom</label>
    <input type="text" class="form-control" name="nom"   value="<%=nom%>"  id="exampleInputNom">
  </div>

<div >

 <div class="mb-3">
          <label for="exampleInputb" class="form-label">Equipe</label>
 <select  class="form-control"name="id_eq"  >

 <option  value="1">Est</option>
 <option  value="2">css</option>
  <option value="3">jerba</option>
   <option value="4">sousse</option>
          <option value="5">benzerte</option>
  </select>
</div>

  <div class="mb-3">
    <label for="exampleInputPrenom" class="form-label">Prenom</label>
    <input type="text" class="form-control" name="prenom"   value="<%=prenom%>"  id="exampleInputPrenom">
  </div>

<div class="mb-3">
    <label for="exampleInputAge" class="form-label">Age</label>
    <input type="text" class="form-control" name="age"   value="<%=age%>"  id="exampleInputAge">
  </div>
</div>
  <button type="submit" class="btn btn-primary">Ajout</button>

</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

<script>
function ran() {
  document.getElementById("exampleInputId").value = Math.floor(Math.random() * 10);
}
</script>
</body>
</html>
