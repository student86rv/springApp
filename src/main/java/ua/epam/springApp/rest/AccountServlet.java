package ua.epam.springApp.rest;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.epam.springApp.model.Account;
import ua.epam.springApp.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@WebServlet(name = "AccountServlet", urlPatterns = "/api/v1/accounts")
public class AccountServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(AccountServlet.class.getName());

    private AccountService accountService;
    private Gson gson;

    @Autowired
    public AccountServlet(AccountService accountService) {
        this.accountService = accountService;
        this.gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        if (req.getParameter("id").equalsIgnoreCase("all")) {
            List<Account> accounts = accountService.getAll();
            String jsonAccount = gson.toJson(accounts);
            out.print(jsonAccount);
            out.flush();
        } else if (req.getParameter("id").matches("\\d+")) {
            long id = Long.parseLong(req.getParameter("id"));
            Account account = accountService.get(id);
            String jsonAccount = gson.toJson(account);
            out.print(jsonAccount);
            out.flush();
        } else {
            resp.sendError(400, "Id is not valid");
            logger.log(Level.WARNING, "Request with invalid Id");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Account account = gson.fromJson(req.getReader(), Account.class);
            accountService.add(account);
        } catch (Exception e) {
            resp.sendError(400, "Request body is not a valid account");
            logger.log(Level.WARNING, "Request with invalid json");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Account account = gson.fromJson(req.getReader(), Account.class);
            accountService.update(account);
        } catch (Exception e) {
            resp.sendError(400, "Request body is not a valid account");
            logger.log(Level.WARNING, "Request with invalid json");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id").matches("\\d+")) {
            long id = Long.parseLong(req.getParameter("id"));
            accountService.remove(id);
        } else {
            resp.sendError(400, "Id is not valid");
            logger.log(Level.WARNING, "Request with invalid Id");
        }
    }
}
