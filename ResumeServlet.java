import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResumeServlet")
public class ResumeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("generate".equals(action)) {
            generateResume(response, request);
        } else if ("save".equals(action)) {
            saveResume(response, request);
        }
    }

    private void generateResume(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Collect parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String nationality = request.getParameter("nationality");
        String dob = request.getParameter("dob");
        String maritalStatus = request.getParameter("marital_status");
        String hobbies = request.getParameter("hobbies");
        String references = request.getParameter("references");
        String summary = request.getParameter("summary");
        String education = request.getParameter("education");
        String experience = request.getParameter("experience");
        String skills = request.getParameter("skills");

        // Generate HTML resume
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Generated Resume</title>");
        out.println("<style>");
        out.println("body { font-family: ArialTimes new Roman, sans-serif; background-color: #e0f7fa; margin: 0; padding: 20px; }");
        out.println(".resume-container { width: 170mm; height: 297mm; background: #ffffff; padding: 20px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); margin: auto; }");
        out.println("h1 { text-align: center; color: #00796b; }");
        out.println("h2 { color: #00796b; border-bottom: 2px solid #00796b; padding-bottom: 5px; }");
        out.println("p { font-size: 16px; line-height: 1.5; margin: 10px 0; }");
        out.println("hr { border: 0; border-top: 1px solid #ddd; margin: 20px 0; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='resume-container'>");
        out.println("<h1>Generated Resume</h1>");
        out.println("<h2>" + name + "</h2>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("<p><b>Phone:</b> " + phone + "</p>");
        out.println("<p><b>Nationality:</b> " + nationality + "</p>");
        out.println("<p><b>Date of Birth:</b> " + dob + "</p>");
        out.println("<p><b>Marital Status:</b> " + maritalStatus + "</p>");
        out.println("<p><b>Hobbies:</b> " + hobbies + "</p>");
        out.println("<p><b>Address:</b> " + address + "</p>");
        out.println("<hr>");
        out.println("<h3>Professional Summary</h3>");
        out.println("<p>" + summary + "</p>");
        out.println("<hr>");
        out.println("<h3>Education</h3>");
        out.println("<p>" + education + "</p>");
        out.println("<hr>");
        out.println("<h3>Experience</h3>");
        out.println("<p>" + experience + "</p>");
        out.println("<hr>");
        out.println("<h3>Skills</h3>");
        out.println("<p>" + skills + "</p>");
        out.println("<p><b>References:</b> " + references + "</p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    private void saveResume(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment; filename=\"resume.doc\"");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String nationality = request.getParameter("nationality");
        String dob = request.getParameter("dob");
        String maritalStatus = request.getParameter("marital_status");
        String hobbies = request.getParameter("hobbies");
        String references = request.getParameter("references");
        String summary = request.getParameter("summary");
        String education = request.getParameter("education");
        String experience = request.getParameter("experience");
        String skills = request.getParameter("skills");

        // Generate DOC file content
        String content = "Resume\n\n" +
                         "Name: " + name + "\n\n" +
                         "Email: " + email + "\n\n" +
                         "Phone: " + phone + "\n\n" +
                         "Nationality: " + nationality + "\n\n" +
                         "Date of Birth: " + dob + "\n\n" +
                         "Marital Status: " + maritalStatus + "\n\n" +
                         "Hobbies: " + hobbies + "\n\n\n" +
                         "Address: " + address + "\n\n\n" +
                         "Professional Summary:\n" + summary + "\n\n\n" +
                         "Education:\n" + education + "\n\n\n" +
                         "Experience:\n" + experience + "\n\n\n" +
                         "Skills:\n" + skills + "\n\n\n" +
                         "References: " + references + "\n" ;

        response.getOutputStream().write(content.getBytes());
        response.getOutputStream().flush();
    }
}
