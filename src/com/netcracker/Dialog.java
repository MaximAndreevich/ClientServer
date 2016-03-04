package com.netcracker;


import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;


/**
 * Created by Admin on 3/4/2016.
 */
public class Dialog {

    private Socket socket = null;
    private BufferedReader in = null;
    private PrintWriter out = null;

    public Dialog(Gson pack, String iP, int port) {

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


    public String connection(Gson json) throws IOException {  // метод возвращает json ввиде строки, эту строку надо распарсить
        String outPutJson = "";
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            Gson file = json;
            String str = file.toString(); //конвертируй в стринг свой json
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



