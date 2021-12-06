package com.fallon.sneakerapp.servlets;

import com.fallon.sneakerapp.controllers.UserController;
import com.fallon.sneakerapp.daos.UserDao;
import com.fallon.sneakerapp.dtos.RegisterDTO;
import com.fallon.sneakerapp.exceptions.InvalidCredentialsException;
import com.fallon.sneakerapp.exceptions.InvalidUserException;
import com.fallon.sneakerapp.exceptions.UserNameTakenException;
import com.fallon.sneakerapp.pojos.User;
import com.fallon.sneakerapp.services.UserServices;
import com.fallon.sneakerapp.util.ConnectionFactory;

import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet("/*")
public class DispatcherServlet extends HttpServlet {

    private Connection connection;
    private ObjectMapper objectMapper;
    private UserController userController;
    private User user;

    @Override
    public void init() {
        connection = ConnectionFactory.getInstance().getConnection();
        userController = new UserController(new UserServices(new UserDao(connection)));
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String target = parseURI(request);
        objectMapper = new ObjectMapper();
        try {
            switch (target) {
                case "register":
                    userController.registerUser(request);
                    response.setStatus(201);
                    break;

                //TODO
                //login
                case "login":
                    response.getWriter().println(userController.loginUser(request));
                    response.setStatus(202);
                    break;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }catch (UserNameTakenException e) {
            response.setStatus(403);
        }catch (InvalidCredentialsException e) {
            response.setStatus(401);
        }catch (InvalidUserException e) {
            response.setStatus(401);
        }


    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String target = parseURI(request);
        objectMapper = new ObjectMapper();

        switch (target) {
            case "test":
                response.getWriter().println("<h1>Sneaker App Deployed<h1>");
                break;
        }
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String parseURI(HttpServletRequest request) {
        String string = request.getRequestURI();
        String[] parsedStrings = string.split("/");
        return parsedStrings[parsedStrings.length - 1];
    }

    @Override
    public void destroy() {
        try {
            connection.close();
        } catch (SQLException e) {
        }
    }


}

