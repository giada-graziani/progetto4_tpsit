package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("server partito...");
        ServerSocket so= new ServerSocket();
        
        do{
            Socket s= new Socket();
            Miothread t= new Miothread(s);
            t.start();

        }while(true);
    }
}