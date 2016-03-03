package com.netcracker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

import static java.nio.file.Files.newDirectoryStream;

/**
 * Created by Admin on 2/26/2016.
 */
public class JarDiscovery {
    private Path address;
    private ArrayList<Path> jarLoc;
    private ArrayList<String> fileList;
    private Gson verList;


    public JarDiscovery(Path add, ArrayList<Path> files) {
        address = add;
        jarLoc = files;
        //check();
        verList=new GsonBuilder().setPrettyPrinting().create();



    }

    public void jarExplore(){


        try{
            Writer writer = new FileWriter("Output.json");
            for(int i=0;i<jarLoc.size();i++){

                InputStream inp=new FileInputStream(jarLoc.get(i).toString());
                JarInputStream jInp=new JarInputStream(inp);
                Manifest manifest=jInp.getManifest();
                Attributes attr = manifest.getMainAttributes();
                String version=attr.getValue("Version");
                System.out.println(jarLoc.get(i).getFileName()+" "+version);
                //String json=verList.toJson(jarLoc.get(i).getFileName()+" "+version);
                verList.toJson(jarLoc.get(i).getFileName()+" "+version, writer);





            }
            writer.close();

        }catch (Exception e){
            System.out.println("oops!");
        }

    }


    void check() {
        System.out.println(address);
        for (int i = 0; i < jarLoc.size(); i++) {
            System.out.println(jarLoc.get(i));
        }

    }


}
//
//
//    }//All is ok. Great!

//    void fillLoc(){
//        try (DirectoryStream<Path> dirStream = newDirectoryStream(address))
//
//        {
//            for (Path path : dirStream) {
//                int i=0;
//
//                if (isRegularFile(path)) {
//
//                    if (fileList.contains(path.getFileName().toString())) {
//                        //jarLoc.add(path.toAbsolutePath());
//                        //System.out.println(jarLoc.size());
//                        //System.out.println(jarLoc.get(i));
//                        i++;
//                    }
//                }
//
//
//                }
//
//
//        } catch (IOException e) {
//            System.err.println(e);
//        }

//    }
