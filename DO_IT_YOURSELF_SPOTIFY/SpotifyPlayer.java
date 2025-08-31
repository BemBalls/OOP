public class SpotifyPlayer {
    private String currentSong;

    void play() {
        System.out.println("Music is playing...");
    }

    void pause() {
        System.out.println("Music is paused.");
    }

    void stop() {
        System.out.println("Music stopped.");
    }

    void forward() {
        System.out.println("Music forwarded to next track.");
    }

    void back() {
        System.out.println("Music moved back to previous track.");
    }

    void chooseSong(String songName) {
        currentSong = songName;
        System.out.println("Now playing: " + songName);
    }

    String getCurrentSong() {
        return currentSong;
    }

    void volumeControl(int level) {
        System.out.println("Volume set to: " + level);
    }
}