import com.google.gson.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import services.Equipe;
import services.Joueur;
import services.Jour;
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

@WebServlet("/EtatJoueurController")
public class EtatJoueurController extends HttpServlet {
    WebResource service =null;
    WebResource service2=null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        afficherListeJoueurEtat(req, resp);


    }

    @Override
    public void init() throws ServletException {
        super.init();
        //configurer le client REST le service web
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        URI uri = UriBuilder.fromUri("http://localhost:9999/webAppREST/rest/jour/").build();
        service = client.resource(uri);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doPost(req, resp);
        //Récupérer les paramètres du formulaire
        String id = (String) req.getParameter("id");
        String date = (String) req.getParameter("date");
        String id_match = (String) req.getParameter("id_mat");
        String id_equ = (String) req.getParameter("id_eq");
        String id_equ2 = (String) req.getParameter("id_eq2");
        String carte_j = (String) req.getParameter("carte_j");
        String carte_r = (String) req.getParameter("carte_r");
        String nb_bute = (String) req.getParameter("nb_bute");
        String carte_j2 = (String) req.getParameter("carte_j2");
        String carte_r2 = (String) req.getParameter("carte_r2");
        // Convertir les deux paramètres idString et idAge en nombres entiers
        int idJ =Integer.parseInt(id);
        int id_mat =Integer.parseInt(id_match);
        int id_eq =Integer.parseInt(id_equ);
        int carteJ =Integer.parseInt(carte_j);
        int carteR =Integer.parseInt(carte_r);
        int id_eq2=Integer.parseInt(id_equ2);
        int carteJ2 =Integer.parseInt(carte_j2);
        int carteR2 =Integer.parseInt(carte_r2);
        String mode=req.getParameter("mode");


        Jour j=new Jour(idJ,date,id_mat,id_eq,carteJ,carteR,nb_bute,id_eq2,carteJ2,carteR2);

        // Afficher l'objet ""dans la console
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
                WebResource path = service.path("update");
                String rep = path.put(String.class, j);
                System.out.println(rep);

            }


        }

        afficherListeJoueurEtat(req, resp);
        //afficherListeJoueur(req,resp)

    }



    private void afficherListeJoueurEtat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //référencer la méthode "getAll"
        WebResource resource1= service.path("getAll");
        //passer la méthode "get"
        String reponse1= resource1.accept(MediaType.APPLICATION_JSON).get(String.class);
        // Afficher la réponse textuelle
        System.out.println(reponse1);

        List<Jour> listeJour=null;
        Gson gson = new GsonBuilder().create();
        if (!reponse1.equals("null"))
        {

            listeJour = new ArrayList<Jour>();
            // récupérer l'objet JSON rendu  la réponse
            JsonObject jo = new JsonParser().parse(reponse1).getAsJsonObject();

            if (jo.get("jour").isJsonArray())  //
            {
                JsonArray jsonArray  = jo.getAsJsonArray("jour");

                Jour[] listeJ = gson.fromJson(jsonArray, Jour[].class);
                for (Jour j : listeJ) {
                    listeJour.add(j);
                }
            }
            else
            {
                JsonObject jsonObject = jo.getAsJsonObject("jour");
                Jour jour = gson.fromJson(jsonObject, Jour.class);
                listeJour.add(jour);

            }
        }
        else
        {
            System.out.println("Aucune journée n'est trouvée..");
        }

        req.setAttribute("listJour",listeJour);
        req.getRequestDispatcher("ListJour.jsp").forward(req,resp);
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
        if (!reponse1.equals("null"))
        {

            listeJoueur = new ArrayList<Joueur>();
            // récupérer l'objet JSON rendu  la réponse
            JsonObject jo = new JsonParser().parse(reponse1).getAsJsonObject();

            if (jo.get("joueur").isJsonArray())
            {
                JsonArray jsonArray  = jo.getAsJsonArray("joueur");

                Joueur[] listeJ = gson.fromJson(jsonArray, Joueur[].class);
                for (Joueur j : listeJ) {
                    listeJoueur.add(j);
                }
            }
            else
            {
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




}
