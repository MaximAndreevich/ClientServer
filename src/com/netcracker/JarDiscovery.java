package com.netcracker;

import java.nio.file.Path;
import java.util.ArrayList;

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
