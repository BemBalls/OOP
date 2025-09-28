
import java.util.Scanner;

public class AdvancedVendingMachine {

    static int cokeStock = 5, waterStock = 5, chipsStock = 3, candyStock = 10;
    static int cokeSold = 0, waterSold = 0, chipsSold = 0, candySold = 0;
    static int totalSales = 0;
    static int cokePrice = 25, waterPrice = 15, chipsPrice = 30, candyPrice = 10;

    public static void main(String args[]) {
        int choice = 0;
        int balance = 0;
        boolean admin = false;

        Scanner input = new Scanner(System.in);
        while (choice != 8) {
            if (!admin) {
                System.out.printf("""
                              --- Vending Machine Menu ---\n
                              1. Coke - %d pesos (Stock: %d)\n
                              2. Water - %d pesos (Stock: %d)\n
                              3. Chips - %d pesos (Stock: %d)\n
                              4. Candy - %d pesos (Stock: %d)\n
                              5. Insert Coins\n
                              6. Withdraw Money\n
                              7. Admin Mode\n
                              8. Exit\n\n
                              Current Balance: %d\n\n
                              Please enter your choice: 
                              """, cokePrice, cokeStock, waterPrice, waterStock, chipsPrice, chipsStock, candyPrice, candyStock, balance);
                choice = input.nextInt();
                switch (choice) {
                    case 1, 2, 3, 4 ->
                        balance = selectItem(balance, choice);
                    case 5 ->
                        balance += insertCoin(input);
                    case 6 ->
                        balance = withdrawMoney(balance);
                    case 7 ->
                        admin = loginAdmin(input);
                    case 8 ->
                        System.out.println("Exiting program.\n");
                    default ->
                        System.out.println("Invalid choice!");
                }
            } else {
                System.out.print("""
                              --- Admin Menu ---\n
                              1. Restock Items\n
                              2. View Sales Report\n
                              3. Exit Admin Mode\n
                              Please enter your choice: 
                              """);
                choice = input.nextInt();
                switch (choice) {
                    case 1 -> {
                        cokeStock = restockItem(input, "Coke");
                        waterStock = restockItem(input, "Water");
                        chipsStock = restockItem(input, "Chips");
                        candyStock = restockItem(input, "Candy");
                        System.out.println("Items restocked!\n");
                    }
                    case 2 -> {
                        System.out.println("--- Sales Report ---");
                        viewSalesReport("Coke", cokeSold);
                        viewSalesReport("Water", waterSold);
                        viewSalesReport("Chips", chipsSold);
                        viewSalesReport("Candy", candySold);
                        System.out.printf("Total Sales: %d pesos\n", totalSales);
                    }
                    case 3 ->
                        admin = exitAdmin();
                    default -> {
                        choice = 0;
                        System.out.println("Invalid choice!");
                    }
                }
            }
            System.out.println("");
        }
        input.close();
    }

    public static boolean loginAdmin(Scanner input) {
        String password;
        System.out.print("Enter admin password: ");
        input.nextLine();
        password = input.nextLine();
        if (password.equals("admin123")) {
            return true;
        } else {
            System.out.println("Wrong password!");
            return false;
        }
    }

    public static int restockItem(Scanner input, String itemName) {
        int amount;
        while (true) {
            System.out.printf("Enter stock for %s: ", itemName);
            amount = input.nextInt();
            if (amount >= 0) {
                return amount;
            } else {
                System.out.println("Amount must be above zero!");
            }
        }
    }

    public static void viewSalesReport(String itemName, int sales) {
        System.out.printf("%s sold: %d\n", itemName, sales);
    }

    public static boolean exitAdmin() {
        System.out.println("Exiting admin mode...");
        return false;
    }

    public static int insertCoin(Scanner input) {
        int amount = 0;
        int onePeso = 0, fivePeso = 0, tenPeso = 0, twentyPeso = 0;
        int balance = 0;
        while (amount != -1) {
            System.out.print("Enter amount (1, 5, 10, 20) or -1 to stop: ");
            amount = input.nextInt();
            switch (amount) {
                case -1 ->
                    System.out.printf("1 peso: %dx\n5 peso: %dx\n10 peso: %dx\n20 peso: %dx\nTotal: %d pesos\n", onePeso, fivePeso, tenPeso, twentyPeso, balance);
                case 1 ->
                    onePeso++;
                case 5 ->
                    fivePeso++;
                case 10 ->
                    tenPeso++;
                case 20 ->
                    twentyPeso++;
                default ->
                    System.out.println("Invalid amount!\n");
            }
            if (amount == 1 || amount == 5 || amount == 10 || amount == 20) {
                balance += amount;
            }
        }
        return balance;
    }

    public static int withdrawMoney(int balance) {
        int twentyPeso = balance / 20;
        balance -= 20 * twentyPeso;
        int tenPeso = balance / 10;
        balance -= 10 * tenPeso;
        int fivePeso = balance / 5;
        balance -= 5 * fivePeso;
        int onePeso = balance / 1;
        balance -= 1 * onePeso;
        if (twentyPeso != 0) {
            System.out.printf("Returning 20 pesos as change:\n20p x %d\n", twentyPeso);
        }
        if (tenPeso != 0) {
            System.out.printf("Returning 10 pesos as change:\n10p x %d\n", tenPeso);
        }
        if (fivePeso != 0) {
            System.out.printf("Returning 5 pesos as change:\n5p x %d\n", fivePeso);
        }
        if (onePeso != 0) {
            System.out.printf("Returning 1 pesos as change:\n1p x %d\n", onePeso);
        }
        System.out.println("Successfully withdrawn money. Balance is now 0.");
        return balance;
    }

    public static int selectItem(int balance, int choice) {
        int price = 0;
        String itemName = "";
        switch (choice) {
            case 1 -> {
                itemName = "coke";
                price = cokePrice;
            }
            case 2 -> {
                itemName = "water";
                price = waterPrice;
            }
            case 3 -> {
                itemName = "chips";
                price = chipsPrice;
            }
            case 4 -> {
                itemName = "candy";
                price = candyPrice;
            }
        }
        boolean stockAmount = checkStock(choice);
        if (stockAmount && balance >= price) {
            System.out.printf("Successfully bought %s (%d pesos).\n", itemName, price);
            releaseItem(choice);
            totalSales += price;
            balance -= price;
            System.out.printf("User bought %s for %d pesos. Change returned: %d pesos.", itemName, price, balance);
        } else if (!stockAmount) {
            System.out.printf("%s is out of stock!\n", itemName);
        } else {
            System.out.printf("Not enough money to buy %s!\n", itemName);
        }
        return balance;
    }

    public static boolean checkStock(int choice) {
        int stock = 0;
        switch (choice) {
            case 1 ->
                stock = cokeStock;
            case 2 ->
                stock = waterStock;
            case 3 ->
                stock = chipsStock;
            case 4 ->
                stock = candyStock;
        }
        return stock != 0;
    }

    public static void releaseItem(int choice) {
        int stock = 0;
        switch (choice) {
            case 1 -> {
                stock = --cokeStock;
                cokeSold++;
            }
            case 2 -> {
                stock = --waterStock;
                waterSold++;
            }
            case 3 -> {
                stock = --chipsStock;
                chipsSold++;
            }
            case 4 -> {
                stock = --candyStock;
                candySold++;
            }
        }

        if (stock <= 2) {
            System.out.println("Warning! This item is running low!");
        }
    }
}
