import java.util.Scanner; // Import Scanner class for user input

public class TravelEstimator {
    public static void main(String[] args) {
        Scanner travel = new Scanner(System.in); // Create Scanner object

        System.out.print("Distance (km): "); // Prompt for distance
        double distance = travel.nextDouble(); // Read distance input

        System.out.print("Speed (km/h): "); // Prompt for speed
        double speed = travel.nextDouble(); // Read speed input

        double hours = calculateTime(distance, speed); // Calculate travel time
        printTravelDetails(distance, speed, hours); // Display travel details
    }

    public static double calculateTime(double distance, double speed) {
        return distance / speed; // Return time = distance / speed
    }

    public static double convertHourstoMinutes(double hours) {
        return hours * 60; // Convert hours to minutes
    }

    public static void printTravelDetails(double distance, double speed, double hours) {
        System.out.println("Distance: " + distance + " km"); // Display distance
        System.out.println("Speed: " + speed + " km/h"); // Display speed
        System.out.println("Estimated travel time: " + hours + " hours (" + convertHourstoMinutes(hours) + " minutes)"); // Display time in hours and minutes
    }
}
