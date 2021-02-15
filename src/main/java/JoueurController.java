import com.google.gson.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import services.Equipe;
import services.Joueur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/JoueurController")
public class JoueurController extends HttpServlet {
    WebResource service =null;
    WebResource service2=null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        afficherListeJoueur(req, resp);
        afficherListeEquipe(req,resp);

    }

    @Override
    public void init() throws ServletException {
        super.init();
        //configurer le client REST le service web
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        URI uri = UriBuilder.fromUri("http://localhost:9999/webAppREST/rest/joueur/").build();
        URI uri1 = UriBuilder.fromUri("http://localhost:9999/webAppREST/rest/equipe/").build();
        service = client.resource(uri);
        service2 = client.resource(uri1);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doPost(req, resp);
        //Récupérer les paramètres du formulaire
        String id = (String) req.getParameter("id");
        String nom = (String) req.getParameter("nom");
        String id_eq = (String) req.getParameter("id_eq");
        String prenom=(String )req.getParameter("prenom");
        String age=(String)req.getParameter("age");
        int idJ =Integer.parseInt(id);
        int ageJ =Integer.parseInt(age);

        int idEq =Integer.parseInt(id_eq);
        String mode=req.getParameter("mode");
        Joueur j=new Joueur(idJ,nom,idEq,prenom,ageJ);

        System.out.println("Objet nouvellement créé:"+j);
        if (mode.equals("ajout"))
        {
            System.out.println("POST....");
            WebResource path = service.path("ajout");
            String rep = path.post(String.class, j);
            System.out.println(rep);

        }
        else
        {
            if (mode.equals("edit"))
            {
                System.out.println("PUT....");
                WebResource path = service.path("up");
                String rep = path.put(String.class, j);
                System.out.println(rep);

            }


        }

        afficherListeJoueur(req, resp);
    }


    private void afficherListeJoueur(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //référencer la méthode "getAll"
        WebResource resource1= service.path("getAll");
        //passer la méthode "get"
        String reponse1= resource1.accept(MediaType.APPLICATION_JSON).get(String.class);
        // Afficher la réponse textuelle
        System.out.println(reponse1);
        List<Joueur> listeJoueur=null;
        Gson gson = new GsonBuilder().create();
        if (!reponse1.equals("null")) // s'il existe au moins un objet ""
        {   listeJoueur = new ArrayList<Joueur>();
            // récupérer l'objet JSON rendu  la réponse
            JsonObject jo = new JsonParser().parse(reponse1).getAsJsonObject();

            if (jo.get("joueur").isJsonArray())  // en cas de plusieurs
            {
                JsonArray jsonArray  = jo.getAsJsonArray("joueur");

                Joueur[] listeJ = gson.fromJson(jsonArray, Joueur[].class);
                for (Joueur j : listeJ) {
                    listeJoueur.add(j);
                }
            }
            else{
                JsonObject jsonObject = jo.getAsJsonObject("joueur");
                Joueur joueur = gson.fromJson(jsonObject, Joueur.class);
                listeJoueur.add(joueur);

            }
        }
        else
        {
            System.out.println("Aucune joueur n'est trouvée..");
        }
        req.setAttribute("listJoueur",listeJoueur);
        req.getRequestDispatcher("ListJoueur.jsp").forward(req,resp);
    }


    private void afficherListeEquipe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //référencer la méthode "getAll"
        WebResource resource1= service2.path("getAll");
        //passer la méthode "get"
        String reponse1= resource1.accept(MediaType.APPLICATION_JSON).get(String.class);
        // Afficher la réponse textuelle
        System.out.println(reponse1);
        List<Equipe> listeJoueur=null;
        Gson gson = new GsonBuilder().create();
        if (!reponse1.equals("null"))
        {
            listeJoueur = new ArrayList<Equipe>();
            // récupérer l'objet JSON rendu  la réponse
            JsonObject jo = new JsonParser().parse(reponse1).getAsJsonObject();

            if (jo.get("equipe").isJsonArray())  // en cas de plusieurs
            {
                JsonArray jsonArray  = jo.getAsJsonArray("equipe");

                Equipe[] listeJ = gson.fromJson(jsonArray, Equipe[].class);
                for (Equipe j : listeJ) {
                    listeJoueur.add(j);
                }
            }
            else
            {
                JsonObject jsonObject = jo.getAsJsonObject("equipe");
                Equipe joueur = gson.fromJson(jsonObject, Equipe.class);
                listeJoueur.add(joueur);

            }
        }
        else
        {
            System.out.println("Aucune equipe n'est trouvée..");
        }
        req.setAttribute("listEquipe",listeJoueur);

    }

}
