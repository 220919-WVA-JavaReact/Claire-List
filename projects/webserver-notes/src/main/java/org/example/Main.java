package org.example;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
public class Main {
    public static void main(String[] args) {

        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

            //We'll create a context to allow us to handle requests at a specific location

            httpServer.createContext("/hello", new HelloHandler());

            // We'll create a new handler
            // This is what's known as local anonymous class
            // This is pre-java 8 syntax and it's pretty ugly
            httpServer.createContext("/test-1", new HttpHandler() {
                @Override
                public void handle(HttpExchange exchange) throws IOException {
                    String payload = "This request was handled by a local anonymous class!";
                    exchange.sendResponseHeaders(200, payload.length());
                    exchange.getResponseBody().write(payload.getBytes(StandardCharsets.UTF_8));
                    exchange.getResponseBody().close();
                }
            });

            // We'll create another handler using some lambda expression
            // Interfaces with only one method are known as functional interfaces
            // We can directly implement this method with a lambda
            httpServer.createContext("/test-2", exchange -> {
                // Inside of here I can directly put logic for the HttpHandler handle method
                String payload = "This request was handled by a lambda expression!";
                exchange.sendResponseHeaders(200, payload.length());
                exchange.getResponseBody().write(payload.getBytes(StandardCharsets.UTF_8));
                exchange.getResponseBody().close();
            });


            System.out.println("Server has started on port 8080");

            // Actually start the server
            httpServer.start();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}