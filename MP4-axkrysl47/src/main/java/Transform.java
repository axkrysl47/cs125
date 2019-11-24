/**
 * A class that runs implements several simple transformations on 2D image arrays.
 */
public class Transform {

    /**
     * Default amount to shift colors by.
     **/
    public static final int DEFAULT_COLOR_SHIFT = 0;

    /**
     * Default amount to shift an image's position by.
     **/
    public static final int DEFAULT_POSITION_SHIFT = 0;

    /**
     * The default resize factor.
     **/
    public static final int DEFAULT_RESIZE_AMOUNT = 0;

    /**
     *
     */
    public Transform() { }

    /**
     *
     for (int j = 0; j < originalImage[0].length; j++) {
     for (int i = 0; i < originalImage.length; i++) {
     System.out.print(originalImage[i][j] + ", ");
     }
     System.out.println();
     }
     */

    /**
     * Shifts an image to the left by a specified amount.
     * Any pixels shifted in from off screen should be filled with FILL_VALUE.
     * This function does not modify the original image.
     *
     * @param originalImage the image to shift to the left.
     * @param amount        the amount to shift the image to the left.
     * @return the shifted image.
     */
    public static RGBAPixel[][] shiftLeft(final RGBAPixel[][] originalImage, final int amount) {
        //System.out.println("Using shiftLeft " + amount);

        if (originalImage == null) {
            return null;
        }

        if (amount <= 0) {
            return originalImage;
        }

        RGBAPixel[][] output =
                new RGBAPixel[originalImage.length][originalImage[0].length];

        if (amount >= originalImage.length) {
            for (int i = 0; i < output.length; i++) {
                for (int j = 0; j < output[i].length; j++) {
                    output[i][j] = RGBAPixel.getFillValue();
                }
            }
            return output;
        }

        for (int i = 0; i < originalImage.length - amount; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j] = originalImage[i + amount][j];
            }
        }

        for (int i = originalImage.length - amount; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                output[i][j] = RGBAPixel.getFillValue();
            }
        }

        return output;
    }

    /**
     * Shifts an image to the right by a specified amount.
     * Any pixels shifted in from off screen should be filled with FILL_VALUE.
     * This function does not modify the original image.
     *
     * @param originalImage the image to shift to the right.
     * @param amount        the amount to shift the image to the right.
     * @return the shifted image.
     */
    public static RGBAPixel[][] shiftRight(final RGBAPixel[][] originalImage, final int amount) {
        //System.out.println("Using shiftRight ");

        if (originalImage == null) {
            return null;
        }

        if (amount <= 0) {
            return originalImage;
        }

        RGBAPixel[][] output =
                new RGBAPixel[originalImage.length][originalImage[0].length];

        if (amount >= originalImage.length) {
            for (int i = 0; i < output.length; i++) {
                for (int j = 0; j < output[i].length; j++) {
                    output[i][j] = RGBAPixel.getFillValue();
                }
            }
            return output;
        }

        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j] = RGBAPixel.getFillValue();
            }
        }

        for (int i = amount; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                output[i][j] = originalImage[i - amount][j];
            }
        }

        return output;
    }

    /**
     * Shifts an image to upwards by a specified amount.
     * Any pixels shifted in from off screen should be filled with FILL_VALUE.
     * This function does not modify the original image.
     *
     * @param originalImage the image to shift upwards.
     * @param amount        the amount to shift the image to the right.
     * @return the shifted image.
     */
    public static RGBAPixel[][] shiftUp(final RGBAPixel[][] originalImage, final int amount) {
        //System.out.println("Using shiftUp ");

        if (originalImage == null) {
            return null;
        }

        if (amount <= 0) {
            return originalImage;
        }

        RGBAPixel[][] output =
                new RGBAPixel[originalImage.length][originalImage[0].length];

        if (amount >= originalImage[0].length) {
            for (int i = 0; i < output.length; i++) {
                for (int j = 0; j < output[i].length; j++) {
                    output[i][j] = RGBAPixel.getFillValue();
                }
            }
            return output;
        }

        if (amount >= originalImage[0].length) {
            for (int i = 0; i < output.length; i++) {
                for (int j = 0; j < output[i].length; j++) {
                    output[i][j] = RGBAPixel.getFillValue();
                }
            }
            return output;
        }

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length - amount; j++) {
                output[i][j] = originalImage[i][j + amount];
            }
        }

        for (int i = 0; i < output.length; i++) {
            for (int j = originalImage[i].length - amount; j < output[i].length; j++) {
                output[i][j] = RGBAPixel.getFillValue();
            }
        }

        return output;
    }

    /**
     * Shifts an image to downwards by a specified amount.
     * Any pixels shifted in from off screen should be filled with FILL_VALUE.
     * This function does not modify the original image.
     *
     * @param originalImage the image to shift to downwards.
     * @param amount        the amount to shift the image to the right.
     * @return the shifted image.
     */
    public static RGBAPixel[][] shiftDown(final RGBAPixel[][] originalImage, final int amount) {
        //System.out.println("Using shiftDown ");

        if (originalImage == null) {
            return null;
        }

        if (amount <= 0) {
            return originalImage;
        }

        RGBAPixel[][] output =
                new RGBAPixel[originalImage.length][originalImage[0].length];

        if (amount >= originalImage[0].length) {
            for (int i = 0; i < output.length; i++) {
                for (int j = 0; j < output[i].length; j++) {
                    output[i][j] = RGBAPixel.getFillValue();
                }
            }
            return output;
        }

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < amount; j++) {
                output[i][j] = RGBAPixel.getFillValue();
            }
        }

        for (int i = 0; i < output.length; i++) {
            for (int j = amount; j < output[i].length; j++) {
                output[i][j] = originalImage[i][j - amount];
            }
        }

        return output;
    }

    /**
     * Rotate the image left by 90 degrees around its center.
     * Any pixels rotated in from off screen should be filled with FILL_VALUE.
     * This function does not modify the original image.
     *
     * @param originalImage the image to rotate left 90 degrees.
     * @return the rotated image.
     */
    public static RGBAPixel[][] rotateLeft(final RGBAPixel[][] originalImage) {
        //System.out.println("Using rotateLeft " + originalImage.length
        // + " " + originalImage[0].length);

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] rotated = new RGBAPixel[originalImage[0].length][originalImage.length];

        for (int i = 0; i < originalImage[0].length; i++) {
            for (int j = 0; j < originalImage.length; j++) {
                int position = originalImage.length - j - 1;
                rotated[i][j] = originalImage[position][i];
            }
        }

        RGBAPixel[][] output = new RGBAPixel[originalImage.length][originalImage[0].length];

        int difference = originalImage.length - originalImage[0].length;
        int center = Math.abs(difference / 2);

        if (originalImage.length > originalImage[0].length) {
            for (int j = 0; j < rotated[0].length - center && j < output[0].length; j++) {
                for (int i = 0; i < output.length - center && i < rotated.length; i++) {
                    int iCenter = i + center;
                    int jCenter = j + center;
                    output[iCenter][j] = rotated[i][jCenter];
                }
            }
        } else if (originalImage.length < originalImage[0].length) {
            for (int j = 0; j < output[0].length - center && j < rotated[0].length; j++) {
                for (int i = 0; i < rotated.length - center && i < output.length; i++) {
                    int iCenter = i + center;
                    int jCenter = j + center;
                    output[i][jCenter] = rotated[iCenter][j];
                }
            }
        } else {
            for (int j = 0; j < output[0].length; j++) {
                for (int i = 0; i < output.length; i++) {
                    output[i][j] = rotated[i][j];
                }
            }
        }

        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                if (output[i][j] == null) {
                    output[i][j] = RGBAPixel.getFillValue();
                }
            }
        }

        return output;
    }

    /**
     * Rotate the image right by 90 degrees around its center.
     * Any pixels rotated in from off screen should be filled with FILL_VALUE.
     * This function does not modify the original image.
     *
     * @param originalImage the image to rotate right 90 degrees.
     * @return the rotated image.
     */
    public static RGBAPixel[][] rotateRight(final RGBAPixel[][] originalImage) {
        //System.out.println("Using rotateRight " + originalImage.length
        // + " " + originalImage[0].length);

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] rotated = new RGBAPixel[originalImage[0].length][originalImage.length];

        for (int i = 0; i < originalImage[0].length; i++) {
            for (int j = 0; j < originalImage.length; j++) {
                int position = originalImage.length - j - 1;
                rotated[i][position] = originalImage[position][i];
            }
        }

        rotated = Transform.flipHorizontal(rotated);

        RGBAPixel[][] output = new RGBAPixel[originalImage.length][originalImage[0].length];

        int difference = originalImage.length - originalImage[0].length;
        int center = Math.abs(difference / 2);

        if (originalImage.length > originalImage[0].length) {
            for (int j = 0; j < rotated[0].length - center && j < output[0].length; j++) {
                for (int i = 0; i < output.length - center && i < rotated.length; i++) {
                    int iCenter = i + center;
                    int jCenter = j + center;
                    output[iCenter][j] = rotated[i][jCenter];
                }
            }
        } else if (originalImage.length < originalImage[0].length) {
            for (int j = 0; j < output[0].length - center && j < rotated[0].length; j++) {
                for (int i = 0; i < rotated.length - center && i < output.length; i++) {
                    int iCenter = i + center;
                    int jCenter = j + center;
                    output[i][jCenter] = rotated[iCenter][j];
                }
            }
        } else {
            for (int j = 0; j < output[0].length; j++) {
                for (int i = 0; i < output.length; i++) {
                    output[i][j] = rotated[i][j];
                }
            }
        }

        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                if (output[i][j] == null) {
                    output[i][j] = RGBAPixel.getFillValue();
                }
            }
        }

        return output;
    }

    /**
     * Flip the image on the vertical axis across its center.
     * This function does not modify the original image.
     * It should also not generate any new filled pixels.
     *
     * @param originalImage the image to flip on its vertical axis.
     * @return the flipped image.
     */
    public static RGBAPixel[][] flipVertical(final RGBAPixel[][] originalImage) {
        //System.out.println("Using flipVertical ");

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] output =
                new RGBAPixel[originalImage.length][originalImage[0].length];

        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                output[i][j] = originalImage[i][output[i].length - j - 1];
            }
        }

        return output;
    }

    /**
     * Flip the image on the horizontal axis across its center.
     * This function does not modify the original image.
     * It should also not generate any new filled pixels.
     *
     * @param originalImage the image to flip on its horizontal axis.
     * @return the flipped image
     */
    public static RGBAPixel[][] flipHorizontal(final RGBAPixel[][] originalImage) {
        //System.out.println("Using flipHorizontal ");

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] output =
                new RGBAPixel[originalImage.length][originalImage[0].length];

        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                output[i][j] = originalImage[output.length - i - 1][j];
            }
        }

        return output;
    }

    /**
     * Add red to the image.
     * This function does not modify the original image.
     * It should also not generate any new filled pixels.
     *
     * @param originalImage the image to add red to.
     * @param amount        the amount of red to add.
     * @return the recolored image
     */
    public static RGBAPixel[][] moreRed(final RGBAPixel[][] originalImage, final int amount) {
        //System.out.println("Using moreRed " + amount);

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] output = new RGBAPixel[originalImage.length][originalImage[0].length];

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j] = new RGBAPixel(originalImage[i][j]);
            }
        }

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j].setRed(output[i][j].getRed() + amount);
            }
        }

        return output;
    }

    /**
     * Remove red from the image.
     * This function does not modify the original image.
     * It should also not generate any new filled pixels.
     *
     * @param originalImage the image to remove red from.
     * @param amount        the amount of red to remove.
     * @return the recolored image.
     */
    public static RGBAPixel[][] lessRed(final RGBAPixel[][] originalImage, final int amount) {
        //System.out.println("Using lessRed ");

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] output = new RGBAPixel[originalImage.length][originalImage[0].length];

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j] = new RGBAPixel(originalImage[i][j]);
            }
        }

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j].setRed(output[i][j].getRed() - amount);
            }
        }

        return output;
    }

    /**
     * Add green to the image.
     * This function does not modify the original image.
     * It should also not generate any new filled pixels.
     *
     * @param originalImage the image to add green to.
     * @param amount        the amount of green to add.
     * @return the recolored image.
     */
    public static RGBAPixel[][] moreGreen(final RGBAPixel[][] originalImage, final int amount) {
        //System.out.println("Using moreGreen ");

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] output = new RGBAPixel[originalImage.length][originalImage[0].length];

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j] = new RGBAPixel(originalImage[i][j]);
            }
        }

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j].setGreen(output[i][j].getGreen() + amount);
            }
        }

        return output;
    }

    /**
     * Remove green from the image.
     * This function does not modify the original image.
     * It should also not generate any new filled pixels.
     *
     * @param originalImage the image to remove green from.
     * @param amount        the amount of green to remove.
     * @return the recolored image.
     */
    public static RGBAPixel[][] lessGreen(final RGBAPixel[][] originalImage, final int amount) {
        //System.out.println("Using lessGreen ");

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] output = new RGBAPixel[originalImage.length][originalImage[0].length];

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j] = new RGBAPixel(originalImage[i][j]);
            }
        }

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j].setGreen(output[i][j].getGreen() - amount);
            }
        }

        return output;
    }

    /**
     * Add blue to the image.
     * This function does not modify the original image.
     * It should also not generate any new filled pixels.
     *
     * @param originalImage the image to add blue to.
     * @param amount        the amount of blue to add.
     * @return the recolored image
     */
    public static RGBAPixel[][] moreBlue(final RGBAPixel[][] originalImage, final int amount) {
        //System.out.println("Using moreBlue ");

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] output = new RGBAPixel[originalImage.length][originalImage[0].length];

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j] = new RGBAPixel(originalImage[i][j]);
            }
        }

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j].setBlue(output[i][j].getBlue() + amount);
            }
        }

        return output;
    }

    /**
     * Remove blue from the image.
     * This function does not modify the original image.
     * It should also not generate any new filled pixels.
     *
     * @param originalImage the image to remove blue from.
     * @param amount        the amount of blue to remove.
     * @return the recolored image
     */
    public static RGBAPixel[][] lessBlue(final RGBAPixel[][] originalImage, final int amount) {
        //System.out.println("Using lessBlue ");

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] output = new RGBAPixel[originalImage.length][originalImage[0].length];

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j] = originalImage[i][j];
            }
        }

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j].setRed(output[i][j].getBlue() - amount);
            }
        }

        return output;
    }

    /**
     * Increase the image alpha channel value.
     * This function does not modify the original image.
     * It should also not generate any new filled pixels.
     * Note that increasing the alpha channel value makes the image less, not more, transparent.
     *
     * @param originalImage the image to remove transparency from.
     * @param amount        the amount of transparency to remove.
     * @return the less transparent image.
     */
    public static RGBAPixel[][] moreAlpha(final RGBAPixel[][] originalImage, final int amount) {
        //System.out.println("Using moreAlpha ");

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] output = new RGBAPixel[originalImage.length][originalImage[0].length];

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j] = new RGBAPixel(originalImage[i][j]);
            }
        }

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j].setAlpha(output[i][j].getAlpha() + amount);
            }
        }

        return output;
    }

    /**
     * Decrease the image alpha channel value.
     * This function does not modify the original image.
     * It should also not generate any new filled pixels.
     * Note that decreasing the image alpha channel value makes the image more,
     * not less, transparent.
     *
     * @param originalImage the image to add transparency to.
     * @param amount        the amount of transparency to add.
     * @return the more transparent image.
     */
    public static RGBAPixel[][] lessAlpha(final RGBAPixel[][] originalImage, final int amount) {
        //System.out.println("Using lessAlpha ");

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] output = new RGBAPixel[originalImage.length][originalImage[0].length];

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j] = new RGBAPixel(originalImage[i][j]);
            }
        }

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                output[i][j].setAlpha(output[i][j].getAlpha() - amount);
            }
        }

        return output;
    }

    /**
     * Shrink in the vertical axis around the image center.
     * An amount of 2 will result in an image that is half its original height.
     * An amount of 3 will result in an image that's a third of its original height.
     * Any pixels shrunk in from off screen should be filled with FILL_VALUE.
     * This function does not modify the original image.
     * Note that this function is not tested by the test suite.
     * You are free to complete it to enable shrink in the web interface,
     * but it will not affect your score.
     *
     * @param originalImage the image to shrink.
     * @param amount        the factor by which the image's height is reduced.
     * @return the shrunken image.
     */
    public static RGBAPixel[][] shrinkVertical(final RGBAPixel[][] originalImage,
                                               final int amount) {
        System.out.println("Using shrinkVertical ");

        if (originalImage == null) {
            return null;
        }

        for (int j = 0; j < originalImage[0].length; j++) {
            for (int i = 0; i < originalImage.length; i++) {
                System.out.print(originalImage[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println();

        RGBAPixel[][] output =
                new RGBAPixel[originalImage.length][originalImage[0].length / amount];

        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                output[i][j] = originalImage[i][amount * j];
            }
        }

        return output;
    }

    /**
     * Expand in the vertical axis around the image center.
     * An amount of 2 will result in an image that is twice its original height.
     * An amount of 3 will result in an image that's three times its original height.
     * This function does not modify the original image.
     * It should also not generate any new filled pixels.
     * Note that this function should not modify the canvas size.
     * Pixels within the original image should be expanded,
     * but the canvas size should remain unchanged.
     * Some pixels will end up off screen, which is fine.
     *
     * @param originalImage the image to expand.
     * @param amount        the factor by which the image's height is increased.
     * @return the expanded image.
     */
    public static RGBAPixel[][] expandVertical(final RGBAPixel[][] originalImage,
                                               final int amount) {
        //System.out.println("Using expandVertical " + amount);

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] output =
                new RGBAPixel[originalImage.length][originalImage[0].length];

        int middle = (originalImage[0].length / 2) - 1;

        for (int j = middle; j >= 0; j--) {
            for (int i = 0; i < output.length; i++) {
                int increment = middle - j;
                double factor = middle - (increment / amount);
                int position = (int) Math.round(factor);

                output[i][j] = originalImage[i][position];
            }
        }

        for (int j = middle + 1; j < output[0].length; j++) {
            for (int i = 0; i < output.length; i++) {
                int increment = j - middle - 1;
                double factor = middle + 1 + (increment / amount);
                int position = (int) Math.round(factor);

                output[i][j] = originalImage[i][position];
            }
        }

        return output;
    }

    /**
     * Shrink in the horizontal axis around the image center.
     * An amount of 2 will result in an image that is half its original width.
     * An amount of 3 will result in an image that's a third of its original width.
     * Any pixels shrunk in from off screen should be filled with FILL_VALUE.
     * This function does not modify the original image.
     * Note that this function is not tested by the test suite.
     * You are free to complete it to enable shrink in the web interface,
     * but it will not affect your score.
     *
     * @param originalImage the image to shrink.
     * @param amount        the factor by which the image's width is reduced.
     * @return the shrunken image.
     */
    public static RGBAPixel[][] shrinkHorizontal(final RGBAPixel[][] originalImage,
                                                 final int amount) {
        //System.out.println("Using shrinkHorizontal ");
        return null;
    }

    /**
     * Expand in the horizontal axis around the image center.
     * An amount of 2 will result in an image that is twice its original width.
     * An amount of 3 will result in an image that's three times its original width.
     * This function does not modify the original image.
     * It should also not generate any new filled pixels.
     * Note that this function should not modify the canvas size.
     * Pixels within the original image should be expanded,
     * but the canvas size should remain unchanged.
     * Some pixels will end up off screen, which is fine.
     *
     * @param originalImage the image to expand.
     * @param amount        the factor by which the image's width is increased.
     * @return the expanded image.
     */
    public static RGBAPixel[][] expandHorizontal(final RGBAPixel[][] originalImage,
                                                 final int amount) {
        //System.out.println("Using expandHorizontal " + amount);

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] output =
                new RGBAPixel[originalImage.length][originalImage[0].length];

        int middle = (originalImage.length / 2) - 1;

        for (int i = middle; i >= 0; i--) {
            for (int j = 0; j < output[i].length; j++) {
                int increment = middle - i;
                double factor = middle - (increment / amount);
                int position = (int) Math.round(factor);

                output[i][j] = originalImage[position][j];
            }
        }

        for (int i = middle + 1; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                int increment = i - middle - 1;
                double factor = middle + 1 + (increment / amount);
                int position = (int) Math.round(factor);

                output[i][j] = originalImage[position][j];
            }
        }

        return output;
    }

    /**
     * Remove a green screen mask from an image.
     * This function should remove primarily green pixels from an image
     * and replace them with transparent pixels (FILL_VALUE),
     * allowing you to achieve a green screen effect.
     * Obviously this function will destroy pixels,
     * but it does not modify the original image.
     *
     * @param originalImage the image to remove a green screen from.
     * @return the image with the green screen removed.
     */
    public static RGBAPixel[][] greenScreen(final RGBAPixel[][] originalImage) {
        //System.out.println("Using greenScreen ");

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] output =
                new RGBAPixel[originalImage.length][originalImage[0].length];

        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                RGBAPixel pixel = originalImage[i][j];

                if (pixel.getGreen() > pixel.getRed()
                    && pixel.getGreen() > pixel.getBlue()) {
                    output[i][j] = RGBAPixel.getFillValue();
                } else {
                    output[i][j] = originalImage[i][j];
                }
            }
        }

        return output;
    }

    /**
     * A wild and mysterious image transform.
     *
     * @param originalImage the image to perform a strange and interesting transform on.
     * @return the image transformed in wooly and frightening ways.
     */
    public static RGBAPixel[][] mystery(final RGBAPixel[][] originalImage) {
        //System.out.println("Using testMystery ");
        return null;
    }

    /**
     *
     * @param unused    unused.
     */
    public static void main(final String[] unused) {
        System.out.println("Main method not yet implemented. ");
    }
}
