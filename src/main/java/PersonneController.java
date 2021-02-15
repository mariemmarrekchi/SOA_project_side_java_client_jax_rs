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
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/PersonneController")
public class PersonneController extends HttpServlet {
    WebResource service =null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession(true);
        req.getRequestDispatcher("UserForm.jsp").forward(req, resp);

    }

    @Override
    public void init() throws ServletException {
        super.init();
        //configurer le client REST le service web
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        URI uri = UriBuilder.fromUri("http://localhost:9999/webAppREST/rest/personne").build();
        service = client.resource(uri);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

// TODO Auto-generated method stub
        PrintWriter out = resp.getWriter();
        //Récupérer la valeur du paramètre login"
        String l = req.getParameter("nom");
        //Afficher la valeur du paramètre
        out.println("La valeur du nom est:"+l);
        //Récupérer la valeur du paramètre password"
        String pwd = req.getParameter("age");
        //Afficher la valeur du paramètre
        out.println("La valeur du mot de passe est:"+pwd);
        // Création d'un tableau vide d"erreurs
            // En cas d'absence d'erreurs de saisie
            // Appeler l'objet métier pour vérifier les paramètres de connexion
        WebResource path= service.path("/"+l+"/"+pwd+"/getByNom");
        String rep= path.get(String.class);
        System.out.println(rep);
            if( rep!=null)
            {
                // utilisateur reconnu
                //Récupérer une session
                HttpSession session =req.getSession(true);
                //Placer l'objet "User" comma attribut dans la session
                session.setAttribute("user", rep);
                 session =req.getSession(true);
                req.getRequestDispatcher("UserForm.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("index.jsp").forward(req, resp);

            }

        }


    }






