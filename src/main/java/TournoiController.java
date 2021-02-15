import com.google.gson.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import services.Result;
import services.Tournoir;

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

@WebServlet("/TournoiController")
public class TournoiController extends HttpServlet {
    WebResource service =null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        afficherListeTournoi(req,resp);

    }

    @Override
    public void init() throws ServletException {
        super.init();
        //configurer le client REST le service web
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        URI uri = UriBuilder.fromUri("http://localhost:9999/webAppREST/rest/tournoir/").build();
        service = client.resource(uri);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doPost(req, resp);
        //Récupérer les paramètres du formulaire


    }

    private void afficherListeTournoi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebResource resource1= service.path("getAll");
        //passer la méthode "get"
        String reponse1= resource1.accept(MediaType.APPLICATION_JSON).get(String.class);
        // Afficher la réponse textuelle
        System.out.println(reponse1);

        List<Tournoir> listRes=null;
        Gson gson = new GsonBuilder().create();
        if (!reponse1.equals("null"))
        {

            listRes = new ArrayList<Tournoir>();
            // récupérer l'objet JSON rendu  la réponse
            JsonObject jo = new JsonParser().parse(reponse1).getAsJsonObject();

            if (jo.get("tourn").isJsonArray())  // en cas de plusieurs
            {
                JsonArray jsonArray  = jo.getAsJsonArray("tourn");

                Tournoir[] listeE = gson.fromJson(jsonArray, Tournoir[].class);
                for (Tournoir j : listeE) {
                    listRes.add(j);
                }
            }
            else
            {  // en cas d'un seul objet ""
                JsonObject jsonObject = jo.getAsJsonObject("tourn");
                Tournoir res = gson.fromJson(jsonObject, Tournoir.class);
                listRes.add(res);

            }
        }
        else
        {
            System.out.println("Aucune tour  n'est trouvée..");
        }

        req.setAttribute("listTournoir",listRes);
        req.getRequestDispatcher("ListTournoi.jsp").forward(req,resp);
    }



}
