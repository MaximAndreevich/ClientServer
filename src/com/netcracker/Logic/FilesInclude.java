package com.netcracker.Logic;


import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;
import static java.nio.file.Files.isRegularFile;
import static java.nio.file.Files.newDirectoryStream;

/**
 * Created by Admin on 2/19/2016.
 */
public class FilesInclude {
    private Path folderAddress;
    public ArrayList<String> fileList;
    public ArrayList<String> jarList;
    public ArrayList<Path> jarAddressList;
    public ArrayList<Path> allAddressList;

    public FilesInclude(Path way) {
        folderAddress = way;
        fileList=new ArrayList<String>();
        jarList=new ArrayList<String>();
        jarAddressList=new ArrayList<Path>();
        allAddressList=new ArrayList<Path>();
        fillArray();
        jarArr();
    }
    private void fillArray(){
        int i=0;

        try (DirectoryStream<Path> dirStream = newDirectoryStream(folderAddress))

        {
            for (Path path : dirStream) {

                if (isRegularFile(path)) {
                    fileList.add(path.getFileName().toString());
                    allAddressList.add((path.toAbsolutePath()));



                }
                i+=1;
            }
        } catch (IOException e) {
            System.err.println(e);
        }


    }

    public void printFilesList() {

        try (DirectoryStream<Path> dirStream = newDirectoryStream(folderAddress))

        {
            for (Path path : dirStream) {
                if (isRegularFile(path)) {
                    out.print("  ");
                    out.println(path.getFileName());
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }


    }
    //Stay only with jar files
    public void jarArr(){
        String pattern="[a-zA-Z]+\\s*[a-zA-Z]*\\u002E+(jar)";
        Pattern r=Pattern.compile(pattern);


        for(int i=0;i<this.fileList.size();i++){
            System.out.println("Step["+i+"]"+"\tjust4test");
            Matcher matcher=r.matcher(this.fileList.get(i));
            if(!matcher.matches()) {
                System.out.println("NOT PASSED WITH: "+this.fileList.get(i)+"\tjust4test");
                //fileList.remove(i);
                // i--; //to synchronize array timer
            }else{
                System.out.println("PASSED WITH: "+this.fileList.get(i)+"\tjust4test");
                this.jarList.add(fileList.get(i));
                this.jarAddressList.add(allAddressList.get(i));
            }

        }



    }
}