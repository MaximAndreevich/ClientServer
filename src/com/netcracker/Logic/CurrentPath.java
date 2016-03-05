package com.netcracker.Logic;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import javafx.scene.input.KeyCode;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.DirectoryStream;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import static java.lang.System.out;
import static java.nio.file.Files.newDirectoryStream;
import static java.nio.file.Files.isRegularFile;

/**
 * Created by Admin on 2/26/2016.
 */
public class CurrentPath {
    public Path address;


    public void printCurrentPath() {
        address.toAbsolutePath();
        String addressToPrint = address.toAbsolutePath().toString();
        System.out.println(addressToPrint);
    }

    public void getCustomPath() {
        InputStream is = System.in;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try {
            String path = null;
            while ((path = br.readLine()) != null) {
                if (path.equalsIgnoreCase("quite")) {
                    break;//how to avoid it????
                }
                this.address = Paths.get(path);
            }
        } catch (IOException ioe) {
            System.out.println("  ");
        }
    }

    public void SpecialPath1(){
        this.address=Paths.get("E:\\Windows\\Documents\\NEC\\ClientServer\\ClientServer\\testJars");
    }
    public Path getPathToWork() {
        address = Paths.get("");
        address.toAbsolutePath();
        address = address.toAbsolutePath();
        return address;
    }
    public Path getUpperPathToWork(){
        address = Paths.get("");
        address=address.toAbsolutePath().getParent();
        address.toAbsolutePath();
        address = address.toAbsolutePath();
        return address;

    }

    public void printCurrentFolder(){

        String a=address.getFileName().toString();
        System.out.println(a);

    }
}

  /* public void getFilesList(Path workDir) {

        try (DirectoryStream<java.nio.file.Path> dirStream = newDirectoryStream(workDir))

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
        */




