package sample;

import gui.gui;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Collection;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class consoler extends Application {



    private static int count=0;
    private  static Scanner in=new Scanner(System.in);

    static   my_gym_manger manger=new my_gym_manger();

    static date datex=new date();



    @Override
    public  void start(Stage primaryStage) throws Exception {
        int i=0;
        int ok=0;
        count=manger.readfile();

        while (ok==0){
            if(i!=-1) {
                System.out.println("enter 1 to enter new member");
                System.out.println("enter 2 to delete member");
                System.out.println("enter 3 to go to Table");
                System.out.println("enter 4 to save ");
                System.out.println("enter 5 to printlist ");
                System.out.println("enter 6 to sort list");
                System.out.println("enter -1 to quite");
                System.out.print("what do you want to do?");

                String l= in.nextLine();
                boolean y=isnum(l);
                if(y==false){continue;}
                i=Integer.parseInt(l);

                if(i==1){
                    insert_member();



                }
                else if (i==2){
                    delete_member();

                }
                else if (i==3){
                    printlist_gui();












                }
                else if (i==4){
                    manger.save();

                }

                else if (i==5){
                    manger.console_list();

                }
                else if (i==6){
                    manger.sort();
                    System.out.println("system is sorted");


                }
                else if(i==-1){
                    System.out.println("thank you");
                    ok=1;
                    break;


                }
                else {

                    System.out.println("not valid input");
                }




            }





        }
        System.exit(0);




    }
    public static void main(String[] args)throws IOException{
        launch();
    }
    private static void insert_member(){
        if(count<100){
            int ds=0;
            boolean datef=false;
            String date=null;
            while(ds==0) {

                System.out.print("enter membership number:");
                String membership_no = in.nextLine();
                boolean unum=manger.checkmemno(membership_no);
                if(unum==false){continue;}
                System.out.print("enter name:");
                String name = in.nextLine();

                while (datef==false) {
                    System.out.print("enter membership date in formate 00|00|0000 :");
                    date = in.nextLine();
                    datef = sample.date.vale_date(date);

                }


                default_member member = null;
                int i = 0;
                while (i == 0) {

                    System.out.println("what type of member are you?");
                    System.out.println("1=student member   2=elder member  3=default member");
                    System.out.print("enter yuor choice:");
                    String choices = in.nextLine();
                    boolean r = isnum(choices);
                    if (r == false) {
                        continue;
                    }
                    int choice = Integer.parseInt(choices);


                    if (choice == 1) {
                        i = 1;
                        System.out.print("enter school:");
                        String school = in.nextLine();
                        System.out.print("enter relative name:");
                        String relative_name = in.nextLine();
                        member = new student_member(membership_no, name, date, school, relative_name);
                        manger.addMember(member);

                        count = count + 1;
                        ds=1;

                    } else if (choice == 2) {
                        i = 1;
                        int age;
                        int q = 0;
                        String ages = null;
                        while (q != 1) {
                            System.out.print("enter age:");
                            ages = in.nextLine();
                            boolean kr = isnum(ages);
                            if (kr == false) {
                                continue;
                            } else {

                                age = Integer.parseInt(ages);
                                if (age >= 60) {
                                    q = 1;
                                    System.out.print("enter relative name:");
                                    String relative_name = in.nextLine();
                                    member = new over_60_member(membership_no, name, date, ages, relative_name);
                                    manger.addMember(member);
                                    count = count + 1;
                                } else {
                                    System.out.println("not abouve 60");
                                }
                            }
                            ds=1;
                        }


                    } else if (choice == 3) {
                        i = 1;
                        member = new default_member(membership_no, name, date);
                        manger.addMember(member);
                        count = count + 1;
                        ds=1;
                    } else {
                        System.out.println("not a valid choice");
                    }
                }

            }

        }else {
            System.out.println("systeam is full can not add member");
        }

    }
    private static void delete_member(){
        System.out.print("enter number of member you want to delete:");
        String membership_number=in.next();
        boolean result=manger.deleteMember(membership_number);


        if (result){
            count=count-1;
        }
    }
    public static  boolean isnum(String in){
        try{
            int x=Integer.parseInt(in);
            if(x>0 || x==-1) {
                return true;
            }else {
                System.out.println("negative number");
                return false;
            }

        }catch (Exception e){
            System.out.println("not a integure");
            return false;
        }
    }
    private static void  printlist_gui(){
        Stage stage=new Stage();
        BorderPane bod=new BorderPane();

        javafx.scene.control.Label searchlab=new Label();



        TextField search_txt=new TextField();
        search_txt.setLayoutX(200);



        TableView<list> table;
        //type column
        TableColumn<list,String> typecolumn=new TableColumn<>("Type");
        typecolumn.setPrefWidth(100);
        typecolumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //name column
        TableColumn<list,String> namecolumn=new TableColumn<>("Name");
        namecolumn.setPrefWidth(100);
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));



        //membership no column
        TableColumn<list,String> membership_nocolumn=new TableColumn<>("membership_no");
        membership_nocolumn.setPrefWidth(100);
        membership_nocolumn.setCellValueFactory(new PropertyValueFactory<>("membership_no"));

        //date column
        TableColumn<list,String> datecolumn=new TableColumn<>("Date");
        datecolumn.setPrefWidth(100);
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        //age column
        TableColumn<list,String> agecolumn=new TableColumn<>("Age");
        agecolumn.setPrefWidth(100);
        agecolumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        //date column
        TableColumn<list,String> schoolcolumn=new TableColumn<>("School");
        schoolcolumn.setPrefWidth(100);
        schoolcolumn.setCellValueFactory(new PropertyValueFactory<>("school"));
        //date column
        TableColumn<list,String> relativecolumn=new TableColumn<>("Relative");
        relativecolumn.setPrefWidth(100);
        relativecolumn.setCellValueFactory(new PropertyValueFactory<>("relative"));



        table= new TableView<>();
        table.setItems(manger.getProduct());
        table.getColumns().addAll(namecolumn,typecolumn,membership_nocolumn,datecolumn,agecolumn,schoolcolumn,relativecolumn);

        Pane tab=new Pane();
        tab.getChildren().addAll(table);

        Pane empty=new Pane();




        Pane search=new Pane();
        search.getChildren().addAll(searchlab);

        Pane back=new Pane();

        Button backs=new Button("back");
        backs.setOnAction(event -> {
            bod.setCenter(tab);
            bod.setBottom(empty);
        });
        back.getChildren().addAll(backs);










        Button search_btn=new Button("search name");
        search_btn.setOnAction(event -> {
            String d=manger.get_member_by_name(search_txt.getText());

            bod.setCenter(search);
            bod.setBottom(back);



            searchlab.setText(d);
        });
        Pane mp=new Pane();
        mp.getChildren().addAll(search_txt,search_btn);
        stage.setTitle("lists of members");
        search_btn.setLayoutX(350);

        bod.setTop(mp);
        bod.setCenter(tab);



        stage.setScene(new Scene(bod,800,500));
        stage.showAndWait();
    }








}

