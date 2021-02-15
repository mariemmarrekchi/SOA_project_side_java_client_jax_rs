<%@page  contentType="text/html;charset=UTF-8" %>

<%@page import ="java.util.Iterator" %>
<%@page import ="java.util.ArrayList" %>

<%@page import ="java.util.List" %>

<%@page import ="services.Jour" %>
<%@page import ="services.Joueur" %>

<html>
<head>
<meta-charset="UTF-8"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body >
<h2 class="text-center"> Remplir les cordonnées d'un joueur </h2>

<%

// Déclarer des variables pour les valeurs des champs du formulaire
String id="0";
String date="";
String id_mat="";
String id_eq="";
String id_eq2="";
String nom_joueur ="";
String carte_j ="";
String carte_r ="";
String carte_j2 ="";
String carte_r2 ="";
String nb_bute ="";
Jour j = (Jour) request.getAttribute("jour");
List <Joueur> lp= (ArrayList<Joueur>) request.getAttribute("listJoueur");

if (j!=null)
{
System.out.println("id="+j.getId());
System.out.println("date="+j.getDate());
System.out.println("id_mat="+j.getId_mat());
System.out.println("id_eq="+j.getId_eq());
System.out.println("carte_j="+j.getCarte_j());
System.out.println("carte_r="+j.getCarte_r());
System.out.println("nb_bute="+j.getNb_bute());
System.out.println("id_eq2="+j.getId_eq2());
System.out.println("carte_j2="+j.getCarte_j2());
System.out.println("carte_r2="+j.getCarte_r2());
    id=String.valueOf(j.getId());
    date =j.getDate();
     id_mat =String.valueOf(j.getId_mat());
     id_eq =String.valueOf(j.getId_eq());
     id_eq2 =String.valueOf(j.getId_eq2());
    carte_j=String.valueOf(j.getCarte_j());
    carte_r=String.valueOf(j.getCarte_r());
  carte_j2=String.valueOf(j.getCarte_j2());
      carte_r2=String.valueOf(j.getCarte_r2());
      nb_bute=j.getNb_bute();
}

%>
<div class="container">
<form action ="EtatJoueurController" method ="post" >
<input type="hidden"  name ="mode" <%  if (j!=null) {out.println("value='edit'");} else {out.println("value='ajout'"); }  %>/>
  <div class="mb-3">

    <input type="hidden"  class="form-control"  name="id" value="<%=id%>"  id="exampleInputId"  <%  if (j!=null) out.println("readonly"); %>>

  </div>
  <div class="mb-3">
    <label for="exampleInputDate" class="form-label">Date</label>
    <input type="date" class="form-control" name="date"   value="<%=date%>"  id="exampleInputDate">
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
              <label for="exampleInputb" class="form-label">Equipe 1</label>
     <select  class="form-control"name="id_eq">

     <option value="1">Est</option>
     <option value="2">css</option>
      <option value="3">jerba</option>
       <option value="4">sousse</option>
        <option value="5">benzerte</option>
      </select>
    </div>


  <div class="mb-3">
    <label for="exampleInputj" class="form-label">carte_j</label>
    <input type="text" class="form-control"  name="carte_j" id="carte_j" value="<%=carte_j%>" id="exampleInputj">
  </div>

    <div class="mb-3">
      <label for="exampleInputr" class="form-label">carte_r</label>
      <input type="text" class="form-control"  name="carte_r" id="carte_r" value="<%=carte_r%>" id="exampleInputr">
    </div>


          <div class="mb-3">
                  <label for="exampleInputbu" class="form-label">Resultat </label>
                <input type="text" class="form-control"   name="nb_bute"  id="nb_bute" value="<%=nb_bute%>"/>
                </div>

                <div class="mb-3">
                              <label for="exampleInputb" class="form-label">Equipe 2</label>
                     <select  class="form-control"name="id_eq2">

                     <option value="1">Est</option>
                     <option value="2">css</option>
                      <option value="3">jerba</option>
                       <option value="4">sousse</option>
                              <option value="5">benzerte</option>
                      </select>
                    </div>


                  <div class="mb-3">
                    <label for="exampleInputj2" class="form-label">carte_j</label>
                    <input type="text" class="form-control"  name="carte_j2" id="carte_j2" value="<%=carte_j2%>" id="exampleInputj2">
                  </div>

                    <div class="mb-3">
                      <label for="exampleInputr2" class="form-label">carte_r</label>
                      <input type="text" class="form-control"  name="carte_r2" id="carte_r2" value="<%=carte_r2%>" id="exampleInputr2">
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
