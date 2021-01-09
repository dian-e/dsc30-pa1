/*

 * NAME: Diane Li

 * PID: A15773774

 */
import java.util.Arrays;

/**
 * First PA of DSC30! Familiarizing with Java loops, matrixes
 *
 * @author Diane Li
 * @since ${01-07-2021}
 */
public class Startup {
    private static final int ODD_EVEN = 2;
    private static final int ASCII_MIN_UPPER = 65;
    private static final int ASCII_MIN_DIGIT = 48;
    private static final int ASCII_MAX_UPPER = 90;
    private static final int ASCII_MIN_LOWER = 97;
    private static final int ASCII_MAX_LOWER = 122;
    private static final int TRIPLET_LEN = 3;

    public static void main(String[] args) {
        // method 1: arrEvenOdd
        /* int[] arr1 = {0, 1, 2, 3, 4, 5};
        boolean[] output1 = {true, true, true, true, true, true};
        int[] arr2 = {0, 1, 2, 2, 1, 0};
        boolean[] output2 = {true, true, true, false, false, false};
        int[] arr3 = {1, 3, 5, 7, 9, 11};
        boolean[] output3 = {false, true, false, true, false, true};
        System.out.println(Arrays.toString(arrEvenOdd(arr1))); // == output1);
        System.out.println(Arrays.toString(arrEvenOdd(arr2))); // == output2);
        System.out.println(Arrays.toString(arrEvenOdd(arr3))); // == output3); */

        // method 2: removeVowels
        /* String input1 = "Hello";
        String input2 = "AEIOUaeiou";
        String input3 = "Hi how are...you?";
        System.out.println(removeVowels(input1));
        System.out.println(removeVowels(input2));
        System.out.println(removeVowels(input3)); */

        // method 3: compoundMass
        /* String compound1 = "D9";
        String compound2 = "C2C3Z4";
        String compound3 = "C1D2A3B4";
        System.out.println(compoundMass(compound1));
        System.out.println(compoundMass(compound2));
        System.out.println(compoundMass(compound3)); */

        // method 4: binarizeMatrix
        /* double[][] matrix1 = {{1.1, -2.2, -3.3}, {-4.4, 5.5, -6.6}, {-7.7, -8.8, 9.9}};
        double threshold1 = 0.0;
        double[][] matrix2 = {{-1.8, -2.3}, {-7.4, -3.9}};
        double threshold2 = -5.5;
        double[][] matrix3 = {{-100.0, 11.12, 133.001}, {4122.5, 25.23,  -61.442}, {-1092.1,   2.84, 771.555}};
        double threshold3 = 9999.9999;
        System.out.println(Arrays.deepToString(binarizeMatrix(matrix1, threshold1)));
        System.out.println(Arrays.deepToString(binarizeMatrix(matrix2, threshold2)));
        System.out.println(Arrays.deepToString(binarizeMatrix(matrix3, threshold3))); */

        // method 5: encryptString
        /* String encrypt1 = "abcdefg, hijklmn, OPQRST, UVWXYZ!";
        String encrypt2 = "ENCRYPT encrypt?";
        String encrypt3 = "CsE BaSeMeNt >.<";
        System.out.println(encryptString(encrypt1));
        System.out.println(encryptString(encrypt2));
        System.out.println(encryptString(encrypt3)); */

        // method 6: rotateArray
        /* double[] rotate1 = {1.1, 2.2};
        double[] rotate2 = {1.1, 2.2, 3.3, 4.4, 5.5};
        boolean left = true;
        boolean right = false;
        System.out.println(Arrays.toString(rotateArray(rotate1, left)));
        System.out.println(Arrays.toString(rotateArray(rotate2, left)));
        System.out.println(Arrays.toString(rotateArray(rotate2, right))); */

        // method 7: rotateTriplets
        /* double[] rotate3 = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
        double[] rotate4 = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        System.out.println(Arrays.toString(rotateTriplets(rotate2)));
        System.out.println(Arrays.toString(rotateTriplets(rotate3)));
        System.out.println(Arrays.toString(rotateTriplets(rotate4))); */

        // method 8: subsetChecker
        /* int[] set1_1 = {};
        int[] set1_2 = {1, 2, 3, 4};
        int[] set1_3 = {-2, 6, 7, 8};
        int[] set2_1 = {1, 2, 3};
        int[] set2_2 = {-10, -2, 1, 2, 3, 6, 7, 8, 9};
        System.out.println(subsetChecker(set1_1, set2_1));
        System.out.println(subsetChecker(set1_2, set2_1));
        System.out.println(subsetChecker(set1_3, set2_2)); */

        // method 9: numpadSRC
        int num1 = 35777;
        int num2 = 546540;
        int num3 = 7711404;
        System.out.println(numpadSRC(num1));
        System.out.println(numpadSRC(num2));
        System.out.println(numpadSRC(num3));

    }

    /**
     * Description of method
     *
     * @param para1 Description of para1
     * @param para2 Description of para2
     * @return Description of return value
     */
    public static boolean[] arrEvenOdd(int[] arr) {
        boolean[] output = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i % ODD_EVEN == arr[i] % ODD_EVEN) {
                output[i] = true;
            } else {
                output[i] = false;
            }
        }
        return output;
    }

    public static String removeVowels(String input) {
        String vowels = "aeiouAEIOU";
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            if (vowels.indexOf(input.charAt(i)) == -1) {
                output += input.charAt(i);
            }
        }
        return output;
    }

    public static int compoundMass(String compound) {
        int mass = 0;
        char element;
        int elementMass;
        int count;
        for (int i = 0; i < compound.length(); i += 2) {
            element = compound.charAt(i);
            elementMass = (int) element - (ASCII_MIN_UPPER - 1);
            count = (int) compound.charAt(i + 1) - ASCII_MIN_DIGIT;
            mass += elementMass * count;
        }
        return mass;
    }

    public static int[][] binarizeMatrix(double[][] matrix, double threshold) {
        int num_rows = matrix.length;
        int num_cols = matrix[0].length;
        int[][] output = new int[num_rows][num_cols];
        for (int i = 0; i < num_rows; i++) {
            for (int j = 0; j < num_cols; j++) {
                if (matrix[i][j] < threshold) {
                    output[i][j] = 0;
                } else {
                    output[i][j] = 1;
                }
            }
        }
        return output;
    }

    public static String encryptString(String input) {
        String output = "";
        char next;
        int asciiVal;
        for (int i = input.length() - 1; i >= 0; i--) {
            next = input.charAt(i);
            asciiVal = (int) next;
            if (asciiVal >= ASCII_MIN_UPPER && asciiVal <= ASCII_MAX_UPPER) {
                next = (char) (ASCII_MIN_UPPER + ASCII_MAX_UPPER - asciiVal);
            } else if (asciiVal >= ASCII_MIN_LOWER && asciiVal <= ASCII_MAX_LOWER) {
                next = (char) (ASCII_MIN_LOWER + ASCII_MAX_LOWER - asciiVal);
            }
            output += next;
        }
        return output;
    }

    public static double[] rotateArray(double[] arr, boolean direction) {
        double[] output = new double[arr.length];
        if (direction) {
            for (int i = 1; i < arr.length; i++) {
                output[i - 1] = arr[i];
            }
            output[arr.length - 1] = arr[0];
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                output[i + 1] = arr[i];
            }
            output[0] = arr[arr.length - 1];
        }
        return output;
    }

    public static double[] rotateTriplets(double[] arr) {
        int i = 0;
        int elementsLeft = arr.length;
        int tripletsSeen = 0;
        double[] output = new double[arr.length];
        while (elementsLeft >= TRIPLET_LEN) {
            if (tripletsSeen % 2 == 0) {
                output[i] = arr[i + 1];
                output[i + 1] = arr[i + 2];
                output[i + 2] = arr[i];
            } else {
                output[i] = arr[i + 2];
                output[i + 1] = arr[i];
                output[i + 2] = arr[i + 1];
            }
            elementsLeft -= 3;
            i += 3;
            tripletsSeen++;
        }
        if (elementsLeft == 2) {
            output[i] = arr[i +1];
            output[i + 1] = arr[i];
        } else if (elementsLeft == 1) {
            output[i] = arr[i];
        }
        return output;
    }

    public static boolean subsetChecker(int[] set1, int[] set2) {
        boolean output = true;
        int j = 0;
        for (int i = 0; i < set1.length; i++) {
            if (set1.length <= 1) {
                return output;
            } else if (j >= set2.length || set1[i] < set2[j]) {
                output = false;
                return output;
            } else if (set1[i] == set2[j]) {
                j++;
            } else {
                i--;
                j++;
            }
        }
        return output;
    }

    public static boolean numpadSRC(int num) {
        boolean same = true;
        String number = String.valueOf(num);
        String seen = "";
        String rows = "147258369";
        char uniqueChar = '0';
        for (int i = 0; i < number.length() - 1; i++) {
            char thisChar = number.charAt(i);
            char nextChar = number.charAt(i + 1);
            if (thisChar == uniqueChar) {
                same = false;
                break;
            } else if (seen.indexOf(thisChar) != -1) {
                continue;
            } else if (rows.indexOf(thisChar)%TRIPLET_LEN != rows.indexOf(nextChar)%TRIPLET_LEN) {
                same = false;
                break;
            }
            seen += thisChar;
        }
        if (same) return same;
        seen = "";
        same = true;
        String cols = "123456789";
        for (int i = 0; i < number.length() - 1; i++) {
            char thisChar = number.charAt(i);
            char nextChar = number.charAt(i + 1);
            if (seen.indexOf(thisChar) != -1) {
                continue;
            } else if (thisChar == uniqueChar) {
                continue;
            } else if (cols.indexOf(thisChar)%TRIPLET_LEN != cols.indexOf(nextChar)%TRIPLET_LEN) {
                same = false;
                break;
            }
            seen += thisChar;
        }
        return same;
    }

}
