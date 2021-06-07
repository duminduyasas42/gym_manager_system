package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class my_gym_manger implements gym_manager {

    private List<default_member>member_list=new ArrayList<default_member>();




    @Override
    public void addMember(default_member member){


        if (member_list.size()<100){
            member_list.add(member);
        }
        else{
            System.out.println("no free slots available");
        }
        System.out.println("no of occupied slots:"+member_list.size());
        System.out.println("no of free slots:"+(100-member_list.size()));

    }
    @Override
    public boolean deleteMember(String membership_no){

        boolean flag=false;
        for(default_member member :member_list){

            if(member.getMembership_no().equals(membership_no)){
                flag=true;
                member_list.remove(member);
                System.out.println("member with the membership no "+membership_no+"was deleted succesfully");
                System.out.println("no of occupied slots:"+member_list.size());
                System.out.println("no of free slots:"+(100-member_list.size()));
                if(member instanceof student_member){
                    System.out.println("Member type is student member");
                }
                else if(member instanceof over_60_member){
                    System.out.println("member type is members over 60 yers of age");
                }else{
                    System.out.println("membertype is default member");
                }

                break;
            }


        }
        if(flag==false){
            System.out.println("member with membership number "+membership_no+" was not found");
        }
        return flag;

    }
    @Override
    public ObservableList<list>getProduct(){
        ObservableList<list> lists= FXCollections.observableArrayList();

        for (default_member member:member_list){
            String names=null;
            String dates=null;
            String types=null;
            String membership_nos=null;
            String agess=null;
            String schhool=null;
            String relative=null;


            membership_nos=member.getMembership_no();
            if (member instanceof student_member ){
                types=("student member");
                schhool=((student_member) member).getSchool_name();
                relative=((student_member) member).getRelatives_name();

            } else if(member instanceof over_60_member){
                types=("over 60 member");
                agess=((over_60_member) member).getAge();
                relative=((over_60_member) member).getRelative_name();
            }else {
                types=("default member");

            }

            names=(member.getName());
            dates=(member.getDates());

            lists.add(new list(names,types,membership_nos,dates,schhool,agess,relative));



        }


        return lists;

    }

    @Override
    public void sort(){
        Collections.sort(member_list);

    }
    @Override
    public void save(){
        String p="C:\\Users\\dumindu yasa\\Desktop\\submisionq\\coursework2 ettemp 2\\save.txt";
        Path sp= Paths.get(p);
        try{
            Files.delete(sp);
        }catch (Exception e){


        }

        if(member_list.size()!=0){



            File file=new File("save.txt");
            file.delete();
            PrintWriter pw;
            FileWriter fw;
            try {
                fw=new FileWriter(file,true);
                pw=new PrintWriter(fw,true);



                for (default_member member : member_list) {
                    pw.println(member.getMembership_no());
                    if (member instanceof student_member) {
                        pw.println("student member");
                        pw.println( ((student_member) member).getSchool_name());
                        pw.println(((student_member) member).getRelatives_name());

                    } else if (member instanceof over_60_member) {
                        pw.println("over 60 member");
                        pw.println(((over_60_member) member).getAge());
                        pw.println(((over_60_member) member).getRelative_name());
                    } else {
                        pw.println("default member");

                    }
                    pw.println(member.getName());
                    pw.println(member.getDates());
                    pw.println("-------------------");

                }
                pw.flush();
                pw.close();
                System.out.println("save was succesfull");
            }
            catch (IOException e){
                System.out.println("error has occureid");
            }




        }else{
            System.out.println("empty list nothng to save");
        }


    }

    @Override
    public String get_member_by_name(String name) {
        String labtext="not found ";
        String a;
        String b;
        String c;
        String d;
        String e="";
        String f="";
        for (default_member member:member_list){


            if(member.getName().equals(name)) {

                a = ("membership number:" + member.getMembership_no());
                if (member instanceof student_member) {
                    b = ("type:student member");
                    e=("school name:"+((student_member) member).getSchool_name());
                    f=("relative name:"+((student_member) member).getRelatives_name());


                } else if (member instanceof over_60_member) {
                    b = ("type:over 60 member");
                    e=("age:"+((over_60_member) member).getAge());
                    f=("relative name:"+((over_60_member) member).getRelative_name());
                } else {
                    b = ("type:default member");

                }
                c = ("name:" + member.getName() + " ");
                d = ("membership_start_date:" + member.getDates());
                labtext = a + "\n" + b + "\n" + c + "\n" + d+"\n"+e+"\n"+f;
            }


        }
        return labtext;


    }
    @Override
    public int readfile(){
        int i=0;//count

        try{
            FileReader fr=new FileReader("save.txt");
            BufferedReader br= new BufferedReader(fr);


            int r=0;//inputnum
            int x=0;//choice
            String menno=null;
            String type=null;
            String spq1=null;
            int spq1a=0;
            String spq2=null;
            String nam=null;
            String dat=null;
            String names=null;
            String Datex=null;

            String str;
            default_member member = null;
            while ((str=br.readLine())!=null){
                if(str.equals("-------------------")){
                    i=i+1;
                    r=0;
                    if(type.equals("student member")){
                        member=new student_member(menno,nam,dat,spq1,spq2);
                        member_list.add(member);
                    }
                    else if(type.equals("over 60 member")){
                        member=new over_60_member(menno,nam,dat,spq1,spq2);
                        member_list.add(member);
                    }
                    else if(type.equals("default member")){
                        member=new default_member(menno,names,Datex);
                        member_list.add(member);
                    }


                }else {


                    r = r + 1;

                    if (r == 1) {
                        menno = str;

                    }
                    if (r == 2) {
                        type = str;

                    }
                    if (r == 3) {
                        spq1 = str;

                        names = str;

                    }
                    if (r == 4) {
                        spq2 = str;
                        Datex = str;
                    }
                    if (r == 5) {
                        nam = str;
                    }
                    if (r == 6) {
                        dat = str;
                    }
                }










            }
            br.close();

        }catch (IOException e){
            System.out.println("file not found");
        }
        return i;

    }
    @Override
    public void console_list() {
        for (default_member member:member_list){
            System.out.println("membership number: "+ member.getMembership_no()+" ");
            if (member instanceof student_member ){
                System.out.println("member is a student member");

            } else if(member instanceof over_60_member){
                System.out.println("member is over 60 member");
            }else {
                System.out.println("member ship type is default member");

            }
            System.out.println("name is "+member.getName()+" ");
            System.out.println("membership start date equal "+member.getDates());
            System.out.println("-----------------------------");
        }
        if (member_list.size()==0){
            System.out.println("your list is empty");
        }

    }
    public  boolean checkmemno(String num){
        boolean yes=true;
        for (default_member member:member_list){

            if(member.getMembership_no().equals(num)){
                yes=false;
                System.out.println("membership no is not unique");
            }

        }
        return yes;


    }




}
