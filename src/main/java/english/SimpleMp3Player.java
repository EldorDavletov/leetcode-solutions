package english;

import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.BufferedInputStream;

public class SimpleMp3Player {
    public static void main(String[] args) {
        String mp3FilePath = "D:\\MyProjects\\LeetCodeSolutions\\test_audio.mp3"; // MP3 faylingizning yo'lini kiriting

        try {
            FileInputStream fis = new FileInputStream(mp3FilePath);
            BufferedInputStream bis = new BufferedInputStream(fis);
            Player player = new Player(bis);

            System.out.println("MP3 fayli o'qilmoqda...");
            player.play(); // O'qitishni boshlaydi
            System.out.println("MP3 fayli o'qildi!");

        } catch (Exception e) {
            System.err.println("MP3 faylini o'qishda xato yuz berdi:");
            e.printStackTrace();
        }
    }
}

