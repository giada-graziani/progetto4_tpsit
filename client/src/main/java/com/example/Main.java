package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client partito...");
        Scanner scanner = new Scanner(System.in);
        Socket s = new Socket("localhost", 3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String messaggio;
        String numero;
        do{
            System.out.println("indovina il numero ");
            numero = scanner.nextLine();

            out.writeBytes(numero +"\n");

            messaggio= in.readLine();
            switch (messaggio) {
                case "=":
                    System.out.println("HAI INDOVIsNATO CAMPIONE");
                    out.writeBytes(messaggio +"\n");
                    s.close();
                break;
                case "<":
                    System.out.println("numero troppo piccolo");
                    out.writeBytes(messaggio +"\n");
                break;
                case ">":
                    System.out.println("numero tropppo grande");
                    out.writeBytes(messaggio +"\n");
                break;
            
                default:
                    System.out.println("ERRORE");
                    break;
            }
            if(messaggio.equals("=")){
                S
            }
            else{

            }

        }while(!messaggio.equals("=")); 

    }
}