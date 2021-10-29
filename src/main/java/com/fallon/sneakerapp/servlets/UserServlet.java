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
import java.util.HashMap;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserServices userServices;
    private ObjectMapper jacksonMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            RegisterDTO registerDTO = jacksonMapper.readValue(request.getInputStream(), RegisterDTO.class);
            response.getWriter().println(registerDTO);
            userServices = new UserServices(new UserDao(connection));
            userServices.registerUser(new User(registerDTO));

        }catch (SQLException e){
            response.getWriter().println(e.fillInStackTrace());
        } catch (Exception e) {
            response.getWriter().println(e);
        } finally {

        }
    }

}
