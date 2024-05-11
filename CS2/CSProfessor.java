/* Program Written for CSII
   Assignment 10
   Program written by Ancel Carson
   21/4/18
   Windows 10
   Atom and Command Line
   This program draws the faces of the three CS Professors at the press of a button
*/

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.text.*;
public class CSProfessor extends Application{
   @Override
   public void start(Stage primaryStage){

      //Buttons in PrimaryStage to select Professors
      Button rouseButton = new Button("Rouse");
      Button baasButton = new Button("Baas");
      Button gowingButton = new Button("Gowing");

      //Creates Rouse Stage
      rouseButton.setOnAction(e -> {
         Stage rouseStage = new Stage();

         //Draws Rouse face
         Ellipse head = new Ellipse(250, 250, 160, 200);
            head.setStroke(Color.BLACK);
            head.setFill(Color.color(1, .76, .66));
         Rectangle crossBar = new Rectangle(210, 190, 70, 20);
            crossBar.setStroke(Color.BLACK);
            crossBar.setFill(Color.BLACK);
         Rectangle frameRight = new Rectangle(263, 159, 99, 79);
            frameRight.setStroke(Color.BLACK);
            frameRight.setFill(Color.BLACK);
         Rectangle frameLeft = new Rectangle(136, 159, 99, 79);
            frameLeft.setStroke(Color.BLACK);
            frameLeft.setFill(Color.BLACK);
         Rectangle lensRight = new Rectangle(269, 165, 87, 67);
            lensRight.setStroke(Color.BLACK);
            lensRight.setFill(Color.color(1, .76, .66));
         Rectangle lensLeft = new Rectangle(142, 165, 87, 67);
            lensLeft.setStroke(Color.BLACK);
            lensLeft.setFill(Color.color(1, .76, .66));
         Ellipse eyeRight = new Ellipse(314, 200, 40, 30);
            eyeRight.setStroke(Color.BLACK);
            eyeRight.setFill(Color.WHITE);
         Ellipse eyeLeft = new Ellipse(186, 200, 40, 30);
            eyeLeft.setStroke(Color.BLACK);
            eyeLeft.setFill(Color.WHITE);
         Circle irisRight = new Circle(314, 200, 30);
            irisRight.setStroke(Color.color(.1, .1, .9));
            irisRight.setFill(Color.color(.1, .1, .9));
         Circle irisLeft = new Circle(186, 200, 30);
            irisLeft.setStroke(Color.color(.1, .1, .9));
            irisLeft.setFill(Color.color(.1, .1, .9));
         Circle pupRight = new Circle(314, 200, 15);
            pupRight.setStroke(Color.BLACK);
            pupRight.setFill(Color.BLACK);
         Circle pupLeft = new Circle(186, 200, 15);
            pupLeft.setStroke(Color.BLACK);
            pupLeft.setFill(Color.BLACK);
         Arc mouth = new Arc(250, 325, 80, 60, 0, -180);
         Line nose1 = new Line(220, 300, 270, 300);
            nose1.setStrokeWidth(5);
         Line nose2 = new Line(220, 300, 270, 260);
            nose2.setStrokeWidth(5);
         Arc hair = new Arc(250, 150, 140, 100, 0, 180);
            hair.setStroke(Color.BLACK);
            hair.setFill(Color.color(.5, .5, .5));

         //Combines objects
         BorderPane pane = new BorderPane();
         pane.getChildren().addAll(new Text(230, 480, "Dr. Rouse"),
            head, nose1, nose2, mouth, hair,
            crossBar, frameRight, frameLeft, lensRight, lensLeft,
            eyeRight,  eyeLeft, irisRight, irisLeft, pupRight, pupLeft);

            //Creates Scene
            Scene rouseScene = new Scene(pane, 500, 500);
            rouseStage.setTitle("Dr. Rouse"); // Set the stage title
            rouseStage.setScene(rouseScene); // Place the scene in the stage
            rouseStage.show();
      });

      //Creates Baas Stage
      baasButton.setOnAction(e -> {
         Stage baasStage = new Stage();

         //Draws Bass face
         Ellipse head = new Ellipse(250, 250, 160, 200);
            head.setStroke(Color.BLACK);
            head.setFill(Color.color(1, .76, .66));
         Rectangle crossBar = new Rectangle(210, 190, 70, 20);
            crossBar.setStroke(Color.BLACK);
            crossBar.setFill(Color.color(.75, .75, .75));
         Rectangle frameRight = new Rectangle(263, 159, 99, 79);
            frameRight.setStroke(Color.BLACK);
            frameRight.setFill(Color.color(.75, .75, .75));
         Rectangle frameLeft = new Rectangle(136, 159, 99, 79);
            frameLeft.setStroke(Color.BLACK);
            frameLeft.setFill(Color.color(.75, .75, .75));
         Rectangle lensRight = new Rectangle(269, 165, 87, 67);
            lensRight.setStroke(Color.BLACK);
            lensRight.setFill(Color.color(1, .76, .66));
         Rectangle lensLeft = new Rectangle(142, 165, 87, 67);
            lensLeft.setStroke(Color.BLACK);
            lensLeft.setFill(Color.color(1, .76, .66));
         Ellipse eyeRight = new Ellipse(314, 200, 40, 30);
            eyeRight.setStroke(Color.BLACK);
            eyeRight.setFill(Color.WHITE);
         Ellipse eyeLeft = new Ellipse(186, 200, 40, 30);
            eyeLeft.setStroke(Color.BLACK);
            eyeLeft.setFill(Color.WHITE);
         Circle irisRight = new Circle(314, 200, 30);
            irisRight.setStroke(Color.color(.1, .1, .9));
            irisRight.setFill(Color.color(.1, .1, .9));
         Circle irisLeft = new Circle(186, 200, 30);
            irisLeft.setStroke(Color.color(.1, .1, .9));
            irisLeft.setFill(Color.color(.1, .1, .9));
         Circle pupRight = new Circle(314, 200, 15);
            pupRight.setStroke(Color.BLACK);
            pupRight.setFill(Color.BLACK);
         Circle pupLeft = new Circle(186, 200, 15);
            pupLeft.setStroke(Color.BLACK);
            pupLeft.setFill(Color.BLACK);
         Arc mouth = new Arc(250, 325, 80, 60, 0, -180);
         Line nose1 = new Line(220, 300, 270, 300);
            nose1.setStrokeWidth(5);
         Line nose2 = new Line(220, 300, 270, 260);
            nose2.setStrokeWidth(5);
         Arc hair = new Arc(250, 150, 140, 100, 0, 180);
            hair.setStroke(Color.BLACK);
            hair.setFill(Color.color(.75, .75, .75));
         Arc beard = new Arc(250, 305, 155, 145, 0, -180);
            beard.setStroke(Color.BLACK);
            beard.setFill(Color.color(.75, .75, .75));

         //Combines objects
         BorderPane pane = new BorderPane();
         pane.getChildren().addAll(new Text(230, 480, "Dr. Baas"),
            head, beard, nose1, nose2, mouth, hair,
            crossBar, frameRight, frameLeft, lensRight, lensLeft,
            eyeRight,  eyeLeft, irisRight, irisLeft, pupRight, pupLeft);

            //Creates Scene
            Scene baasScene = new Scene(pane, 500, 500);
            baasStage.setTitle("Dr. Baas"); // Set the stage title
            baasStage.setScene(baasScene); // Place the scene in the stage
            baasStage.show();
      });

      //Creates Gowing Stage
      gowingButton.setOnAction(e -> {
         Stage gowingStage = new Stage();

         //Draws Gowing face
         Ellipse head = new Ellipse(250, 250, 160, 200);
            head.setStroke(Color.BLACK);
            head.setFill(Color.color(1, .76, .66));
         Rectangle crossBar = new Rectangle(210, 190, 70, 20);
            crossBar.setStroke(Color.BLACK);
            crossBar.setFill(Color.BLACK);
         Rectangle frameRight = new Rectangle(263, 159, 99, 79);
            frameRight.setStroke(Color.BLACK);
            frameRight.setFill(Color.BLACK);
         Rectangle frameLeft = new Rectangle(136, 159, 99, 79);
            frameLeft.setStroke(Color.BLACK);
            frameLeft.setFill(Color.BLACK);
         Rectangle lensRight = new Rectangle(269, 165, 87, 67);
            lensRight.setStroke(Color.BLACK);
            lensRight.setFill(Color.color(1, .76, .66));
         Rectangle lensLeft = new Rectangle(142, 165, 87, 67);
            lensLeft.setStroke(Color.BLACK);
            lensLeft.setFill(Color.color(1, .76, .66));
         Ellipse eyeRight = new Ellipse(314, 200, 40, 30);
            eyeRight.setStroke(Color.BLACK);
            eyeRight.setFill(Color.WHITE);
         Ellipse eyeLeft = new Ellipse(186, 200, 40, 30);
            eyeLeft.setStroke(Color.BLACK);
            eyeLeft.setFill(Color.WHITE);
         Circle irisRight = new Circle(314, 200, 30);
            irisRight.setStroke(Color.color(.35, .15, .16));
            irisRight.setFill(Color.color(.35, .15, .16));
         Circle irisLeft = new Circle(186, 200, 30);
            irisLeft.setStroke(Color.color(.35, .15, .16));
            irisLeft.setFill(Color.color(.35, .15, .16));
         Circle pupRight = new Circle(314, 200, 15);
            pupRight.setStroke(Color.BLACK);
            pupRight.setFill(Color.BLACK);
         Circle pupLeft = new Circle(186, 200, 15);
            pupLeft.setStroke(Color.BLACK);
            pupLeft.setFill(Color.BLACK);
         Arc mouth = new Arc(250, 325, 80, 60, 0, -180);
         Line nose1 = new Line(220, 300, 270, 300);
            nose1.setStrokeWidth(5);
         Line nose2 = new Line(220, 300, 270, 260);
            nose2.setStrokeWidth(5);
         Arc hair = new Arc(250, 150, 140, 100, 0, 180);
            hair.setStroke(Color.BLACK);
            hair.setFill(Color.BLACK);
         Arc beard = new Arc(250, 325, 150, 135, 0, -180);
            beard.setStroke(Color.BLACK);
            beard.setFill(Color.color(.05, .05, .05));
         Arc lips = new Arc(250, 325, 85, 65, 0, -180);
            lips.setStroke(Color.color(1, .76, .66));
            lips.setFill(Color.color(1, .76, .66));

         //Combines objects
         BorderPane pane = new BorderPane();
         pane.getChildren().addAll(new Text(230, 480, "Dr. Gowing"),
            head, beard, lips, nose1, nose2, mouth, hair,
            crossBar, frameRight, frameLeft, lensRight, lensLeft,
            eyeRight,  eyeLeft, irisRight, irisLeft, pupRight, pupLeft);

            //Creates Scene
            Scene gowingScene = new Scene(pane, 500, 500);
            gowingStage.setTitle("Dr. Gowing"); // Set the stage title
            gowingStage.setScene(gowingScene); // Place the scene in the stage
            gowingStage.show();
      });

      // Create a group and add nodes to the group
      HBox hBox = new HBox(15);
      hBox.setPadding(new Insets(15, 15, 15, 15));
      hBox.getChildren().add(rouseButton);
      hBox.getChildren().add(baasButton);
      hBox.getChildren().add(gowingButton);

      // Create Scene and place in Stage
      Scene scene = new Scene(hBox);
      primaryStage.setTitle("CSProfessor"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show();
      primaryStage.setOnCloseRequest(e -> Platform.exit()); //CLosses all windows with primaryStage
   }

   public static void main(String[] args){
      launch(args);
   }
}
