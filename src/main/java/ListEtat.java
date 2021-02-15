import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
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

@WebServlet("/ListEtat")
public class ListEtat extends HttpServlet {
    WebResource service =null;



    @Override
    public void init() throws ServletException {
        super.init();
        //configurer le client REST le service web
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        URI uri = UriBuilder.fromUri("http://localhost:9999/webAppREST/rest/jour").build();
        service = client.resource(uri);

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer l'action
        HttpSession session =req.getSession(true);
        String action = (String) req.getParameter("action");

        if (action.equals("supprimer"))
        {
            // en cas de supression
            //Appeler le path ("/{id}/delete") pour supprimer la personne ayant l'id en paramètre
            String idString = (String) req.getParameter("id");
            int id =Integer.parseInt(idString);
            WebResource path= service.path("/"+id+"/delete");
            String rep= path.delete(String.class);
            System.out.println(rep);
            req.getRequestDispatcher("/EtatJoueurController").forward(req, resp);
        }
        else
        {
            if (action.equals("editer"))
            {
                // en cas d'édition
                String idString = (String) req.getParameter("id");
                int id =Integer.parseInt(idString);
                WebResource path= service.path("/"+id+"/get");
                String rep= path.accept(MediaType.APPLICATION_JSON).get(String.class);
                System.out.println(rep);
                // transformer la réponse au format "JSON" en  objet "" en utilisant l'API gson de Goog
                Gson gson = new GsonBuilder().create();
                if (!rep.equals("null")) // s'il existe au moins un objet ""
                {

                    // récupérer l'objet JSON rendu par la réponse
                    JsonObject jo = new JsonParser().parse(rep).getAsJsonObject();
                    // convertir la réponse JSON en objet ""
                    Jour j = gson.fromJson(jo, Jour.class);
                    //Passer l'objet "pers" comme un attribut dans la requête
                    req.setAttribute("jour",j);

                }

                req.getRequestDispatcher("/FormEtat.jsp").forward(req, resp);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }
}