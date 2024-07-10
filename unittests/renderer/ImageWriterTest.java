package renderer;

import org.junit.jupiter.api.Test;
import primitives.Color;

import static java.awt.Color.*;

class ImageWriterTest {

    @Test
    void testWriteToImage() {
        ImageWriter imageWriter = new ImageWriter("yellow", 800, 500);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();
        for (int i = 0; i < nX; i++) {
            for (int j = 0; j < nY; j++) {
                imageWriter.writePixel(i, j, new Color(YELLOW));
            }
        }
        // Loop through the image and draw the grid lines
        int interval = 50;
        for (int i = 0; i < nX; i += interval) {
            for (int j = 0; j < nY; j++) {
                imageWriter.writePixel(i, j, new Color(RED)); // Set the color of the grid line
            }
        }
        for (int j = 0; j < nY; j += interval) {
            for (int i = 0; i < nX; i++) {
                imageWriter.writePixel(i, j, new Color(RED)); // Set the color of the grid line
            }

        }
        imageWriter.writeToImage();
    }
}