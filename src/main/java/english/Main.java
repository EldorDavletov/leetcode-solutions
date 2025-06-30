package english;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ExcelReader reader = new ExcelReader();
        List<String[]> wordPairs = reader.readExcelFile("C:\\Users\\ADMIN\\Desktop\\myTeacher\\words all.xlsx");

//        File directory = new File("output/");
//        if (!directory.exists()){
//            directory.mkdir(); // Papkani yaratadi agar u mavjud bo'lmasa
//        }

        TextToSpeechConverter converter = new TextToSpeechConverter();
        for (String[] wordPair : wordPairs) {
//            converter.textToSpeech(word, "output/" + word + ".mp3");
            if (wordPair.length == 2) {
                System.out.println(wordPair[0] + " - " + wordPair[1]);
                converter.textToSpeech(wordPair[0]);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}


