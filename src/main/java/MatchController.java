import com.google.gson.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import services.Match;
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

@WebServlet("/MatchController")
public class MatchController extends HttpServlet {
    WebResource service =null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        afficherListeMatch(req,resp);

    }

    @Override
    public void init() throws ServletException {
        super.init();
        //configurer le client REST le service web
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        URI uri = UriBuilder.fromUri("http://localhost:9999/webAppREST/rest/match/").build();
        service = client.resource(uri);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void afficherListeMatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //référencer la méthode "getAll"
        WebResource resource1= service.path("getAll");
        //passer la méthode "get"
        String reponse1= resource1.accept(MediaType.APPLICATION_JSON).get(String.class);
        // Afficher la réponse textuelle
        System.out.println(reponse1);
        List<Match> listeMatch=null;
        Gson gson = new GsonBuilder().create();
        if (!reponse1.equals("null")) // s'il existe au moins un objet ""
        {
            // créer une liste vide de
            listeMatch = new ArrayList<Match>();
            // récupérer l'objet JSON rendu  la réponse
            JsonObject jo = new JsonParser().parse(reponse1).getAsJsonObject();

            if (jo.get("match").isJsonArray())  // en cas de plusieurs
            {
                JsonArray jsonArray  = jo.getAsJsonArray("match");

                Match[] listeE = gson.fromJson(jsonArray, Match[].class);
                for (Match j : listeE) {
                    listeMatch.add(j);
                }
            }
            else
            {  // en cas d'un seul objet ""
                JsonObject jsonObject = jo.getAsJsonObject("match");
                Match joueur = gson.fromJson(jsonObject, Match.class);
                listeMatch.add(joueur);

            }
        }
        else
        {
            System.out.println("Aucun match  n'est trouvée..");
        }
        // rediriger vers la page ".jsp"
        req.setAttribute("listMatch",listeMatch);
        req.getRequestDispatcher("ListMatch.jsp").forward(req,resp);
    }



}
