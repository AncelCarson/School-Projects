/* Program Written for CSII
   I Class Example
   Program edited by Ancel Carson
   16/4/18
   Windows 10
   Atom and Command Line
   Brief Program Description expected input, output, and process
*/

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.stage.FileChooser;
import javax.swing.SwingUtilities;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JavaFXEx extends Application {
   public void start(Stage primaryStage) {
      GridPane pane = new GridPane();
      Button load = new Button("Load");
      Button save = new Button("Save");
      Button greyscale = new Button("Greyscale");
      Button saturation = new Button("Saturation");
      Button lighting = new Button("Lighting");
      Button pixilate = new Button("Pixilate");
      Image image;
      pane.setAlignment(Pos.CENTER);
      pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
      pane.setHgap(5.5);
      pane.setVgap(5.5);
      pane.add(load, 0, 0);
      pane.add(save, 0, 1);
      pane.add(greyscale, 0, 5);
      pane.add(saturation, 0, 6);
      pane.add(lighting, 0, 7);
      pane.add(pixilate, 0, 8);

      load.setOnAction(e -> {
         FileChooser fileChooser = new FileChooser();
         fileChooser.setInitialDirectory(
            new File (System.getProperty("user.home") +
            System.getProperty("file.separator") + "Pictures"));
         fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"));
         fileChooser.setTitle("Open Picture");
         fileChooser.showOpenDialog(primaryStage);
         File pic = fileChooser.showOpenDialog(primaryStage);
         Image image1 = new Image("file:" + pic.getAbsolutePath());
      });

      // save.setOnAction(e -> {
      //    FileChooser fileChooser = new FileChooser();
      //    fileChooser.setTitle("Save Image");
      //
      //    File file = fileChooser.showSaveDialog(primaryStage);
      //    if (file != null) {
      //       try {
      //          ImageIO.write(SwingFXUtils.fromFXImage(image,
      //             null), "png", file);
      //       } catch (IOException ex) {
      //          System.out.println(ex.getMessage());
      //       }
      //    }
      // });

      Scene scene = new Scene(pane, 200, 250);
      primaryStage.setTitle("MyJavaFX");        // Set the stage title
      primaryStage.setResizable(false);         // Prevent the user from resizing window
      primaryStage.setScene(scene);             // Place the scene in the stage
      primaryStage.show();                      // Display the stage
   }  // end of start method
   public static void main(String[] args) {
      launch(args);
  }  // end of main method
}  // end of MyJavaFX class