
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cocog
 */
public class ShoppingListServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        
        if (request.getParameter("action") != null && request.getParameter("action").equals("logout")) 
        {
            session.invalidate();
            session = request.getSession();
        }
         
        if(session.getAttribute("username") != null) 
        {
          getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
          return;
        }
            
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        
        ArrayList<String> items = new ArrayList<>();
        
        if (request.getParameter("action").equals("Register name")) 
        {
            session.setAttribute("username", request.getParameter("username"));
        } 
        else 
        {
            items = (ArrayList<String>) session.getAttribute("items");
            
            if (request.getParameter("action").equals("add")) 
            {
                items.add(request.getParameter("item"));
            } 
            
            else if (request.getParameter("action").equals("delete")) 
            {
                items.remove(request.getParameter("item"));
            }
        }
        
        session.setAttribute("items", items);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
}
