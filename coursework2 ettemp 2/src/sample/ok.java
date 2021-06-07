package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Scanner;

public class ok  {
    private static Scanner x;
    public static void main(String[] args){
        String filepath="tutorial.txt";
        String removeTerm="4444";
        record(filepath,removeTerm);
    }
    public static void  record(String filepath,String removeTerm){
        String tempfile="tempt.txt";
        File oldFile=new File(filepath);
        File newfile=new File(tempfile);
        String id="";String name="";String age="";
        try {
            {
                FileWriter fw=new FileWriter(tempfile,true);
                BufferedWriter bw=new BufferedWriter(fw);
                PrintWriter pw=new PrintWriter(bw);
                x=new Scanner(new File(filepath));
                x.useDelimiter("[,\n]");
                while (x.hasNext()){
                    id=x.next();
                    name=x.next();
                    age=x.next();
                    if(!id.equals(removeTerm)){
                        pw.println(id+","+name+","+age);

                    }

                }
                x.close();
                pw.flush();
                pw.close();
                oldFile.delete();
                File dump=new File(filepath);
                newfile.renameTo(dump);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"error");
        }
    }

}
