/**
 * ==========================================================
 * MAIN CLASS - UseCase5PalindromeCheckerApp
 * ==========================================================
 *
 * Use Case 5: Stack-Based Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using a Stack.
 * Characters are pushed into the stack and then
 * popped to compare with the original sequence.
 *
 * At this stage, the application:
 * - Pushes characters into stack
 * - Pops characters in reverse order
 * - Compares with original sequence
 * - Displays the result
 *
 * This maps stack behavior to reversal logic.
 *
 * @author Developer
 * @version 5.0
 */

import java.util.Scanner;
import java.util.Stack;

public class UseCase5PalindromeCheckerApp {

    /**
     * Application entry point for UC5.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Declare and initialize input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create a Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push each character into the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Compare by popping from stack
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}