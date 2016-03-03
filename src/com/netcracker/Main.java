package com.netcracker;

//import java.nio.file.Files;

import java.lang.String;
import java.util.*;

import static java.nio.file.Files.newDirectoryStream;

class Main {


    public static void main(String[] args) {
        CurrentPath way= new CurrentPath();
        Scanner arrow =new Scanner(System.in);
        System.out.println("Hello, this is test version of jar dependency checker.");//Console app
        System.out.println("To continue choose option.\n1.Search in program folder\n2.Search in upper folder\n3.Search in custom folder\n4. ../testJars\n0. Exit");
        int n=arrow.nextInt();

        switch (n){
            case 1: way.address=way.getPathToWork();
                break;
            case 2: way.address=way.getUpperPathToWork();
                break;
            case 3:
                way.getCustomPath();
                break;
            case 4:
                way.SpecialPath1();
                break;

            case 0:return;
            default:way.address=way.getPathToWork();
                break;
        }

        System.out.print("You're in ");
        way.printCurrentPath();
        System.out.println("Let's begin to work.");
        try{Thread.sleep(1000);
        }catch (InterruptedException a){}
        System.out.print("Folder scan");
        try{Thread.sleep(1000);
        }catch (InterruptedException a){}
        System.out.print(".");
        try{Thread.sleep(1000);
        }catch (InterruptedException a){}
        System.out.print(".");
        try{Thread.sleep(1000);
        }catch (InterruptedException a){}
        System.out.print(".");
        try{Thread.sleep(1500);
        }catch (InterruptedException a){}
        FilesInclude fileList=new FilesInclude(way.address);


        fileList.printFilesList();
        way.printCurrentFolder();
        System.out.println(fileList.jarList.size());
        // JarDiscovery() нам надо адрес и имена.

        if(!fileList.jarList.isEmpty()) {
            JarDiscovery jar = new JarDiscovery(way.address, fileList.jarAddressList);
            //jar.getManifestInfo();
        }










    }


}






        /*
        ArrayList<String> fileList;

        String vl=null;
        File fl=null;
        try {

             fl = new File("");
            vl = fl.getName();
            System.out.println("file name"+vl);
        }catch (Exception e)
                {
                 e.printStackTrace();
                }
        }
        */

        /*
        for(int i=0; i<fList.length; i++)
        {
            //Нужны только папки в место isFile() пишим isDirectory()
            if(fList[i].isFile())
                System.out.println(String.valueOf(i) + " - " + fList[i].getName());
        }
        */


/* format
1 String FileName(space)v.(version)(4 numbers with dots)
Cernel v10.15.15.1000
 */


 /*
        Path address =Paths.get("");
        address.toAbsolutePath();


        ArrayList files[];
        try (DirectoryStream<Path> dirStream = newDirectoryStream(address)) {
            for (Path path : dirStream) {
                if (isRegularFile(path)) {
                    out.print("  ");
                    out.println(path.getFileName());

                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    */


