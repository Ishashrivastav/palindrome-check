import java.util.*;

// Step 1: Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

// Step 2: Stack Strategy Implementation
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        // Compare by popping
        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Step 3: Deque Strategy Implementation
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }

        // Compare front and rear
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

// Step 4: Context Class
class PalindromeContext {

    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.checkPalindrome(input);
    }
}

// Step 5: Main Application
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Strategy Pattern Palindrome Checker ===");
        System.out.println("Choose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.executeStrategy(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}