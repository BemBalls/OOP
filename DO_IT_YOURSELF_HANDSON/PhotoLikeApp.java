public class PhotoLikeApp {
    public static void main(String[] args) {
        int beachLikes = 0;
        int mountainLikes = 0;

        String user1 = "James";
        String user2 = "Cameron";
        String user3 = "Abello";

        beachLikes = likePhoto(user1, "Beach.jpg", beachLikes, "So cool beach!", true);
        beachLikes = likePhoto(user2, "Beach.jpg", beachLikes, "Wow!", true);
        beachLikes = likePhoto(user3, "Beach.jpg", beachLikes, "It sucks.", false);

        mountainLikes = likePhoto(user1, "Mountain.jpg", mountainLikes, "Very high Mountain!", true);
        mountainLikes = likePhoto(user2, "Mountain.jpg", mountainLikes, "Its very nice", true);
        mountainLikes = likePhoto(user3, "Mountain.jpg", mountainLikes, "Its so cool!", true);

        System.out.println("Final Likes:");
        System.out.println("Beach.jpg = " + beachLikes);
        System.out.println("Mountain.jpg = " + mountainLikes);
    }
    public static int likePhoto(String user, String photo, int currentLikes, String comment, boolean like){    
        int updatedLikes = currentLikes + (like ? 1 : 0);

        System.out.println("User: " + user);
        System.out.println("Photo: " + photo);
        System.out.println("Feedback = " + comment);
        System.out.println("Number of likes = " + updatedLikes);
        System.out.println();

        return updatedLikes;

    }
}
