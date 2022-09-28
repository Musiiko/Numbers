package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(urlPatterns = "/sort/numbers")
public class SortNumbersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numbers = req.getParameter("numbers");

        String[] numbs = numbers.split(",");

        int[] ints = Arrays.stream(numbs).mapToInt(Integer::parseInt).sorted().toArray();

        resp.getWriter().println(Arrays.toString(ints));
    }
}
