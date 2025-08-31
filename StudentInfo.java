import java.util.Scanner;

public class StudentInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for input
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your year of birth: ");
        int yearOfBirth = scanner.nextInt();
        scanner.nextLine(); // consume newline left by nextInt()

        System.out.print("Enter your favorite hobby: ");
        String hobby = scanner.nextLine();

        // Self-introduction message
        String introduction = "Hello! My name is " + firstName + " " + lastName +
                ". I am " + age + " years old, born in " + yearOfBirth +
                ". My favorite hobby is " + hobby + ".";
        
        System.out.println(introduction);

        // Arithmetic operation
        int futureAge = age + 10;
        System.out.println("In 10 years, I will be " + futureAge + " years old.");

        scanner.close();
    }
}
