/* Program Written for CSII
   Assignment 11
   Program edited by Ancel Carson
   29/4/18
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.stage.FileChooser;
import javax.swing.SwingUtilities;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;
import javafx.scene.Group;

public class Photoshop extends Application {
   Image image, imageSave, imageSat, imageLight;
   ImageView imageView;
   WritableImage wImage;
   PixelReader pixelReader;
   PixelWriter writer;
   int width, height;
   int r1 = 0, g1 = 0, b1 = 0, li = 0, satRun =0, lightRun = 0;
   boolean satBool, lightBool;
   File pic;
   public void start(Stage primaryStage) {
      GridPane buttonPane = new GridPane();
      BorderPane pane = new BorderPane();
      StackPane picPane = new StackPane();
      Button load = new Button("Load");
      Button save = new Button("Save");
      Button greyscale = new Button("Greyscale");
      Button saturation = new Button("Saturation");
      Button stippling = new Button("Stippling");
      Button lighting = new Button("Lighting");
      Button pixilate = new Button("Pixilate");
      Button reset = new Button("Reset");

      imageView = new ImageView();

      FileChooser fileChooser = new FileChooser();
         fileChooser.setInitialDirectory(
            new File (System.getProperty("user.home") +
            System.getProperty("file.separator") + "Pictures"));
         fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("JPG", "*.jpg"),
            new FileChooser.ExtensionFilter("PNG", "*.png"),
            new FileChooser.ExtensionFilter("JPEG", "*.jpeg"));

      buttonPane.setAlignment(Pos.CENTER);
      buttonPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
      buttonPane.setHgap(5.5);
      buttonPane.setVgap(5.5);
      buttonPane.add(load, 0, 0);
      buttonPane.add(save, 0, 1);
      buttonPane.add(greyscale, 0, 5);
      buttonPane.add(saturation, 0, 6);
      buttonPane.add(lighting, 0, 7);
      buttonPane.add(stippling, 0, 8);
      buttonPane.add(pixilate, 0, 9);
      buttonPane.add(reset, 0, 10);

      load.setOnAction(e -> {
         fileChooser.setTitle("Open Picture");
         pic = fileChooser.showOpenDialog(primaryStage);
         image = new Image(pic.toURI().toString());
         imageSave = image;
         imageView.setImage(image);
         picPane.getChildren().add(imageView);
         width = (int)image.getWidth();
         height = (int)image.getHeight();
      });

      save.setOnAction(e -> {
         fileChooser.setTitle("Save Image");

         File file = fileChooser.showSaveDialog(primaryStage);
         if (file != null) {
            try {
               ImageIO.write(SwingFXUtils.fromFXImage(imageSave,
                  null), "png", file);
            } catch (IOException ex) {
               System.out.println(ex.getMessage());
            }
         }
      });

      greyscale.setOnAction(e -> {
         //Creating a writable image
         wImage = new WritableImage(width, height);
         pixelReader = image.getPixelReader();
         writer = wImage.getPixelWriter();
         //Reading the color of the image
         for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
               //Retrieving the color of the pixel of the loaded image
               Color color = pixelReader.getColor(x, y);

               //Setting the color to the writable image
               writer.setColor(x, y, color.grayscale());

               //Setting the view for the writable image
               imageView.setImage(wImage);
            }
         }
         imageSave = wImage;
      });

      saturation.setOnAction(e -> {

         // Checking if button has been pressed before
         if(satRun == 0){
            imageSat = image;
            satRun = 1;
         }
         satBool = true;
         lightBool = false;
         imageView.setImage(imageSat);
         imageSave = imageSat;
      });

      lighting.setOnAction(e -> {

         // Checking if button has been pressed before
         if(lightRun == 0){
            imageLight = image;
            lightRun = 1;
         }
         lightBool = true;
         satBool = false;
         imageView.setImage(imageLight);
         imageSave = imageLight;
      });

      stippling.setOnAction(e -> {
         int a, r, g, b, p, r1, g1, b1;
         r1 = (int)(Math.random() * 100);
         g1 = (int)(Math.random() * 100);
         b1 = (int)(Math.random() * 100);

         Group keyboard = new Group();

         wImage = new WritableImage(width, height);
         pixelReader = image.getPixelReader();
         writer = wImage.getPixelWriter();
         for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {

               //Retrieving the color of the pixel of the loaded image
               int pI = pixelReader.getArgb(x, y);
               int aI = (pI>>24) & 0xff;
               int rI = (pI>>16) & 0xff;
               int gI = (pI>>8) & 0xff;
               int bI = pI & 0xff;

               a = aI;
               r = rI + (int)(Math.random() * 100);
               g = gI + (int)(Math.random() * 100);
               b = bI + (int)(Math.random() * 100);

               p = (a<<24) | (r<<16) | (g<<8) | b;

               //Setting the color to the writable image
               writer.setArgb(x, y, p);

               //Setting the view for the writable image
               imageView.setImage(wImage);
            }
         }
         imageSave = wImage;
      });

      pixilate.setOnAction(e -> {
         int a, r, g, b, p, count = 0;
         int pI = 0, aI = 0, rI = 0, gI = 0, bI = 0;

         WritableImage tempWImage = new WritableImage(width, height);
         PixelReader tempReader = tempWImage.getPixelReader();
         PixelWriter tempWriter = tempWImage.getPixelWriter();
         wImage = new WritableImage(width, height);
         pixelReader = image.getPixelReader();
         writer = wImage.getPixelWriter();

         // Copies pixel value down column
         for(int y = 0; y < height; y++) {
            count = 0;
            for(int x = 0; x < width; x++) {
               if(count == 5){
                  count = 0;
               }
               if(count == 0){

                  //Retrieving the color of the pixel of the loaded image
                  pI = pixelReader.getArgb(x, y);
                  aI = (pI>>24) & 0xff;
                  rI = (pI>>16) & 0xff;
                  gI = (pI>>8) & 0xff;
                  bI = pI & 0xff;
               }
               a = aI;
               r = rI;
               g = gI;
               b = bI;

               p = (a<<24) | (r<<16) | (g<<8) | b;

               //Setting the color to the writable image
               tempWriter.setArgb(x, y, p);

               //Setting the view for the writable image
               imageView.setImage(tempWImage);
               count++;
            }
         }

         // Copies pixel value across row
         for(int x = 0; x < width; x++) {
            count = 0;
            for(int y = 0; y < height; y++) {

               if(count == 5){
                  count = 0;
               }
               if(count == 0){
                  //Retrieving the color of the pixel of the loaded image
                  pI = tempReader.getArgb(x, y);
                  aI = (pI>>24) & 0xff;
                  rI = (pI>>16) & 0xff;
                  gI = (pI>>8) & 0xff;
                  bI = pI & 0xff;
               }
               a = aI;
               r = rI;
               g = gI;
               b = bI;

               p = (a<<24) | (r<<16) | (g<<8) | b;

               //Setting the color to the writable image
               writer.setArgb(x, y, p);

               //Setting the view for the writable image
               imageView.setImage(wImage);
               count++;
            }
         }
         imageSave = wImage;
      });

      reset.setOnAction(e -> {

         // Resets all values related to adjustments
         imageView.setImage(image);
         imageSave = image;
         imageSat = image;
         imageLight = image;
         r1 = 0;
         g1 = 0;
         b1 = 0;
         li = 0;
         satRun =0;
         lightRun = 0;
      });

      pane.setLeft(buttonPane);
      pane.setRight(picPane);

      Scene scene = new Scene(pane, 500, 600);

      scene.setOnKeyPressed(k -> {
         if(satBool){
            int a, r, g, b, p;

            wImage = new WritableImage(width, height);
            pixelReader = image.getPixelReader();
            writer = wImage.getPixelWriter();
            for(int y = 0; y < height; y++) {
               for(int x = 0; x < width; x++) {

                  //Retrieving the color of the pixel of the loaded image
                  int pI = pixelReader.getArgb(x, y);
                  int aI = (pI>>24) & 0xff;
                  int rI = (pI>>16) & 0xff;
                  int gI = (pI>>8) & 0xff;
                  int bI = pI & 0xff;

                  a = aI;
                  r = rI + r1;
                  g = gI + g1;
                  b = bI + b1;

                  p = (a<<24) | (r<<16) | (g<<8) | b;

                  //Setting the color to the writable image
                  writer.setArgb(x, y, p);

                  //Setting the view for the writable image
                  imageView.setImage(wImage);
               }
            }
            imageSave = wImage;
            imageSat = wImage;
            if (k.getCode() == KeyCode.R) {
               r1++;
            }
            if (k.getCode() == KeyCode.G) {
               g1++;
            }
            if (k.getCode() == KeyCode.B) {
               b1++;
            }
         }
         if(lightBool){
            int a, r, g, b, p;

            wImage = new WritableImage(width, height);
            pixelReader = image.getPixelReader();
            writer = wImage.getPixelWriter();
            for(int y = 0; y < height; y++) {
               for(int x = 0; x < width; x++) {

                  //Retrieving the color of the pixel of the loaded image
                  int pI = pixelReader.getArgb(x, y);
                  int aI = (pI>>24) & 0xff;
                  int rI = (pI>>16) & 0xff;
                  int gI = (pI>>8) & 0xff;
                  int bI = pI & 0xff;

                  a = aI;
                  r = rI + li;
                  g = gI + li;
                  b = bI + li;

                  p = (a<<24) | (r<<16) | (g<<8) | b;

                  //Setting the color to the writable image
                  writer.setArgb(x, y, p);

                  //Setting the view for the writable image
                  imageView.setImage(wImage);
               }
            }
            imageSave = wImage;
            imageLight = wImage;
            if (k.getCode() == KeyCode.L) {
               li++;
            }
            if (k.getCode() == KeyCode.D) {
               li--;
            }
         }
      });

      primaryStage.setTitle("Photoshop");        // Set the stage title
      primaryStage.setResizable(true);          // Allows the user from resizing window
      primaryStage.setScene(scene);             // Place the scene in the stage
      primaryStage.show();                      // Display the stage
   }  // end of start method
   public static void main(String[] args) {
      launch(args);
  }  // end of main method
}  // end of MyJavaFX class