public class Karaoke {

    public static void main(String[] args) {
        chorus();
        playMusic(false);
        greeting("Cebu");
      }
    public static void chorus(){
        System.out.println("Diri na lang ko kutob,");
        System.out.println("Diri na lang ko taman");
        System.out.println("Dili na lang ko mogukod,");
        System.out.println("Sa taw'ng kusog modagan");
    } 

    public static void playMusic(boolean onMusic){
        if(onMusic){
            System.out.println("Music is playing");
        }else{
            System.out.println("Music is Paused");
        }
    }

    public static void greeting(String location){
        System.out.println("Hello, " + location);
    }
}

