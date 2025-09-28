import java.util.Scanner;

public class VendingMachine {

    static int stockCoke = 5, stockWater = 5, stockChips = 3, stockCandy = 10;
    static int priceCoke = 25, priceWater = 15, priceChips = 30, priceCandy = 10;

    static int soldCoke = 0, soldWater = 0, soldChips = 0, soldCandy = 0;
    static int totalRevenue = 0;

    public static void main(String[] args) {
        int option = 0;
        int userBalance = 0;

        Scanner sc = new Scanner(System.in);
        while (option != 7) {
            System.out.printf("""
                              --- Vending Machine Menu ---
                              1. Coke - %d pesos (Stock: %d)
                              2. Water - %d pesos (Stock: %d)
                              3. Chips - %d pesos (Stock: %d)
                              4. Candy - %d pesos (Stock: %d)
                              5. Insert Coins
                              6. Withdraw Money
                              7. Exit

                              Current Balance: %d pesos

                              Please enter your option: 
                              """, priceCoke, stockCoke, priceWater, stockWater,
                    priceChips, stockChips, priceCandy, stockCandy, userBalance);

            option = sc.nextInt();

            switch (option) {
                case 1, 2, 3, 4 ->
                    userBalance = buyItem(userBalance, option);
                case 5 ->
                    userBalance += insertCoins(sc);
                case 6 ->
                    userBalance = returnCoins(userBalance);
                case 7 ->
                    System.out.println("Exiting program. Thank you for using the vending machine!");
                default ->
                    System.out.println("Invalid option!");
            }
            System.out.println();
        }
        sc.close();
    }

    public static int insertCoins(Scanner sc) {
        int coin = 0;
        int count1 = 0, count5 = 0, count10 = 0, count20 = 0;
        int balanceInserted = 0;

        while (coin != -1) {
            System.out.print("Insert coin (1, 5, 10, 20) or -1 to stop: ");
            coin = sc.nextInt();
            switch (coin) {
                case -1 ->
                    System.out.printf("Coins inserted:\n1 peso: %dx\n5 peso: %dx\n10 peso: %dx\n20 peso: %dx\nTotal: %d pesos\n",
                            count1, count5, count10, count20, balanceInserted);
                case 1 -> count1++;
                case 5 -> count5++;
                case 10 -> count10++;
                case 20 -> count20++;
                default -> System.out.println("Invalid coin!\n");
            }
            if (coin == 1 || coin == 5 || coin == 10 || coin == 20) {
                balanceInserted += coin;
            }
        }
        return balanceInserted;
    }

    public static int returnCoins(int balance) {
        if (balance == 0) {
            System.out.println("No coins to withdraw.");
            return 0;
        }

        int twenties = balance / 20;
        balance %= 20;
        int tens = balance / 10;
        balance %= 10;
        int fives = balance / 5;
        balance %= 5;
        int ones = balance;

        if (twenties != 0) System.out.printf("20p x %d\n", twenties);
        if (tens != 0) System.out.printf("10p x %d\n", tens);
        if (fives != 0) System.out.printf("5p x %d\n", fives);
        if (ones != 0) System.out.printf("1p x %d\n", ones);

        System.out.println("Coins successfully returned. Balance reset to 0.");
        return 0;
    }

    public static int buyItem(int balance, int option) {
        int cost = 0;
        String product = "";

        switch (option) {
            case 1 -> { product = "Coke"; cost = priceCoke; }
            case 2 -> { product = "Water"; cost = priceWater; }
            case 3 -> { product = "Chips"; cost = priceChips; }
            case 4 -> { product = "Candy"; cost = priceCandy; }
        }

        boolean available = checkStock(option);
        if (available && balance >= cost) {
            System.out.printf("You bought %s for %d pesos.\n", product, cost);
            dispenseItem(option);
            totalRevenue += cost;
            balance -= cost;
            System.out.printf("Remaining balance: %d pesos\n", balance);
        } else if (!available) {
            System.out.printf("%s is out of stock!\n", product);
        } else {
            System.out.printf("Insufficient balance to buy %s!\n", product);
        }
        return balance;
    }

    public static boolean checkStock(int option) {
        return switch (option) {
            case 1 -> stockCoke > 0;
            case 2 -> stockWater > 0;
            case 3 -> stockChips > 0;
            case 4 -> stockCandy > 0;
            default -> false;
        };
    }

    public static void dispenseItem(int option) {
        switch (option) {
            case 1 -> { stockCoke--; soldCoke++; }
            case 2 -> { stockWater--; soldWater++; }
            case 3 -> { stockChips--; soldChips++; }
            case 4 -> { stockCandy--; soldCandy++; }
        }

        if ((option == 1 && stockCoke <= 2) ||
            (option == 2 && stockWater <= 2) ||
            (option == 3 && stockChips <= 2) ||
            (option == 4 && stockCandy <= 2)) {
            System.out.println("⚠ Warning: This item is running low!");
        }
    }
}
