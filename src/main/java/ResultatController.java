import com.google.gson.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import services.Joueur;
import services.Result;

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

@WebServlet("/ResultatController")
public class ResultatController extends HttpServlet {
    WebResource service =null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        afficherListeResultat(req,resp);

    }

    @Override
    public void init() throws ServletException {
        super.init();
        //configurer le client REST le service web
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        URI uri = UriBuilder.fromUri("http://localhost:9999/webAppREST/rest/result/").build();
        service = client.resource(uri);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (String) req.getParameter("id");
        String id_eq = (String) req.getParameter("id_eq");
        String id_mat = (String) req.getParameter("id_mat");
        String id_jour = (String) req.getParameter("id_jour");
        String nom_joueur = (String) req.getParameter("nom_joueur");
        String carte_j = (String) req.getParameter("carte_j");
        String carte_r = (String) req.getParameter("carte_r");
        String etat = (String) req.getParameter("etat");

        int carteJ =Integer.parseInt(carte_j);
        int carteR =Integer.parseInt(carte_r);
        int idJ =Integer.parseInt(id);
       int id_eqq=Integer.parseInt(id_eq);
       int id_matt=Integer.parseInt(id_mat);
       int id_jourr=Integer.parseInt(id_jour);
        String mode=req.getParameter("mode");
        Result r=new Result(idJ,id_eqq,id_matt,id_jourr,nom_joueur,carteJ,carteR,etat);

        System.out.println("Objet nouvellement créé:"+r);
        if (mode.equals("ajout"))
        {
            System.out.println("POST....");
            WebResource path = service.path("ajout");
            String rep = path.post(String.class, r);
            System.out.println(rep);

        }
        else
        {
            if (mode.equals("edit"))
            {
                System.out.println("PUT....");
                WebResource path = service.path("up");
                String rep = path.put(String.class, r);
                System.out.println(rep);

            }


        }

        afficherListeResultat(req, resp);


    }

    private void afficherListeResultat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //référencer la méthode "getAll"
        WebResource resource1= service.path("getAll");
        //passer la méthode "get"
        String reponse1= resource1.accept(MediaType.APPLICATION_JSON).get(String.class);
        // Afficher la réponse textuelle
        System.out.println(reponse1);

        List<Result> listRes=null;
        Gson gson = new GsonBuilder().create();
        if (!reponse1.equals("null")) // s'il existe au moins un objet ""
        {
            // créer une liste vide de
            listRes = new ArrayList<Result>();
            // récupérer l'objet JSON rendu  la réponse
            JsonObject jo = new JsonParser().parse(reponse1).getAsJsonObject();

            if (jo.get("reslt").isJsonArray())  // en cas de plusieurs
            {
                JsonArray jsonArray  = jo.getAsJsonArray("reslt");

                Result[] listeE = gson.fromJson(jsonArray, Result[].class);
                for (Result j : listeE) {
                    listRes.add(j);
                }
            }
            else
            {
                JsonObject jsonObject = jo.getAsJsonObject("reslt");
                Result res = gson.fromJson(jsonObject, Result.class);
                listRes.add(res);

            }
        }
        else
        {
            System.out.println("Aucune resultat  n'est trouvée..");
        }

        req.setAttribute("listResultat",listRes);
        req.getRequestDispatcher("ListResultat.jsp").forward(req,resp);
    }



}
