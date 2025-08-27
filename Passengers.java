public class Passengers {
    public static void main(String[] args) {
        int passengers;
        passengers = 0;
        passengers = passengers + 5;
        passengers = passengers - 3;
        passengers = (passengers - 1) + 5;
        passengers = passengers + 5;

        int stops;
        int fare;
        stops = 0;
        fare = 0;
        stops = stops + 1;
        fare = fare + 5;
        stops = stops + 1;
        fare = fare + 3;
        stops = stops + 1;
        fare = fare + 7;

        String driverFirstName = "Lito";
        String driverLastName = "Barber";
        String fullName = driverFirstName+ " " + driverLastName;
        int letters = fullName.length();

        System.out.println("The bus made P" + fare + " after " + stops + " stops");
        System.out.println("Driver Name is " + fullName);
        System.out.println("Number of stops: " + stops);
        System.out.println("Number of passengers: " + passengers);
    }
}
