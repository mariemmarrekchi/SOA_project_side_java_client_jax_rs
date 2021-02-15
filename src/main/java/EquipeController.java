import com.google.gson.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import services.Equipe;


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

@WebServlet("/EquipeController")
public class EquipeController extends HttpServlet {
    WebResource service =null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);

        if(session==req.getSession(true))
        {afficherListeEquipe(req,resp);}
        else{
            req.getRequestDispatcher("index.jsp").forward(req,resp);

        }

    }

    @Override
    public void init() throws ServletException {
        super.init();
        //configurer le client REST le service web
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        URI uri = UriBuilder.fromUri("http://localhost:9999/webAppREST/rest/equipe/").build();
        service = client.resource(uri);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doPost(req, resp);
        //Récupérer les paramètres du formulaire


    }

    private void afficherListeEquipe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //référencer la méthode "getAll"
        WebResource resource1= service.path("getAll");
        //passer la méthode "get"
        String reponse1= resource1.accept(MediaType.APPLICATION_JSON).get(String.class);
        // Afficher la réponse textuelle
        System.out.println(reponse1);
        List<Equipe> listeEquipe=null;
        Gson gson = new GsonBuilder().create();
        if (!reponse1.equals("null")) //
        {
            listeEquipe = new ArrayList<Equipe>();
            // récupérer l'objet JSON rendu  la réponse
            JsonObject jo = new JsonParser().parse(reponse1).getAsJsonObject();

            if (jo.get("equipe").isJsonArray())
            {
                JsonArray jsonArray  = jo.getAsJsonArray("equipe");

                Equipe[] listeE = gson.fromJson(jsonArray, Equipe[].class);
                for (Equipe j : listeE) {
                    listeEquipe.add(j);
                }
            }
            else
            {  // en cas d'un seul objet ""
                JsonObject jsonObject = jo.getAsJsonObject("equipe");
                Equipe eq = gson.fromJson(jsonObject, Equipe.class);
                listeEquipe.add(eq);

            }
        }
        else
        {
            System.out.println("Aucune equuipe n'est trouvée..");
        }

        req.setAttribute("listEquipe",listeEquipe);
        req.getRequestDispatcher("ListEquipe.jsp").forward(req,resp);
    }



}
