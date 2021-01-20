import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("webDirectory/formservlet.html")
public class FormServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numberOfTeams = request.getParameter("teams");
        String numberOfGames = request.getParameter("games");

        int teamCt = 0;
        int gameCt = 0;
        try {
            teamCt = Integer.parseInt(numberOfTeams);
            gameCt = Integer.parseInt(numberOfGames);
        } catch (NumberFormatException e) {
            teamCt = 0;
            gameCt = 0;
        }

        System.out.println("Number of Teams: " + numberOfTeams);
        System.out.println("Number of Games: " + numberOfGames);

        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        String htmlResponse = "<!DOCTYPE html>";
        htmlResponse += "<html>";
        htmlResponse += "<header>";
        htmlResponse += "<title>Generation<title>";
        if (teamCt > 1 && gameCt > 1) {
            htmlResponse += "<meta charset=\"utf-8\">";
            htmlResponse += "<h2>Form submission successful!</h2>";
        } else {
            htmlResponse += "<meta http-equiv=\"refresh\" content=\"3\" url=\"html/index.html\">";
            htmlResponse += "<h2>Error in form responses, redirecting back to form in 3 seconds</h2>";
        }
        htmlResponse += "</header>";
        htmlResponse += "</html>";

        writer.println(htmlResponse);
    }
}