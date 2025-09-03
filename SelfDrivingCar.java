
public class SelfDrivingCar 
{   
    public static void main(String args[]){
        boolean isRaining = true;
        boolean trafficGreen = false;
        boolean trafficYellow = true;
        
        rainChecker(isRaining);
        stopLight(trafficGreen, trafficLightYellow);
        cinemaTicket();
    }



    public static void stopLight(boolean isGreen, boolean isLightYellow){
        if(trafficGreen == true)
        {
            System.out.println("Now driving.");
        } else if(trafficYellow == true)
        {
            System.out.println("Preparing to stop.");
        } else {
            System.out.println("Stopped.");
        }
    }
    
    public static void rainChecker(boolean isRaining){
        if(isRaining == true)
        {
            System.out.println("Windshield wiper on.");
        }
    }
    
    public static void cinemaTicket(){
        int price =  350;
        int age = 14;
        boolean isStudent = false;

        if(isStudent){
            price -= price * 0.10;
            System.out.println("Final ticket price is " + price + " PHP.");
        } 
        else if(age <= 15 || age >= 60){
            price -= price * 0.10;
            System.out.println("Final ticket price is " + price +" PHP.");
        }
    }
}
