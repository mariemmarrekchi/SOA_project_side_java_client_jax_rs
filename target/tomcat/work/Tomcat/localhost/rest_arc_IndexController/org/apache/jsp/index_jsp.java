/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-01-12 02:19:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1\" crossorigin=\"anonymous\">\n");
      out.write("<meta-charset=\"utf-8\"/>\n");
      out.write("<!-- Font Awesome -->\n");
      out.write("<link\n");
      out.write("  href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css\"\n");
      out.write("  rel=\"stylesheet\"\n");
      out.write("/>\n");
      out.write("<!-- Google Fonts -->\n");
      out.write("<link\n");
      out.write("  href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap\"\n");
      out.write("  rel=\"stylesheet\"\n");
      out.write("/>\n");
      out.write("<!-- MDB -->\n");
      out.write("<link\n");
      out.write("  href=\"https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.0.0/mdb.min.css\"\n");
      out.write("  rel=\"stylesheet\"\n");
      out.write("/>\n");
      out.write("</head>\n");
      out.write("<body style=\"background-image:url('https://cdn.ttgtmedia.com/visuals/ComputerWeekly/Hero%20Images/sport-football-1-adobe.jpeg');background-size:cover;background-attachment:fixed;background-position:center\">\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light bg-success \">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write(" <a class=\"nav-link active text-white text-center fixed-center\" style=\"font-size:25px;font-wieght:boold\" href=\"#\">Football <span>2021</span> </a>\n");
      out.write("    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNavDropdown\" aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("      <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("    </button>\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("<div class=\"container\">\n");
      out.write("<div class=\"row\">\n");
      out.write("\n");
      out.write("<div class=\"row row-cols-1 row-cols-md-3 g-4\">\n");
      out.write("\n");
      out.write(" <div class=\"col\">\n");
      out.write("    <div class=\"card\">\n");
      out.write("      <img height=\"300px\"\n");
      out.write("        src=\"https://media2.giphy.com/media/238t8hkKbZombOLDks/giphy.gif\"\n");
      out.write("        class=\"card-img-top\"\n");
      out.write("        alt=\"...\"\n");
      out.write("      />\n");
      out.write("      <div class=\"card-body\">\n");
      out.write("        <h5 class=\"card-title\">Joueur</h5>\n");
      out.write("       <a href=\"JoueurController\"  > <li class=\"list-group-item  \">Gestion Joueur</li></a>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"col\">\n");
      out.write("    <div class=\"card\">\n");
      out.write("      <img height=\"300px\"\n");
      out.write("        src=\"https://www.lequipe.fr/_medias/img-photo-jpg/la-selection-du-portugal-solidaire-du-football-amateur-franck-faugere-l-equipe/1500000001326871/0:0,1995:1330-624-416-75/5a052.jpg\"\n");
      out.write("        class=\"card-img-top\"\n");
      out.write("        alt=\"...\"\n");
      out.write("      />\n");
      out.write("      <div class=\"card-body\">\n");
      out.write("        <h5 class=\"card-title\">Equipe</h5>\n");
      out.write("         <a href=\"EquipeController\"> <li class=\"list-group-item \">Equipe</li></a>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"col\">\n");
      out.write("    <div class=\"card\">\n");
      out.write("      <img\n");
      out.write("        src=\"https://i.makeagif.com/media/3-05-2018/of6vl_.gif\"\n");
      out.write("        class=\"card-img-top\" height=\"300px\"\n");
      out.write("        alt=\"...\"\n");
      out.write("      />\n");
      out.write("      <div class=\"card-body\">\n");
      out.write("        <h5 class=\"card-title\">Match</h5>\n");
      out.write("          <a href=\"MatchController\"> <li class=\"list-group-item   \">Match</li></a>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write(" <div class=\"col\">\n");
      out.write("      <div class=\"card\">\n");
      out.write("        <img\n");
      out.write("          src=\"https://media.istockphoto.com/vectors/cartoon-soccer-referee-giving-red-card-vector-id968704042\" height=\"300px\"\n");
      out.write("          class=\"card-img-top\"\n");
      out.write("          alt=\"...\"\n");
      out.write("        />\n");
      out.write("        <div class=\"card-body\">\n");
      out.write("          <h5 class=\"card-title\">Les Cartes </h5>\n");
      out.write("    <a href=\"ResultatController\"><li class=\"list-group-item \">Cartes</li></a>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"col\">\n");
      out.write("      <div class=\"card\">\n");
      out.write("        <img\n");
      out.write("          src=\"https://media.toucharger.com/web/toucharger/upload/image_domain/7/6/76429/76429.gif\" height=\"300px\"\n");
      out.write("          class=\"card-img-top\"\n");
      out.write("          alt=\"...\"\n");
      out.write("        />\n");
      out.write("        <div class=\"card-body\">\n");
      out.write("          <h5 class=\"card-title\">Tournoi </h5>\n");
      out.write("             <a href=\"TournoiController\"> <li class=\"list-group-item \">Tournoi</li></a>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col\">\n");
      out.write("      <div class=\"card\">\n");
      out.write("        <img\n");
      out.write("          src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZ71-Z7EXA1jTrhdqBIWFXfr_Pi1XI9O4oaA&usqp=CAU\"\n");
      out.write("          class=\"card-img-top\" height=\"300px\"\n");
      out.write("          alt=\"...\"\n");
      out.write("        />\n");
      out.write("        <div class=\"card-body\">\n");
      out.write("          <h5 class=\"card-title\">Resultat du Match </h5>\n");
      out.write("             <a href=\"EtatJoueurController\"><li class=\"list-group-item \">Les Resultats finale  </li></a>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script\n");
      out.write("  type=\"text/javascript\"\n");
      out.write("  src=\"https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.0.0/mdb.min.js\"\n");
      out.write("></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW\" crossorigin=\"anonymous\"></script>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
