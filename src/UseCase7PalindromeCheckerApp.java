import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class UseCase7PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a string to check palindrome: ");
        String input = scanner.nextLine();

        input = input.toLowerCase(); // Optional: case insensitive

        // Create Deque to store characters
        Deque<Character> deque = new ArrayDeque<>();

        // Add each character to deque
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindrome = true;

        // Compare front and rear characters
        while (deque.size() > 1) {

            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        if (isPalindrome) {
            System.out.println("The string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}

