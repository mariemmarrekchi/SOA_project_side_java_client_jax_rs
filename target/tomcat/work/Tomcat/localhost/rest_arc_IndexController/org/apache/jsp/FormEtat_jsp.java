/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-01-12 21:34:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import services.Jour;
import services.Joueur;

public final class FormEtat_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta-charset=\"UTF-8\"/>\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1\" crossorigin=\"anonymous\">\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
      out.write("<h2 class=\"text-center\"> Remplir les cordonnées d'un joueur </h2>\r\n");
      out.write("\r\n");


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


      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("<form action =\"EtatJoueurController\" method =\"post\" >\r\n");
      out.write("<input type=\"hidden\"  name =\"mode\" ");
  if (j!=null) {out.println("value='edit'");} else {out.println("value='ajout'"); }  
      out.write("/>\r\n");
      out.write("  <div class=\"mb-3\">\r\n");
      out.write("\r\n");
      out.write("    <input type=\"hidden\"  class=\"form-control\"  name=\"id\" value=\"");
      out.print(id);
      out.write("\"  id=\"exampleInputId\"  ");
  if (j!=null) out.println("readonly"); 
      out.write(">\r\n");
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"mb-3\">\r\n");
      out.write("    <label for=\"exampleInputDate\" class=\"form-label\">Date</label>\r\n");
      out.write("    <input type=\"date\" class=\"form-control\" name=\"date\"   value=\"");
      out.print(date);
      out.write("\"  id=\"exampleInputDate\">\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write(" <div class=\"mb-3\">\r\n");
      out.write("       <label for=\"exampleInputmatch\" class=\"form-label\">match</label>\r\n");
      out.write("     <select  class=\"form-control\"name=\"id_mat\">\r\n");
      out.write("\r\n");
      out.write("     <option value=\"1\">afrique</option>\r\n");
      out.write("     <option value=\"2\">europe</option>\r\n");
      out.write("      <option value=\"3\">asia</option>\r\n");
      out.write("      </select>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("     <div class=\"mb-3\">\r\n");
      out.write("              <label for=\"exampleInputb\" class=\"form-label\">Equipe 1</label>\r\n");
      out.write("     <select  class=\"form-control\"name=\"id_eq\">\r\n");
      out.write("\r\n");
      out.write("     <option value=\"1\">Est</option>\r\n");
      out.write("     <option value=\"2\">css</option>\r\n");
      out.write("      <option value=\"3\">jerba</option>\r\n");
      out.write("       <option value=\"4\">sousse</option>\r\n");
      out.write("        <option value=\"5\">benzerte</option>\r\n");
      out.write("      </select>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <div class=\"mb-3\">\r\n");
      out.write("    <label for=\"exampleInputj\" class=\"form-label\">carte_j</label>\r\n");
      out.write("    <input type=\"text\" class=\"form-control\"  name=\"carte_j\" id=\"carte_j\" value=\"");
      out.print(carte_j);
      out.write("\" id=\"exampleInputj\">\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"mb-3\">\r\n");
      out.write("      <label for=\"exampleInputr\" class=\"form-label\">carte_r</label>\r\n");
      out.write("      <input type=\"text\" class=\"form-control\"  name=\"carte_r\" id=\"carte_r\" value=\"");
      out.print(carte_r);
      out.write("\" id=\"exampleInputr\">\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("          <div class=\"mb-3\">\r\n");
      out.write("                  <label for=\"exampleInputbu\" class=\"form-label\">Resultat </label>\r\n");
      out.write("                <input type=\"text\" class=\"form-control\"   name=\"nb_bute\"  id=\"nb_bute\" value=\"");
      out.print(nb_bute);
      out.write("\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"mb-3\">\r\n");
      out.write("                              <label for=\"exampleInputb\" class=\"form-label\">Equipe 2</label>\r\n");
      out.write("                     <select  class=\"form-control\"name=\"id_eq2\">\r\n");
      out.write("\r\n");
      out.write("                     <option value=\"1\">Est</option>\r\n");
      out.write("                     <option value=\"2\">css</option>\r\n");
      out.write("                      <option value=\"3\">jerba</option>\r\n");
      out.write("                       <option value=\"4\">sousse</option>\r\n");
      out.write("                              <option value=\"5\">benzerte</option>\r\n");
      out.write("                      </select>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                  <div class=\"mb-3\">\r\n");
      out.write("                    <label for=\"exampleInputj2\" class=\"form-label\">carte_j</label>\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\"  name=\"carte_j2\" id=\"carte_j2\" value=\"");
      out.print(carte_j2);
      out.write("\" id=\"exampleInputj2\">\r\n");
      out.write("                  </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"mb-3\">\r\n");
      out.write("                      <label for=\"exampleInputr2\" class=\"form-label\">carte_r</label>\r\n");
      out.write("                      <input type=\"text\" class=\"form-control\"  name=\"carte_r2\" id=\"carte_r2\" value=\"");
      out.print(carte_r2);
      out.write("\" id=\"exampleInputr2\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("  <button type=\"submit\" class=\"btn btn-primary\">Ajout</button>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("function change(){\r\n");
      out.write("if(document.getElementById(\"carte_j\").value==\"3\" || document.getElementById(\"carte_r\").value==\"1\" ){\r\n");
      out.write("document.getElementById(\"etat\").value=\"out ->\";\r\n");
      out.write("}\r\n");
      out.write("else\r\n");
      out.write("{\r\n");
      out.write("document.getElementById(\"etat\").value=\"still playing\";\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
