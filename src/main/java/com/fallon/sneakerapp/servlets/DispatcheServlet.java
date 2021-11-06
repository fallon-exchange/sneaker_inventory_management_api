package com.fallon.sneakerapp.servlets;

import com.fallon.sneakerapp.daos.UserDao;
import com.fallon.sneakerapp.dtos.RegisterDTO;
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



@WebServlet
public class DispatcheServlet extends HttpServlet {

    private Connection connection;
    private ObjectMapper objectMapper;

    private User user;

    @Override
    public void init() {
            connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String target = parseURI(request);
        objectMapper = new ObjectMapper();

        try{
            switch (target) {
                case "register":
                    Connection connection = ConnectionFactory.getInstance().getConnection();
                    RegisterDTO registerDTO = objectMapper.readValue(request.getInputStream(), RegisterDTO.class);
                    response.getWriter().println(registerDTO);

                    userServices = new UserServices(new UserDao(connection));
                    userServices.registerUser(new User(registerDTO));

                //case "login"



            }
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        return parsedStrings[parsedStrings.length-1];
    }

    @Override
    public void destroy() {
        try {
            connection.close();
        } catch (SQLException e) {}
    }


}

