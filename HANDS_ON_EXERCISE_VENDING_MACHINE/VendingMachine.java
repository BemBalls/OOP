import java.util.Scanner;

public class VendingMachine {
    static String[] products = {"Coke", "Water", "Chips", "Candy"};
    static int[] prices = {25, 15, 30, 10};
    static int[] stock = {5, 5, 5, 5};

    static int count1 = 0;
    static int count5 = 0;
    static int count10 = 0;
    static int count20 = 0;

    static int balance = 0;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Vending Machine!");

        boolean running = true;
        while (running) {
            displayMenu();
            System.out.println("\nOptions:");
            System.out.println("1 - Insert Coin");
            System.out.println("2 - Withdraw Money");
            System.out.println("3 - Select Item");
            System.out.println("4 - Exit");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    insertCoin();
                    break;
                case "2":
                    withdrawMoney();
                    break;
                case "3":
                    selectItem();
                    break;
                case "4":
                    running = false;
                    System.out.println("Thank you for using the vending machine. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-4.");
            }
        }
    }

    static void displayMenu() {
        System.out.println("\nAvailable Products:");
        System.out.println("-------------------");
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d. %s - %d pesos (Stock: %d)%n", i + 1, products[i], prices[i], stock[i]);
        }
        System.out.println("-------------------");
        System.out.println("Current balance: " + balance + " pesos");
        System.out.println("Coins inserted:");
        System.out.println("1 peso: " + count1);
        System.out.println("5 pesos: " + count5);
        System.out.println("10 pesos: " + count10);
        System.out.println("20 pesos: " + count20);
    }

    static void insertCoin() {
        boolean inserting = true;
        while (inserting) {
            System.out.print("Insert coin (1, 5, 10, 20) or 0 to stop inserting: ");
            String input = scanner.nextLine();
            int coin;
            try {
                coin = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (coin == 0) {
                inserting = false;
                break;
            }

            if (coin == 1 || coin == 5 || coin == 10 || coin == 20) {
                if (coin == 1) count1++;
                else if (coin == 5) count5++;
                else if (coin == 10) count10++;
                else if (coin == 20) count20++;

                balance += coin;
                System.out.println("Accepted " + coin + " peso coin.");
                System.out.println("Current balance: " + balance + " pesos");
                System.out.println("Coins inserted:");
                System.out.println("1 peso: " + count1);
                System.out.println("5 pesos: " + count5);
                System.out.println("10 pesos: " + count10);
                System.out.println("20 pesos: " + count20);
            } else {
                System.out.println("Invalid coin. Coin rejected.");
            }
        }
    }

    static void withdrawMoney() {
        if (balance == 0) {
            System.out.println("No money to withdraw.");
            return;
        }
        System.out.println("Withdrawing all inserted money...");
        System.out.println("Returned coins:");
        System.out.println("1 peso: " + count1);
        System.out.println("5 pesos: " + count5);
        System.out.println("10 pesos: " + count10);
        System.out.println("20 pesos: " + count20);
        balance = 0;
        count1 = 0;
        count5 = 0;
        count10 = 0;
        count20 = 0;
        System.out.println("Balance reset to 0.");
    }

    static void selectItem() {
        if (balance == 0) {
            System.out.println("You have no balance. Please insert coins first.");
            return;
        }

        while (true) {
            System.out.print("Select item number (1-" + products.length + ") or 0 to cancel: ");
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (choice == 0) {
                System.out.println("Item selection cancelled.");
                break;
            }

            if (choice < 1 || choice > products.length) {
                System.out.println("Invalid choice. Please select a valid item number.");
                continue;
            }

            int index = choice - 1;
            if (!checkStock(index)) {
                System.out.println("Item not available.");
                break;
            }

            if (balance < prices[index]) {
                System.out.println("Not enough money.");
                break;
            }

            releaseItem(index);
            break;
        }
    }

    static boolean checkStock(int index) {
        return stock[index] > 0;
    }

    static void releaseItem(int index) {
        System.out.println(products[index] + " dispensed.");
        stock[index]--;
        balance -= prices[index];

        if (balance > 0) {
            System.out.println("Change remaining: " + balance + " pesos.");
            System.out.println("You can buy more items or withdraw your remaining balance.");
        } else {
            System.out.println("Balance is now 0.");
            count1 = 0;
            count5 = 0;
            count10 = 0;
            count20 = 0;
        }
    }
}
