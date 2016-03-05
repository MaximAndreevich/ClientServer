package com.netcracker.Client;


import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;


/**
 * Created by Admin on 3/4/2016.
 */
public class Client {

    private Socket socket = null;
    private BufferedReader in = null;
    private PrintWriter out = null;

    public Client(String iP, int port, Gson file) {

        try {
            socket = new Socket(iP, port);
        } catch (IOException ioe) {
            // Cannot connect to port on given server host
            System.out.println("Cant connect to server at 11111. Make sure it is running.");
            socket = null;
        }
        if (socket == null)
            System.exit(-1);
    }


    public String connection(Gson json) throws IOException {  //Method returns json as string.
        String outPutJson = "";
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            Gson file = json;
            String str = file.toString(); //json to str convert
            out.println(str);
            out.flush();
            outPutJson = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
            out.close();
            socket.close();
        }
        return outPutJson;
    }

}



