package HANDS_ON_EXERCISE_STOREBILLINGSYSTEM;
import java.util.Scanner;

public class StoreBillingNoLoopMoreFunctions {
    static Scanner scanner = new Scanner(System.in);
    static double total = 0.0;

    public static void main(String[] args) {
        processPurchase();
        total = applyTax(total);
        total = applySeniorDiscount(total);
        printReceipt(total);
        scanner.close();
    }

    public static void processPurchase() {
        int choice = askItemChoice();
        int qty = askQuantity();
        
        if (choice < 1 || choice > 4) {
            System.out.println("Invalid item selected");
            System.exit(0);
        }

        double price = getItemPrice(choice);
        String itemName = getItemName(choice);
        displayItems();
        
        double subtotal = computeSubtotal(price, qty);
        total += subtotal;
        System.out.println("Added " + qty + " x " + itemName + " = " + subtotal);
    }

    public static void displayItems() {
        System.out.println("==== Welcome to Bembi Store ====");
        System.out.println("");
        System.out.println("1. Soap - $30.00");
        System.out.println("2. Shampoo - $120.00");
        System.out.println("3. Toothpaste - $60.00");
        System.out.println("4. Rice (per kilo) - $45.00");
    }

    public static int askItemChoice() {
        System.out.print("Enter item number to purchase: ");
        return scanner.nextInt();
    }

    public static int askQuantity() {
        System.out.print("Enter quantity: ");
        return scanner.nextInt();
    }

    public static double getItemPrice(int choice) {
        double price = 0.0;

        if (choice == 1) {
            price = 30.00;
        } else if (choice == 2) {
            price = 120.00;
        } else if (choice == 3) {
            price = 60.00;
        } else if (choice == 4) {
            price = 45.00;
        }

        return price;
    }

    public static String getItemName(int choice) {
        String itemName = "Invalid Item";

        if (choice == 1) {
            itemName = "Soap";
        } else if (choice == 2) {
            itemName = "Shampoo";
        } else if (choice == 3) {
            itemName = "Toothpaste";
        } else if (choice == 4) {
            itemName = "Rice (per kilo)";
        }

        return itemName;
    }

    public static double computeSubtotal(double price, int qty) {
        return price * qty;
    }

    public static double applyTax(double amount) {
        double tax = amount * 0.10;
        System.out.println("Tax Added: " + String.format("%.2f", tax));
        return amount + tax;
    }

    public static double applySeniorDiscount(double amount) {
        double discount = 0.0;
        if (isSenior()) {
            discount = amount * 0.10;
            System.out.println("Senior Discount Applied: " + String.format("%.2f", discount));
        }
        return amount - discount;
    }

    public static boolean isSenior() {
        System.out.print("Are you a senior citizen? (yes/no): ");
        String senior = scanner.next();
        return senior.equalsIgnoreCase("yes");
    }

    public static void printReceipt(double finalAmount) {
        System.out.println("==== Final Bill ====");
        System.out.println("Total Amount: " + String.format("%.2f", finalAmount));
    }
}
