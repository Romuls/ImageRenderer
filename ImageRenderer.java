// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP112 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP112 - 2018T1, Assignment 5
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** Renders plain ppm images onto the graphics panel
 *  ppm images are the simplest possible colour image format.
 */

public class ImageRenderer{
    public static final int TOP = 20;   // top edge of the image
    public static final int LEFT = 20;  // left edge of the image
    public static final int PIXEL_SIZE = 2;  

    /** Core:
     * Renders a ppm image file.
     * Asks for the name of the file, then calls renderImageHelper.
     */
    public void renderP3Image(){
        int pixelX = LEFT;
        int pixelY = TOP;
        int pixelCountX = 0;
        int pixelCountY = 0;

        try {
            File imageFile = new File(UIFileChooser.open());
            Scanner imageScan = new Scanner(imageFile);
            String first = imageScan.next();


            if(first.equals("P3")) {
                imageScan.nextLine();
                int imageX = imageScan.nextInt();
                int imageY = imageScan.nextInt();

                imageScan.nextLine();

                int colourVal = imageScan.nextInt();

              while(imageScan.hasNextLine()) {
                 String line = imageScan.nextLine();
                 Scanner lineScan = new Scanner(line);

                    //UI.println(line);
                 while (lineScan.hasNext()) {


                     int r = lineScan.nextInt();
                     int g = lineScan.nextInt();
                     int b = lineScan.nextInt();
                     //UI.println(r+" "+g+" "+b);


                    Color pixelColor = new Color(r,g,b);
                    UI.setColor(pixelColor);

                    if(pixelCountX != (imageX-1)) {
                        UI.fillRect(pixelX,pixelY,PIXEL_SIZE,PIXEL_SIZE);
                        //UI.println("drew pixel of values "+r+" "+g+" "+b+" @ "+pixelX+" "+pixelY);
                       // UI.println(pixelCountX);
                        //UI.println(imageX);

                        pixelCountX++;
                        pixelX = pixelX + PIXEL_SIZE;

                    }else{
                        pixelX = LEFT;
                        pixelCountX = 0;
                        pixelY = pixelY + PIXEL_SIZE;

                    }


                 }

             }}else{
                UI.println("Invalid File");





           }



        }catch(IOException e) {UI.printf("File Failure %s \n", e);}

    }

    /** Core:
     * Renders a ppm image file.
     * Renders the image at position (LEFT, TOP).
     * Each pixel of the image  is rendered by a square of size PIXEL_SIZE
     * Assumes that
     * - the colour depth is 255,
     * - there is just one image in the file (not "animated"), and
     * - there are no comments in the file.
     * The first four tokens are "P3", number of columns, number of rows, 255
     * The remaining tokens are the pixel values (red, green, blue for each pixel)
     */
    public void renderImageHelper(Scanner sc){
        /*# YOUR CODE HERE */

    }

    /** Core
     * Renders a ppm image file which may be animated (multiple images in the file)
     * Asks for the name of the file, then renders the image at position (LEFT, TOP).
     * Each pixel of the image  is rendered by a square of size PIXEL_SIZE
     * Renders each image in the file in turn with 200 mSec delay.
     * Repeats the sequence 3 times.
     */
    public void renderAnimatedImage(){
        /*# YOUR CODE HERE */

    }

    /** Completion
     * Renders a ppm image file which may be animated (multiple images in the file)
     * Asks for the name of the file, then renders the image at position (LEFT, TOP).
     * Each pixel of the image  is rendered by a square of size PIXEL_SIZE
     * Renders each image in the file in turn with 200 mSec delay.
     * Repeats the sequence 3 times.
     * Ignores comments (starting with # and occuring after the 1st, 2nd, or 3rd token) 
     * The colour depth (max colour value) may be different from 255 (scales the
     * colour values appropriately)
     */
    public void renderComplexAnimatedImage(){
        /*# YOUR CODE HERE */

    }

    public void renderComplexImageHelper(Scanner input){
        /*# YOUR CODE HERE */

    }

}
