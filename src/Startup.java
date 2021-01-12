/*

 * NAME: Diane Li

 * PID: A15773774

 */

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
    private static final int NUMPAD_ROWS = 4;
    private static final int NUMPAD_COLS = 3;
    private static final int NUMPAD_ROW_CONVERT = 2;
    private static final int NUMS_PER = 3;

    /**
     * A method that takes an array and checks whether any odd position contains an odd element
     * and any even position contains an even element
     *
     * @param arr array of integers
     * @return output array of booleans indicating whether input index & value have same parity
     */
    public static boolean[] arrEvenOdd(int[] arr) {
        boolean[] output = new boolean[arr.length];
        // loops through input array and checks index number against element % 2
        for (int i = 0; i < arr.length; i++) {
            if (i % ODD_EVEN == arr[i] % ODD_EVEN) {
                output[i] = true;
            } else {
                output[i] = false;
            }
        }
        return output;
    }

    /**
     * A method that takes a string input and returns the string with all vowels removed
     *
     * @param input String with any characters, punctuation, capitalization
     * @return output String with all the same characters but no vowels of either case
     */
    public static String removeVowels(String input) {
        String vowels = "aeiouAEIOU";
        String output = "";
        // loops through input String and checks if each character is present in the vowels String
        for (int i = 0; i < input.length(); i++) {
            if (vowels.indexOf(input.charAt(i)) == -1) {
                output += input.charAt(i);
            }
        }
        return output;
    }

    /**
     * A method that takes a string compound and calculates its mass
     *
     * @param compound String with elements, capital letters (A-Z), followed by counts (1-9)
     * @return mass of compounds from summation of products of element letter weight and count
     */
    public static int compoundMass(String compound) {
        int mass = 0;
        char element;
        int elementMass;
        int count;
        // loops through compound elements, every 2 characters, and multiplies by following count
        for (int i = 0; i < compound.length(); i += 2) {
            element = compound.charAt(i);
            elementMass = (int) element - (ASCII_MIN_UPPER - 1);
            count = (int) compound.charAt(i + 1) - ASCII_MIN_DIGIT;
            mass += elementMass * count;
        }
        return mass;
    }

    /**
     * A method that takes a 2-dimensional matrix and threshold and returns the binarized matrix
     *
     * @param matrix double[][] rectangular matrix to be binarized
     * @param threshold to compare whether elements are smaller (0) or equal / greater (1)
     * @return output same size as input with binary values showing element compared to threshold
     */
    public static int[][] binarizeMatrix(double[][] matrix, double threshold) {
        int num_rows = matrix.length;
        int num_cols = matrix[0].length;
        int[][] output = new int[num_rows][num_cols];
        // loops through elements in input matrix and compares element value against threshold
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

    /**
     * A method that takes a string and encrypts it by applying the Atbash cipher on letters
     * (upper and lowercase), recersing the encrypted string, and then returning this
     *
     * @param input String of characters, punctuation, letters of both cases
     * @return output String reversing input string, encrypting letters, maintaining other chars
     */
    public static String encryptString(String input) {
        String output = "";
        char checking;
        int asciiVal;
        // loops through string backwards
        for (int i = input.length() - 1; i >= 0; i--) {
            checking = input.charAt(i);
            asciiVal = (int) checking;
            // checks if character's ascii value makes it an upper or lowercase letter
            if (asciiVal >= ASCII_MIN_UPPER && asciiVal <= ASCII_MAX_UPPER) {
                // encrypts by subtracting this ascii value from sum of max & min valuess of case
                checking = (char) (ASCII_MIN_UPPER + ASCII_MAX_UPPER - asciiVal);
            } else if (asciiVal >= ASCII_MIN_LOWER && asciiVal <= ASCII_MAX_LOWER) {
                checking = (char) (ASCII_MIN_LOWER + ASCII_MAX_LOWER - asciiVal);
            }
            output += checking;
        }
        return output;
    }

    /**
     * A method that takes an array and a direction and rotates the array to specified direction
     * for 1 position (index). Direction true means rotating to the left; otherwise to the right
     *
     * @param arr array of doubles to be rotated
     * @return output with each original element shifted one position and the tail element wrapped
     */
    public static double[] rotateArray(double[] arr, boolean direction) {
        double[] output = new double[arr.length];
        if (direction) {
            // for left direction, decreases index of each element and moves first to the end
            for (int i = 1; i < arr.length; i++) {
                output[i - 1] = arr[i];
            }
            output[arr.length - 1] = arr[0];
        } else {
            // for right, increases index of each element and moves last one to the start
            for (int i = 0; i < arr.length - 1; i++) {
                output[i + 1] = arr[i];
            }
            output[0] = arr[arr.length - 1];
        }
        return output;
    }

    /**
     * A method that takes an array rotates every 3 consecutive numbers in alternating directions,
     * starting with rotating the first 3 to the left. If the last group has 1 number, it is kept
     * unchanged; if is has 2 numbers, they are swapped
     *
     * @param arr array of doubles to be swapped in triplets
     * @return output with original pairs of 3 numbers rotated in alternating directions
     */
    public static double[] rotateTriplets(double[] arr) {
        int i = 0;
        int elementsLeft = arr.length;
        int tripletsSeen = 0;
        double[] output = new double[arr.length];
        // moves pointer through input array to rotate 3 elements at a time and track direction
        while (elementsLeft >= TRIPLET_LEN) {
            // at even counts of triplets passed, rotates the elements left; otherwise, right
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
        // if there are 2 elements left at the end, swaps them; if 1 element, remains unchanged
        if (elementsLeft == 2) {
            output[i] = arr[i +1];
            output[i + 1] = arr[i];
        } else if (elementsLeft == 1) {
            output[i] = arr[i];
        }
        return output;
    }

    /**
     * A method that takes 2 arrays of integers and checks if the first is a subset of the second
     *
     * @param set1 array of integers to be checked as a subset w no duplicates & in ascending order
     * @param set2 array of integers to be checked as encompassing set; in ascending order
     * @return output array of booleans indicating whether the input index & value have the same parity
     */
    public static boolean subsetChecker(int[] set1, int[] set2) {
        boolean output = true;
        // counter for indices of 2nd set
        int j = 0;
        // loops through 1st set; uses assumptions that both arrays are sorted in ascending order
        for (int i = 0; i < set1.length; i++) {
            if (set1.length <= 1) {
                return output;
            } else if (j >= set2.length || set1[i] < set2[j]) {
                // checked all values of 2nd set or 1st set element won't appear in 2nd anymore
                output = false;
                return output;
            } else if (set1[i] == set2[j]) {
                // element of 1st set is equal to current in 2nd; continue to next 2nd set index
                j++;
            } else {
                // check same 1st set element against next 2nd set element
                i--;
                j++;
            }
        }
        return output;
    }

    /**
     * A method that takes an integer and checks if all digits are int eh same row or column of the
     * numpad, assuming the input number is non-negative. The rows are {0, 123, 456, 789} and the
     * columns are {0147, 0258, 0369} with 0 being in all 3 columns
     *
     * @param num integer that is non-negative
     * @return same boolean indicating whether all digits are in either the same row or column
     */
    public static boolean numpadSRC(int num) {
        int lastDigit;
        String number = String.valueOf(num);
        // will track how many digits fall in each row and column of the numpad by indices of array
        int[] rows = new int[NUMPAD_ROWS];
        int[] cols = new int[NUMPAD_COLS];
        // loops through digits in input to check & truncate each last digit
        for (int i = 0; i < number.length(); i++) {
            lastDigit = num % 10;
            num /= 10;
            // special case for 0 digit that adds to own row and every single column
            if (lastDigit == 0) {
                rows[0] += 1;
                for (int j = 0; j < cols.length; j++) {
                    cols[j]++;
                }
            } else {
                // evaluates row & column of digit to fill corresponding indices in both arrays
                rows[(lastDigit + NUMPAD_ROW_CONVERT) / NUMS_PER]++;
                cols[lastDigit % NUMS_PER]++;
            }
        }
        boolean same = true;
        // checks if any index in either array is equal to the number of digits in input integer
        for (int same_row : rows) {
            if (same_row == number.length()) return same;
        }
        for (int same_col : cols) {
            if (same_col == number.length()) return same;
        }
        same = false;
        return same;
    }

}
