/*
 * ==============================================================
 * MAIN CLASS – UseCase2PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 2: Basic Palindrome Validation
 *
 * Description:
 * This class extends the Palindrome Checker Application by
 * implementing basic palindrome checking functionality.
 *
 * At this stage, the application:
 * - Starts execution from the main() method
 * - Displays a welcome message
 * - Accepts user input
 * - Checks whether the input string is a palindrome
 * - Displays the result
 *
 * The goal is to implement core palindrome logic using
 * basic string handling concepts.
 *
 * @author Developer
 * @version 1.0
 */

import java.util.Scanner;

public class UseCase2PalindromeCheckerApp {

    /**
     * Application entry point.
     *
     * This is the first method executed by the JVM
     * when the program starts.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Display Welcome Message
        System.out.println("======================================");
        System.out.println("     WELCOME TO PALINDROME CHECKER    ");
        System.out.println("======================================");

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter a string
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // Call palindrome checking method
        boolean result = isPalindrome(input);

        // Display Result
        if (result) {
            System.out.println("Result: The given string is a PALINDROME.");
        } else {
            System.out.println("Result: The given string is NOT a palindrome.");
        }

        // Close scanner
        scanner.close();
    }

    /**
     * Method to check whether a string is a palindrome.
     *
     * @param text Input string
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String text) {

        // Convert string to lowercase (optional basic normalization)
        text = text.toLowerCase();

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {

            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}