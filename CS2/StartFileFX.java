/* Program Written for CSII
   Assignment 1
   Program written by Ancel Carson
   23/4/18
   Windows 10
   Atom and Command Line
   Brief Program Description expected input, output, and process
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

public class StartFileFX extends Application{
   public void start(Stage primaryStage){
      BorderPane pane = new BorderPane();
      Scene scene = new Scene(pane, 200, 50);
      primaryStage.setTitle("Button in a pane"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
   }


   public static void main(String[] args){
      launch(args);
   }
}
