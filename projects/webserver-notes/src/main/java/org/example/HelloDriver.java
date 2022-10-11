package org.example;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class HelloDriver implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        System.out.println("[LOG] - Request received at " + LocalDateTime.now());

        // We need to parse for a GET request and do some info with that
        if (exchange.getRequestMethod().equals("GET")){
            System.out.println("[LOG] - was a GET request");

            // We'll create some information to pass back to the user
            String payload = "Hello, web!";

            // Start creating the response and then send it

            exchange.sendResponseHeaders(200, payload.length());

            // We'll write the payload to the output
            OutputStream outputStream =  exchange.getResponseBody();

            outputStream.write(payload.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();
        } else {
            exchange.sendResponseHeaders(405, 0);
            exchange.getResponseBody().close();
        }

    }
}
