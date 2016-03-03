package com.netcracker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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


    public JarDiscovery(Path add, ArrayList<Path> files) {
        address = add;
        jarLoc = files;
        check();


    }

    public void jarExplore(){
        try{
            for(int i=0;i<jarLoc.size();i++){

                InputStream inp=new FileInputStream(jarLoc.get(i).toString());
                JarInputStream jInp=new JarInputStream(inp);
                Manifest manifest=jInp.getManifest();
                Attributes attr = manifest.getMainAttributes();
                String version=attr.getValue("Version");
                System.out.println(version);
                




            }

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
