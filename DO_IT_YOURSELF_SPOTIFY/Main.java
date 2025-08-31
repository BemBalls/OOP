import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SpotifyPlayer player = new SpotifyPlayer();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter song name to play: ");
        String songName = scanner.nextLine();
        player.chooseSong(songName);

        player.play();

        System.out.print("Set volume (0-100): ");
        int volume = scanner.nextInt();
        player.volumeControl(volume);

        scanner.nextLine(); // consume leftover newline

        System.out.print("Type 'forward', 'back', 'pause', or 'stop': ");
        String action = scanner.nextLine();

        switch (action.toLowerCase()) {
            case "forward":
                player.forward();
                break;
            case "back":
                player.back();
                break;
            case "pause":
                player.pause();
                break;
            case "stop":
                player.stop();
                break;
            default:
                System.out.println("Unknown action.");
        }

        System.out.println("Currently playing: " + player.getCurrentSong());
        scanner.close();
    }
}