public class PhotoLikeApp {
    public static void main(String[] args) {
        int gameLikes = 0;
        int rugbyLikes = 0;

        String user1 = "James";
        String user2 = "Cameron";
        String user3 = "Abello";

        gameLikes = likePhoto(user1, "Gameplay.jpg", gameLikes, "Such nice gameplay!", true);
        gameLikes = likePhoto(user2, "Gameplay.jpg", gameLikes, "So cooo!", true);
        gameLikes = likePhoto(user3, "Gameplay.jpg", gameLikes, "you suck!!!", false);

        rugbyLikes = likePhoto(user1, "Rugby.jpg", rugbyLikes, "Theyre so strong.", true);
        rugbyLikes = likePhoto(user2, "Rugby.jpg", rugbyLikes, "Wow what a try!", true);
        rugbyLikes = likePhoto(user3, "Rugby.jpg", rugbyLikes, "Very cool", true);

        System.out.println("Final Likes:");
        System.out.println("Gameplay.jpg = " + gameLikes);
        System.out.println("Rugby.jpg = " + rugbyLikes);
    }
    public static int likePhoto(String user, String photo, int currentLikes, String comment, boolean like){    
        int updatedLikes = currentLikes + (like ? 1 : -1); //boolean arithmetic, its js like an if statement

        System.out.println("User: " + user);
        System.out.println("Photo: " + photo);
        System.out.println("Feedback = " + comment);
        System.out.println("Number of likes = " + updatedLikes);
        System.out.println();

        return updatedLikes;

    }
}
