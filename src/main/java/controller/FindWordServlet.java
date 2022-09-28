package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@WebServlet(urlPatterns = "/find/word")
public class FindWordServlet extends HttpServlet {

    public static final String FILE_NAME = "Text.txt";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String searchedWord = req.getParameter("word");

        StringBuilder builder = new StringBuilder();

        try (InputStream ins = this.getServletContext().getResourceAsStream(FILE_NAME);
             InputStreamReader isr = new InputStreamReader(ins);
             BufferedReader reader = new BufferedReader(isr)) {

            String word;
            while ((word = reader.readLine()) != null) {
                builder.append(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int count = 0;

        String[] words1 = builder.toString().replaceAll("[.,]", "").split(" ");

        for (String w : words1) {
            if (w.equals(searchedWord)) {
                ++count;
            }
        }

        resp.getWriter().println("Word -> " + searchedWord + " is appear " + count + " times");

    }
}
