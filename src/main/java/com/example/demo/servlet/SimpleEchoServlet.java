package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/simple-echo")
public class SimpleEchoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");

        String message = request.getParameter("message");

        PrintWriter out = response.getWriter();

        if (message == null || message.isEmpty()) {
            out.print("Echo:");
        } else {
            out.print("Echo: " + message);
        }

        out.flush();
    }
}
