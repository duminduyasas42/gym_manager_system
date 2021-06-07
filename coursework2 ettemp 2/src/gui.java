import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class gui extends Application {
    Stage window ;

    Scene scene1;
    Pane a=new Pane();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;






        scene1= new Scene(a,450,250);



        window.setScene(scene1);
        window.setTitle("financial calculator");


    }
}
