package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;

public class Miothread extends Thread{
    Socket s;
    public Miothread(Socket s){
        this.s =s;
    }

    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            String numero;
            Random random = new Random();
            String messaggio;
            do{ 
                numero = in.readLine();
                int numeroDaIndovinare = random.nextInt(100);
                String indovina = Integer.toString(numeroDaIndovinare);

                int numeroInt = Integer.parseInt(numero);
                if(indovina.equals(numero)){
                    messaggio="=";
                    out.writeBytes(messaggio + "\n");
                }
                else if(numeroDaIndovinare > numeroInt){
                    messaggio="<";
                    out.writeBytes(messaggio + "\n");
                }
                else if(numeroDaIndovinare < numeroInt){
                    messaggio=">";
                    out.writeBytes(messaggio + "\n");
                }
                
                
            }while(true);//da cambiare
            

            

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
