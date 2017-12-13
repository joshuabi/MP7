import java.util.Arrays;
/**

* A class that runs implements several simple transformations on 2D image arrays.

* <p>

* This file contains stub code for your image transformation methods that are called by the main

* class. You will do your work for this MP in this file.

* <p>

* Note that you can make several assumptions about the images passed to your functions, both by the

* web front end and by our testing harness:

* <ul>

* <li>You will not be passed empty images.</li>

* <li>All images will have even width and height.</li>

* </ul>

*

* @see <a href="https://cs125.cs.illinois.edu/MP/4/">MP4 Documentation</a>

*/

public class Transform {



    /**

     * Default amount to shift an image's position. Not used by the testing suite, so feel free to

     * change this value.

     */

    public static final int DEFAULT_POSITION_SHIFT = 16;

    /**

     * Pixel value to use as filler when you don't have any valid data. All white with complete

     * transparency. DO NOT CHANGE THIS VALUE: the testing suite relies on it.

     */

    public static final int FILL_VALUE = 0x00FFFFFF;

    /**

     * COLOR VALUE HOLDER.

     */

    public static final int C1_VALUE = 0x000000FF;

    /**

     * COLOR VALUE HOLDER.

     */

    public static final int C2_VALUE = 0xFFFFFF00;

    /**

     * COLOR VALUE HOLDER.

     */

    public static final int C3_VALUE = 0x0000FF00;

    /**

     * COLOR VALUE HOLDER.

     */

    public static final int C4_VALUE = 0xFFFF00FF;

    /**

     * COLOR VALUE HOLDER.

     */

    public static final int C5_VALUE = 0x00FF0000;

    /**

     * COLOR VALUE HOLDER.

     */

    public static final int C6_VALUE = 0xFF00FFFF;

    /**

     * alpha value holder.

     */

    public static final int ALPHA_SHIFT = 0xFF000000;

    /**

     * all possible.

     */

    public static final int ALL_POSSIBLE = 255;

    /**

     * shift holder for alpha changes.

     */

    public static final int TO_AND_BY = 0XFF;

    /**

     * THE INTEGER 8.

     */

    public static final int EIGHT = 8;

    /**

     * THE INTEGER 16.

     */

    public static final int SIXTEEN = 16;

    /**

     * THE INTEGER 24.

     */

    public static final int TFOUR = 24;



    /**

     * Shift the image up by the specified amount.



     * @param originalImage the image to shift up

     * @param amount the amount to shift the image up

     * @return the shifted image

     */

    public static int[][] shiftUp(final int[][] originalImage, final int amount) {

         int[][] shiftedImage = new int[originalImage.length][originalImage[0].length];

         for (int row = 0; row < originalImage.length; row++) {

             for (int col = 0; col < originalImage[0].length; col++) {

                 if (col >= originalImage[0].length - amount) {

                     shiftedImage[row][col] = FILL_VALUE;

                 } else {

                     shiftedImage[row][col] = originalImage[row][col + amount];

                 }

             }

         }

         return shiftedImage;

     }





    /**

     * Shift down like above.

     *

     * @param originalImage the image to shift to the down

     * @param amount the amount to shift the image down

     * @return the shifted image

     */

    public static int[][] shiftDown(final int[][] originalImage, final int amount) {

        int[][] shiftedImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                if (col < amount) {

                    shiftedImage[row][col] = FILL_VALUE;

                } else {

                    shiftedImage[row][col] = originalImage[row][col - amount];

                }

            }

        }

        return shiftedImage;

    }



    /**

     * Shift left above.

     *

     * @param originalImage the image to shift to the left

     * @param amount the amount to shift the image to the left

     * @return the shifted image

     */

    public static int[][] shiftLeft(final int[][] originalImage, final int amount) {

        int[][] shiftedImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                if (row >= originalImage.length - amount) {

                    shiftedImage[row][col] = FILL_VALUE;

                } else {

                    shiftedImage[row][col] = originalImage[row + amount][col];

                }

            }

        }

        return shiftedImage;

    }



    /**

     * Shift Right like above.

     *

     * @param originalImage the image to shift to the Right

     * @param amount the amount to shift the image to the Right

     * @return the shifted image

     */

    public static int[][] shiftRight(final int[][] originalImage, final int amount) {

         int[][] shiftedImage = new int[originalImage.length][originalImage[0].length];

         for (int row = 0; row < originalImage.length; row++) {

             for (int col = 0; col < originalImage[0].length; col++) {

                 if (row < amount) {

                     shiftedImage[row][col] = FILL_VALUE;

                 } else {

                     shiftedImage[row][col] = originalImage[row - amount][col];

                 }

             }

         }

         return shiftedImage;

     }



    /**

     * Rotate the image right by 90 degrees around its center.

     * <p>

     * Any pixels rotated in from off screen should be filled with FILL_VALUE. This function <i>does

     * not modify the original image</i>.

     *

     * @param originalImage the image to rotate right 90 degrees

     * @return the rotated image

     */

    public static int[][] rotateRight(final int[][] originalImage) {

        int[][] rotatedImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                rotatedImage[row][col] = FILL_VALUE;

            }

        }

        float rowHalf = (float) originalImage.length / 2;

        float colHalf = (float) originalImage[0].length / 2;

        if (rowHalf < colHalf) {

            for (int row = 0; row < originalImage.length; row++) {

                for (int col = Math.round(colHalf - rowHalf);

                        col < Math.round(colHalf + rowHalf); col++) {

                    rotatedImage[row][col] =

                            originalImage[col - Math.round(colHalf - rowHalf)]

                                    [Math.round(colHalf + rowHalf) - 1 - row];

                }

            }

        } else {

            for (int row = Math.round(rowHalf - colHalf);

                    row < Math.round(rowHalf + colHalf); row++) {

                for (int col = 0; col < originalImage[0].length; col++) {

                    rotatedImage[row][col] =

                            originalImage[col + Math.round(rowHalf - colHalf)]

                                    [Math.round(rowHalf + colHalf) - 1 - row];

                }

            }

        }

        return rotatedImage;

    }



    /**

     * Rotate the image left like above.

     *

     * @param originalImage the image to rotate

     * @return rotateRight image rotated to left

     */

    public static int[][] rotateLeft(final int[][] originalImage) {

        int[][] rotatedImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                rotatedImage[row][col] = FILL_VALUE;

            }

        }

        float rowHalf = (float) originalImage.length / 2;

        float colHalf = (float) originalImage[0].length / 2;

        if (rowHalf < colHalf) {

            for (int row = 0; row < originalImage.length; row++) {

                for (int col = Math.round(colHalf - rowHalf);

                        col < Math.round(colHalf + rowHalf); col++) {

                    rotatedImage[row][col] =

                            originalImage[Math.round(colHalf + rowHalf) - col - 1]

                                    [row + Math.round(colHalf - rowHalf)];

                }

            }

        } else {

            for (int row = Math.round(rowHalf - colHalf);

                    row < Math.round(rowHalf + colHalf); row++) {

                for (int col = 0; col < originalImage[0].length; col++) {

                    rotatedImage[row][col] =

                            originalImage[Math.round(rowHalf + colHalf) - col - 1]

                                    [row - Math.round(rowHalf - colHalf)];

                }

            }

        }

        return rotatedImage;

    }



    /**

     * Flip horizontally.

     *

     * @param originalImage the image to rotate

     * @return flipHorizontal flip image

     */

    public static int[][] flipHorizontal(final int[][] originalImage) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                outputImage[originalImage.length - 1 - row][col] = originalImage[row][col];

            }

        }

        return outputImage;

    }



    /**

     * Flip vertically.

     * note to self remember to fix param tags later !!! DON't FORGET !!

     * @param originalImage the image to flip

     * @return flipHorizantal flip image

     */

    public static int[][] flipVertical(final int[][] originalImage) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                outputImage[row][originalImage[0].length - 1 - col] = originalImage[row][col];

            }

        }

        return outputImage;

    }



    /**

     * Default amount to shift colors by. Not used by the testing suite, so feel free to change this

     * value.

     */

    public static final int DEFAULT_COLOR_SHIFT = 32;



    /**

     * Add red to the image.

     * RGBA hex value stores the values as 0xAABBGGRR.

     * <p>

     * This function <i>does not modify the original image</i>. It should also not generate any new

     * filled pixels.

     *

     * @param originalImage the image to add red to

     * @param amount the amount of red to add

     * @return the recolored image

     */

    public static int[][] moreRed(final int[][] originalImage, final int amount) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                int finalPixel = originalImage[row][col];

                int pixel = finalPixel & C1_VALUE;

                if ((pixel + amount) > ALL_POSSIBLE) {

                    pixel = ALL_POSSIBLE;

                } else {

                    pixel += amount;

                }

                outputImage[row][col] = (finalPixel & C2_VALUE) | (pixel & C1_VALUE);

            }

        }

        return outputImage;

    }

    /**

     * Subtract red from the image.

     *

     * @param originalImage the image to decrease red to

     * @param amount the amount of red to decrease

     * @return the recolored image

     */

    public static int[][] lessRed(final int[][] originalImage, final int amount) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                int finalPixel = originalImage[row][col];

                int pixel = finalPixel & C1_VALUE;

                if (pixel < amount) {

                    pixel = 0;

                } else {

                    pixel -= amount;

                }

                outputImage[row][col] = (finalPixel & C2_VALUE) | (pixel & C1_VALUE);

            }

        }

        return outputImage;

    }



    /**

     * Add green to the image.

     *

     * @param originalImage the image to add green

     * @param amount amount to decrease green by

     * @return the recolored image

     */

    public static int[][] moreGreen(final int[][] originalImage, final int amount) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                int finalPixel = originalImage[row][col];

                int pixel = (finalPixel & C3_VALUE) >> EIGHT;

                if ((pixel + amount) > ALL_POSSIBLE) {

                    pixel = ALL_POSSIBLE;

                } else {

                    pixel += amount;

                }

                outputImage[row][col]  = (finalPixel & C4_VALUE) | ((pixel & C1_VALUE) << EIGHT);

            }

        }

        return outputImage;

    }



    /**

     * Subtract green from the image.

     *

     * @param originalImage the image to decrease green

     * @param amount to decrease green by

     * @return the recolored image

     */

    public static int[][] lessGreen(final int[][] originalImage, final int amount) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                int finalPixel = originalImage[row][col];

                int pixel = (finalPixel & C3_VALUE) >> EIGHT;

                if (pixel < amount) {

                    pixel = 0;

                } else {

                    pixel -= amount;

                }

                outputImage[row][col] = (finalPixel & C4_VALUE) | ((pixel & C1_VALUE) << EIGHT);

            }

        }

        return outputImage;

    }



    /**

     * Add blue to the image.

     *

     * @param originalImage the image to add blue

     * @param amount to add blue by

     * @return the recolored image

     */

    public static int[][] moreBlue(final int[][] originalImage, final int amount) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                int finalPixel = originalImage[row][col];

                int pixel = (finalPixel & C5_VALUE) >> SIXTEEN;

                if ((pixel + amount) > ALL_POSSIBLE) {

                    pixel = ALL_POSSIBLE;

                } else {

                    pixel += amount;

                }

                outputImage[row][col] = (finalPixel & C6_VALUE) | ((pixel & C1_VALUE) << SIXTEEN);

            }

        }

        return outputImage;

    }



    /**

     * Decrease blue from the image.

     *

     * @param originalImage the image to decrease blue

     * @param amount to decrease blue by

     * @return the recolored image

     */

    public static int[][] lessBlue(final int[][] originalImage, final int amount) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                int finalPixel = originalImage[row][col];

                int pixel = (finalPixel & C5_VALUE) >> SIXTEEN;

                if (pixel < amount) {

                    pixel = 0;

                } else {

                    pixel -= amount;

                }

                outputImage[row][col] = (finalPixel & C6_VALUE) | ((pixel & C1_VALUE) << SIXTEEN);

            }

        }

        return outputImage;

    }





    /**

     * Add alpha to the image.

     *

     * @param originalImage the image to increase alpha on

     * @param amount to increase alpha by

     * @return moreAlpha increased alpha image

     */

    public static int[][] moreAlpha(final int[][] originalImage, final int amount) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                int finalPixel = originalImage[row][col];

                int pixel = (finalPixel >> TFOUR) & TO_AND_BY;

                if ((pixel + amount) > ALL_POSSIBLE) {

                    pixel = ALL_POSSIBLE;

                } else {

                    pixel += amount;

                }

                outputImage[row][col] = (finalPixel & FILL_VALUE) | ((pixel & C1_VALUE) << TFOUR);

            }

        }

        return outputImage;

    }





    /**

     * Add alpha to the image.

     *

     * @param originalImage the image to decrease alpha on

     * @param amount to decrease alpha by

     * @return lessAlpha decreased alpha image

     */

    public static int[][] lessAlpha(final int[][] originalImage, final int amount) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                int finalPixel = originalImage[row][col];

                int pixel = (finalPixel >> TFOUR) & TO_AND_BY;

                if (pixel < amount) {

                    pixel = 0;

                } else {

                    pixel -= amount;

                }

                outputImage[row][col] = (finalPixel & FILL_VALUE) | ((pixel & C1_VALUE) << TFOUR);

            }

        }

        return outputImage;

    }



    /**

     * The default resize factor. Not used by the testing suite, so feel free to change this value.

     */

    public static final int DEFAULT_RESIZE_AMOUNT = 2;



    /**

     * Shrink in the vertical axis around the image center.

     * <p>

     * An amount of 2 will result in an image that is half its original height. An amount of 3 will

     * result in an image that's a third of its original height. Any pixels shrunk in from off

     * screen should be filled with FILL_VALUE. This function <i>does not modify the original

     * image</i>.

     *

     * @param originalImage the image to shrink

     * @param amount the factor to shrink by

     * @return the shrunken image

     */

    public static int[][] shrinkHorizontal(final int[][] originalImage, final int amount) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                outputImage[row][col] = FILL_VALUE;

            }

        }

        int rowHalf = originalImage.length / 2;

        int newRow = 1;

        for (int row = rowHalf - amount; row >= 0; row -= amount) {

            for (int col = 0; col < originalImage[0].length; col++) {

                outputImage[rowHalf - newRow][col] = originalImage[row][col];

            }

            newRow++;

        }

        newRow = 0;

        for (int row = rowHalf; row < originalImage.length; row += amount) {

            for (int col = 0; col < originalImage[0].length; col++) {

                outputImage[rowHalf + newRow][col] = originalImage[row][col];

            }

            newRow++;

        }

        return outputImage;

    }



    /**

     * Expand image.

     *

     * @param originalImage the image to expand

     * @param amount to expand by

     * @return expandHorizontal expanded image

     */

    public static int[][] expandHorizontal(final int[][] originalImage, final int amount) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        int rowHalf = originalImage.length / 2;

        int newRow = 0;

        for (int row = rowHalf - 1; row >= 0; row--) {

            for (int col = 0; col < originalImage[0].length; col++) {

                outputImage[row][col] = originalImage[rowHalf - 1 - newRow / amount][col];

            }

            newRow++;

        }

        newRow = 0;

        for (int row = rowHalf; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                outputImage[row][col] = originalImage[rowHalf + newRow / amount][col];

            }

            newRow++;

        }

        return outputImage;

    }

    /**

     * Shrink image.

     *

     * @param originalImage the image to shrink

     * @param amount to shrink by

     * @return shrinkVertical shrunk image

     */

    public static int[][] shrinkVertical(final int[][] originalImage, final int amount) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                outputImage[row][col] = FILL_VALUE;

            }

        }

        int colHalf = originalImage[0].length / 2;

        for (int row = 0; row < originalImage.length; row++) {

            int newCol = 1;

            for (int col = colHalf - amount; col >= 0; col -= amount) {

                outputImage[row][colHalf - newCol] = originalImage[row][col];

                newCol++;

            }

        }

        for (int row = 0; row < originalImage.length; row++) {

            int newCol = 0;

            for (int col = colHalf; col < originalImage[0].length; col += amount) {

                outputImage[row][colHalf + newCol] = originalImage[row][col];

                newCol++;

            }

        }

        return outputImage;

    }

    /**

     * Expand image.

     *

     * @param originalImage the image to expand

     * @param amount to expand by

     * @return expandVertical expanded image

     */

    public static int[][] expandVertical(final int[][] originalImage, final int amount) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        int colHalf = originalImage[0].length / 2;

        for (int row = 0; row < originalImage.length; row++) {

            int newCol = 0;

            for (int col = colHalf - 1; col >= 0; col--) {

                outputImage[row][col] = originalImage[row][colHalf - 1 - newCol / amount];

                newCol++;

            }

        }

        for (int row = 0; row < originalImage.length; row++) {

            int newCol = 0;

            for (int col = colHalf; col < originalImage[0].length; col++) {

                outputImage[row][col] = originalImage[row][colHalf + newCol / amount];

                newCol++;

            }

        }

        return outputImage;

    }



    /**

     * Remove a green screen mask from an image.

     * <p>

     * This function should remove primarily green pixels from an image and replace them with

     * transparent pixels (FILL_VALUE), allowing you to achieve a green screen effect. Obviously

     * this function will destroy pixels, but it <i>does not modify the original image</i>.

     * <p>

     * While this function is tested by the test suite, only extreme edge cases are used. Getting it

     * work work will with real green screen images is left as a challenge for you.

     *

     * @param originalImage the image to remove green from

     * @return the image with the green removed

     */

    public static int[][] greenScreen(final int[][] originalImage) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                int finalPixel = originalImage[row][col];

                int redComponent = finalPixel & C1_VALUE;

                int greenComponent = (finalPixel & C3_VALUE) >> EIGHT;

                int blueComponent = (finalPixel & C5_VALUE) >> SIXTEEN;

                if ((greenComponent > redComponent) && (greenComponent > blueComponent)) {

                    finalPixel = FILL_VALUE;

                }

                outputImage[row][col] = finalPixel;

            }

        }

        return outputImage;

    }

    /**

     * A wild and mysterious image transform: Swap color blur to red, red to green, green to blue.

     * <p>

     * You are free to implement this in any way you want. It is not tested rigorously by the test

     * suite, but it should do something (change the original image) and <i>not modify the original

     * image</i>.

     * <p>

     * Call this function mystery. It should take only the original image as a single argument and

     * return a modified image.

     *

     * @param originalImage the image to perform a strange and interesting transform on

     * @return the image transformed in wooly and frightening ways

     */

    public static int[][] mystery(final int[][] originalImage) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                int finalPixel = originalImage[row][col];

                int redComponent = finalPixel & C1_VALUE;

                int greenComponent = (finalPixel & C3_VALUE) >> EIGHT;

                int blueComponent = (finalPixel & C5_VALUE) >> SIXTEEN;

                outputImage[row][col] =

                        (finalPixel & ALPHA_SHIFT) | (greenComponent << SIXTEEN)

                        | (redComponent << EIGHT) | blueComponent;

            }

        }

        return outputImage;

    }


  //Conver color image to grey image
  public static int[][] mystery1(final int[][] originalImage) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];



        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                int finalPixel = originalImage[row][col];

                int redComponent = finalPixel & C1_VALUE;

                int greenComponent = (finalPixel & C3_VALUE) >> EIGHT;

                int blueComponent = (finalPixel & C5_VALUE) >> SIXTEEN;

                                int greyComponent = (redComponent + greenComponent + blueComponent)/3; //find grey level based on RGB

                                //Convert color image to grey image

                outputImage[row][col] =

                        (finalPixel & ALPHA_SHIFT) | (greyComponent << SIXTEEN)

                        | (greyComponent << EIGHT) | greyComponent;

            }

        }

                return outputImage;

  }



  //swap color with more ways
static int mysteryType = 0;

  public static int[][] mystery2(final int[][] originalImage) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];



        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                int finalPixel = originalImage[row][col];

                int redComponent = finalPixel & C1_VALUE;

                int greenComponent = (finalPixel & C3_VALUE) >> EIGHT;

                int blueComponent = (finalPixel & C5_VALUE) >> SIXTEEN;

                                //Swap colors in RGB

                                if (mysteryType == 0) {                                   //Switch ABGR to AGRB

                              outputImage[row][col] =

                        (finalPixel & ALPHA_SHIFT) | (greenComponent << SIXTEEN)

                        | (redComponent << EIGHT) | blueComponent;

                                } else if(mysteryType == 1) {                        //Switch ABGR to ARGB

                              outputImage[row][col] =

                        (finalPixel & ALPHA_SHIFT) | (greenComponent << EIGHT)

                        | (redComponent << SIXTEEN) | blueComponent;

                                } else if(mysteryType == 1) {                        //Switch ABGR to AGBR

                              outputImage[row][col] =

                        (finalPixel & ALPHA_SHIFT) | (greenComponent << SIXTEEN)

                        | redComponent | (blueComponent << EIGHT);

                                }

            }

        }

                mysteryType = (mysteryType+1)%3;  //Make loop of 3 types of mystery

        return outputImage;

    }


  //Convert image to edge based scratch
  public static int[][] mystery3(final int[][] originalImage) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];



        for (int row = 0; row < originalImage.length-1; row++) {

            for (int col = 0; col < originalImage[0].length-1; col++) {

                int finalPixel = originalImage[row][col];

                int redComponent = finalPixel & C1_VALUE;

                int greenComponent = (finalPixel & C3_VALUE) >> EIGHT;

                int blueComponent = (finalPixel & C5_VALUE) >> SIXTEEN;



                int nextRowPixel = originalImage[row+1][col];

                int redComponent1 = nextRowPixel & C1_VALUE;

                int greenComponent1 = (nextRowPixel & C3_VALUE) >> EIGHT;

                int blueComponent1 = (nextRowPixel & C5_VALUE) >> SIXTEEN;



                int nextColPixel = originalImage[row][col+1];

                int redComponent2 = nextColPixel & C1_VALUE;

                int greenComponent2 = (nextColPixel & C3_VALUE) >> EIGHT;

                int blueComponent2 = (nextColPixel & C5_VALUE) >> SIXTEEN;

                int redEdge1 = redComponent-redComponent1;
                if (redEdge1 < 0) redEdge1 = redEdge1 * -1;

                int redEdge2 = redComponent-redComponent2;
                if (redEdge2 < 0) redEdge2 = redEdge2 * -1;

                int greenEdge1 = greenComponent-greenComponent1;
                if (greenEdge1 < 0) greenEdge1 = greenEdge1 * -1;

                int greenEdge2 = greenComponent-greenComponent2;
                if (greenEdge2 < 0) greenEdge2 = greenEdge2 * -1;

                int blueEdge1 = blueComponent-blueComponent1;
                if (blueEdge1 < 0) blueEdge1 = blueEdge1 * -1;

                int blueEdge2 = blueComponent-blueComponent2;
                if (blueEdge2 < 0) blueEdge2 = blueEdge2 * -1;

                int edgeComponent = (redEdge1 + redEdge2 + greenEdge1 + greenEdge2 + blueEdge1 + blueEdge2)/6;

                //Convert color image to edge based scratch

                outputImage[row][col] =

                        (finalPixel & ALPHA_SHIFT) | (edgeComponent << SIXTEEN)

                        | (edgeComponent << EIGHT) | edgeComponent;

            }

                    //Copy the last col

                    outputImage[row][originalImage[0].length-1] = originalImage[row][originalImage[0].length-1];

        }

        int row = originalImage.length-1;

        for (int col = 0; col < originalImage[0].length; col++) {

                    outputImage[row][col] = originalImage[row][col];

                }



                return outputImage;

  }


  //flip bits of grey image
  public static int[][] mystery4(final int[][] originalImage) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];



        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                int finalPixel = originalImage[row][col];

                int redComponent = finalPixel & C1_VALUE;

                int greenComponent = (finalPixel & C3_VALUE) >> EIGHT;

                int blueComponent = (finalPixel & C5_VALUE) >> SIXTEEN;

                int greyComponent = (redComponent + greenComponent + blueComponent)/3; //find grey level based on RGB

                //Convert color image to grey image

                outputImage[row][col] =

                        (finalPixel & ALPHA_SHIFT) | (greyComponent << SIXTEEN)

                        | (greyComponent << EIGHT) | greyComponent;

                                //Flip all bits in grey pixel

                outputImage[row][col] = 0xFFFFFFFF ^  outputImage[row][col];

            }

        }

                return outputImage;

  }


  //Conver color image to 2 bits color image
  public static int[][] mystery5(final int[][] originalImage) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];



        for (int row = 0; row < originalImage.length; row++) {

            for (int col = 0; col < originalImage[0].length; col++) {

                int finalPixel = originalImage[row][col];

                int redComponent = finalPixel & C1_VALUE;

                int greenComponent = (finalPixel & C3_VALUE) >> EIGHT;

                int blueComponent = (finalPixel & C5_VALUE) >> SIXTEEN;

                //Eacu color uses only 2 effective bits
                redComponent = (redComponent>>6) << 6;
                greenComponent = (greenComponent>>6) << 6;
                blueComponent = (blueComponent>>6) << 6;

                outputImage[row][col] =

                        (finalPixel & ALPHA_SHIFT) | (blueComponent << SIXTEEN)
                        | (greenComponent << EIGHT) | redComponent;

            }

        }

        return outputImage;

  }

  //Convert image to edge based black scratch with color
  public static int[][] mystery6(final int[][] originalImage) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length-1; row++) {

            for (int col = 0; col < originalImage[0].length-1; col++) {

                int finalPixel = originalImage[row][col];

                int redComponent = finalPixel & C1_VALUE;

                int greenComponent = (finalPixel & C3_VALUE) >> EIGHT;

                int blueComponent = (finalPixel & C5_VALUE) >> SIXTEEN;



                int nextRowPixel = originalImage[row+1][col];

                int redComponent1 = nextRowPixel & C1_VALUE;

                int greenComponent1 = (nextRowPixel & C3_VALUE) >> EIGHT;

                int blueComponent1 = (nextRowPixel & C5_VALUE) >> SIXTEEN;



                int nextColPixel = originalImage[row][col+1];

                int redComponent2 = nextColPixel & C1_VALUE;

                int greenComponent2 = (nextColPixel & C3_VALUE) >> EIGHT;

                int blueComponent2 = (nextColPixel & C5_VALUE) >> SIXTEEN;

                int redEdge1 = redComponent-redComponent1;
                if (redEdge1 < 0) redEdge1 = redEdge1 * -1;

                int redEdge2 = redComponent-redComponent2;
                if (redEdge2 < 0) redEdge2 = redEdge2 * -1;

                int greenEdge1 = greenComponent-greenComponent1;
                if (greenEdge1 < 0) greenEdge1 = greenEdge1 * -1;

                int greenEdge2 = greenComponent-greenComponent2;
                if (greenEdge2 < 0) greenEdge2 = greenEdge2 * -1;

                int blueEdge1 = blueComponent-blueComponent1;
                if (blueEdge1 < 0) blueEdge1 = blueEdge1 * -1;

                int blueEdge2 = blueComponent-blueComponent2;
                if (blueEdge2 < 0) blueEdge2 = blueEdge2 * -1;

                blueComponent = (blueEdge1 + blueEdge2)/2;
                greenComponent = (greenEdge1 + greenEdge2)/2;
                redComponent = (redEdge1 + redEdge2)/2;

                //Convert color image to edge based scratch

                if((blueComponent + greenComponent + redComponent) > 100)
                    outputImage[row][col] = (finalPixel & ALPHA_SHIFT);  //make all color 0 to show black edge
                else
                    outputImage[row][col] = finalPixel;  //otherwise to show original color
            }

                    //Copy the last col

                    outputImage[row][originalImage[0].length-1] = originalImage[row][originalImage[0].length-1];

        }

        int row = originalImage.length-1;

        for (int col = 0; col < originalImage[0].length; col++) {

                    outputImage[row][col] = originalImage[row][col];

                }



                return outputImage;

  }
  /**
   * 1/9, the square blur coefficient that makes each pixel the average of surrounding pixs.
   */
  /**
   * 1/9, the square blur coefficient that makes each pixel the average of surrounding pixs.
   */
  static final int BLUR = 9;
  /**
   *  Adds a simple square blur to an image.
   * @param originalImage to be blurred
   * @return blurred image.
   */
  public static int[][] blur(final int[][] originalImage) {
      int[][] output = new int[originalImage.length][originalImage[0].length];
      for (int row = 1; row < originalImage.length - 1; row++) {
          for (int col = 1; col < originalImage[0].length - 1; col++) {
              long pix = (originalImage[row][col])
                        + (originalImage[row - 1][col - 1])
                        + (originalImage[row - 1][col])
                        + (originalImage[row - 1][col + 1])
                        + (originalImage[row][col - 1])
                        + (originalImage[row][col + 1])
                        + (originalImage[row + 1][col - 1])
                        + (originalImage[row + 1][col])
                        + (originalImage[row + 1][col + 1]);
              pix = pix / BLUR;
              output[row][col] = (int) pix;
          }
      }
      return output;
  }
  /**
   * Sorts all of the pixels in the original image from lowest to highest numerical value.
   * @param originalImage to be modified.
   * @return modified, sorted image.
   */
  public static int[][] sortedPixels(final int[][] originalImage) {
      int[][] output = new int[originalImage.length][originalImage[0].length];
      int[] pixelArray = new int[originalImage.length * originalImage[0].length];
      for (int row = 0; row < output.length; row++) {
          for (int col = 0; col < output[0].length; col++) {
              int pos = (row * output[0].length) + col;
              pixelArray[pos] = originalImage[row][col];
          }
      }
      Arrays.sort(pixelArray);
      for (int i = 0; i < pixelArray.length; i++) {
          int row = i / output[0].length;
          int col = i % output[0].length;
          output[row][col] = pixelArray[i];
      }
      return output;
  }

  //Convert image to colored edge based scratch
  public static int[][] mystery7(final int[][] originalImage) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length-1; row++) {

            for (int col = 0; col < originalImage[0].length-1; col++) {

                int finalPixel = originalImage[row][col];

                int redComponent = finalPixel & C1_VALUE;

                int greenComponent = (finalPixel & C3_VALUE) >> EIGHT;

                int blueComponent = (finalPixel & C5_VALUE) >> SIXTEEN;



                int nextRowPixel = originalImage[row+1][col];

                int redComponent1 = nextRowPixel & C1_VALUE;

                int greenComponent1 = (nextRowPixel & C3_VALUE) >> EIGHT;

                int blueComponent1 = (nextRowPixel & C5_VALUE) >> SIXTEEN;



                int nextColPixel = originalImage[row][col+1];

                int redComponent2 = nextColPixel & C1_VALUE;

                int greenComponent2 = (nextColPixel & C3_VALUE) >> EIGHT;

                int blueComponent2 = (nextColPixel & C5_VALUE) >> SIXTEEN;

                int redEdge1 = redComponent-redComponent1;
                if (redEdge1 < 0) redEdge1 = redEdge1 * -1;

                int redEdge2 = redComponent-redComponent2;
                if (redEdge2 < 0) redEdge2 = redEdge2 * -1;

                int greenEdge1 = greenComponent-greenComponent1;
                if (greenEdge1 < 0) greenEdge1 = greenEdge1 * -1;

                int greenEdge2 = greenComponent-greenComponent2;
                if (greenEdge2 < 0) greenEdge2 = greenEdge2 * -1;

                int blueEdge1 = blueComponent-blueComponent1;
                if (blueEdge1 < 0) blueEdge1 = blueEdge1 * -1;

                int blueEdge2 = blueComponent-blueComponent2;
                if (blueEdge2 < 0) blueEdge2 = blueEdge2 * -1;

                blueComponent = (blueEdge1 + blueEdge2)/2;
                greenComponent = (greenEdge1 + greenEdge2)/2;
                redComponent = (redEdge1 + redEdge2)/2;

                //Convert color image to edge based scratch

                outputImage[row][col] =

                        (finalPixel & ALPHA_SHIFT) | (blueComponent << SIXTEEN)

                        | (greenComponent << EIGHT) | redComponent;

            }

                    //Copy the last col

                    outputImage[row][originalImage[0].length-1] = originalImage[row][originalImage[0].length-1];

        }

        int row = originalImage.length-1;

        for (int col = 0; col < originalImage[0].length; col++) {

                    outputImage[row][col] = originalImage[row][col];

                }



                return outputImage;

  }

  //Convert image to edge based white scratch with color
  public static int[][] mystery8(final int[][] originalImage) {

        int[][] outputImage = new int[originalImage.length][originalImage[0].length];

        for (int row = 0; row < originalImage.length-1; row++) {

            for (int col = 0; col < originalImage[0].length-1; col++) {

                int finalPixel = originalImage[row][col];

                int redComponent = finalPixel & C1_VALUE;

                int greenComponent = (finalPixel & C3_VALUE) >> EIGHT;

                int blueComponent = (finalPixel & C5_VALUE) >> SIXTEEN;



                int nextRowPixel = originalImage[row+1][col];

                int redComponent1 = nextRowPixel & C1_VALUE;

                int greenComponent1 = (nextRowPixel & C3_VALUE) >> EIGHT;

                int blueComponent1 = (nextRowPixel & C5_VALUE) >> SIXTEEN;



                int nextColPixel = originalImage[row][col+1];

                int redComponent2 = nextColPixel & C1_VALUE;

                int greenComponent2 = (nextColPixel & C3_VALUE) >> EIGHT;

                int blueComponent2 = (nextColPixel & C5_VALUE) >> SIXTEEN;

                int redEdge1 = redComponent-redComponent1;
                if (redEdge1 < 0) redEdge1 = redEdge1 * -1;

                int redEdge2 = redComponent-redComponent2;
                if (redEdge2 < 0) redEdge2 = redEdge2 * -1;

                int greenEdge1 = greenComponent-greenComponent1;
                if (greenEdge1 < 0) greenEdge1 = greenEdge1 * -1;

                int greenEdge2 = greenComponent-greenComponent2;
                if (greenEdge2 < 0) greenEdge2 = greenEdge2 * -1;

                int blueEdge1 = blueComponent-blueComponent1;
                if (blueEdge1 < 0) blueEdge1 = blueEdge1 * -1;

                int blueEdge2 = blueComponent-blueComponent2;
                if (blueEdge2 < 0) blueEdge2 = blueEdge2 * -1;

                blueComponent = (blueEdge1 + blueEdge2)/2;
                greenComponent = (greenEdge1 + greenEdge2)/2;
                redComponent = (redEdge1 + redEdge2)/2;

                //Convert color image to edge based scratch

                if((blueComponent + greenComponent + redComponent) > 100)
                    outputImage[row][col] = (finalPixel & ALPHA_SHIFT) | 0x00FFFFFF; //make all color FF to show white edge
                else
                    outputImage[row][col] = finalPixel; //otherwise, keep the original color
            }

            //Copy the last col
            outputImage[row][originalImage[0].length-1] = originalImage[row][originalImage[0].length-1];

        }

        int row = originalImage.length-1;

        for (int col = 0; col < originalImage[0].length; col++) {

                    outputImage[row][col] = originalImage[row][col];

                }

                return outputImage;

  }

}