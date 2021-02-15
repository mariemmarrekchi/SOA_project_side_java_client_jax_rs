<%@page  contentType="text/html;charset=UTF-8" %>

<%@page import ="java.util.Iterator" %>
<%@page import ="java.util.ArrayList" %>
<%@page import ="java.util.List" %>
<%@page import ="services.Result" %>

<html>
<head>
<meta-charset="UTF-8"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body >
<h2 class="text-center"> Remplir les cartes d'un match  dans une journée </h2>

<%

// Déclarer des variables pour les valeurs des champs du formulaire
String id="0";

String id_mat="";
String id_eq="";
String id_jour="";
String nom_joueur ="";
String carte_j ="";
String carte_r ="";
String etat ="";
Result r = (Result) request.getAttribute("reslt");
List <Result> lr= (ArrayList<Result>) request.getAttribute("listResultat");

if (r!=null)
{
System.out.println("id="+r.getId());
System.out.println("id_eq="+r.getId_eq());
System.out.println("id_mat="+r.getId_mat());
System.out.println("id_jour="+r.getId_jour());
System.out.println("nom_jouuer="+r.getNom_joueur());
System.out.println("carte_j="+r.getCarte_j());
System.out.println("carte_r="+r.getCarte_r());
System.out.println("etat="+r.getEtat());

    id=String.valueOf(r.getId());
     id_mat =String.valueOf(r.getId_mat());
     id_eq =String.valueOf(r.getId_eq());
     id_jour =String.valueOf(r.getId_jour());
     nom_joueur=r.getNom_joueur();
    carte_j=String.valueOf(r.getCarte_j());
    carte_r=String.valueOf(r.getCarte_r());

      etat=r.getEtat();
}

%>
<div class="container">
<form action ="ResultatController" method ="post" >
<input type="hidden"  name ="mode" <%  if (r!=null) {out.println("value='edit'");} else {out.println("value='ajout'"); }  %>/>
  <div class="mb-3">

    <input type="hidden"  class="form-control"  name="id" value="<%=id%>"  id="exampleInputId"  <%  if (r!=null) out.println("readonly"); %>>

  </div>

 <div class="mb-3">
              <label for="exampleInputb" class="form-label">Equipe</label>
     <select  class="form-control"name="id_eq">

     <option value="1">Est</option>
     <option value="2">css</option>
      <option value="3">jerba</option>
       <option value="4">sousse</option>
        <option value="5">benzerte</option>
      </select>
    </div>
 <div class="mb-3">
       <label for="exampleInputmatch" class="form-label">match</label>
     <select  class="form-control"name="id_mat">

     <option value="1">afrique</option>
     <option value="2">europe</option>
      <option value="3">asia</option>
      </select>
    </div>


 <div class="mb-3">
              <label for="exampleInputj" class="form-label">Journée</label>
     <select  class="form-control"name="id_jour">

     <option value="1">25-10-1999</option>
     <option value="2">11-01-2021</option>

      </select>
    </div>


 <div class="mb-3">
    <label for="exampleInputjo" class="form-label">nom joueur</label>
    <input type="text" class="form-control"  name="nom_joueur" id="nom_joueur" value="<%=nom_joueur%>" id="exampleInputjo">
  </div>

  <div class="mb-3">
    <label for="exampleInputj" class="form-label">carte_j</label>
    <input type="text" class="form-control"  name="carte_j" id="carte_j" value="<%=carte_j%>" id="exampleInputj">
  </div>

    <div class="mb-3">
      <label for="exampleInputr" class="form-label">carte_r</label>
      <input type="text" class="form-control" onchange="change()" name="carte_r" id="carte_r" value="<%=carte_r%>" id="exampleInputr">
    </div>


          <div class="mb-3">
                  <label for="exampleInputbu" class="form-label">Etat </label>
                <input type="text" class="form-control" readonly  name="etat"  id="etat" value="<%=etat%>"/>
                </div>



  <button type="submit" class="btn btn-primary">Ajout</button>

</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<script>
function change(){
if(document.getElementById("carte_j").value=="3" || document.getElementById("carte_r").value=="1" ){
document.getElementById("etat").value="out ->";
}
else
{
document.getElementById("etat").value="still playing";

}
}
</script>
</body>
</html>
