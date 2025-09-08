import java.util.Scanner;

public class CollegeApplication {

    public static void main(String args[]){	
        double studentGrade = 0;
        int admissionGrade = 0;
        boolean isPassing = true;

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your Grade: ");
        studentGrade = scanner.nextDouble();
        
        System.out.print("Enter your Admission Grade: ");
        admissionGrade = scanner.nextInt();
        
        scanner.close();
        
        gradeCondition(studentGrade, admissionGrade, isPassing);
    }

    public static void gradeCondition(double studentGrade, int admissionGrade, boolean isPassing){
        String status = "";
        
        if (studentGrade <= 3.0) {
            if (admissionGrade >= 60) {
                status = "Accepted";
            } else {
                status = "Rejected";
            }
        } 
        else {
            if (admissionGrade >= 80) {
                status = "Accepted";
            } else {
                status = "Rejected";
            }
        }
        
        System.out.print("\nCollege Application Status: " + status);
    }
}
