package english;

import com.google.cloud.texttospeech.v1.*;
import com.google.protobuf.ByteString;
import javazoom.jl.player.Player;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TextToSpeechConverter {

    public void textToSpeech(String text) {
        try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
            SynthesisInput input = SynthesisInput.newBuilder().setText(text).build();
            VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
                    .setLanguageCode("en-US")
                    .setSsmlGender(SsmlVoiceGender.NEUTRAL)
                    .build();
            AudioConfig audioConfig = AudioConfig.newBuilder()
                    .setAudioEncoding(AudioEncoding.MP3) // Ovozni o'ynash uchun formatni o'zgartiramiz
                    .build();
            SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);
            ByteString audioContents = response.getAudioContent();
            // Endi ovozni faylga yozish o'rniga, uni to'g'ridan-to'g'ri o'ynaymiz
            playAudio(audioContents.toByteArray());
            Thread.sleep(1500);
            playAudio(audioContents.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void textToSpeech(String text, String outputFileName) {
        try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
            SynthesisInput input = SynthesisInput.newBuilder().setText(text).build();
            VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
                    .setLanguageCode("en-US")
                    .setSsmlGender(SsmlVoiceGender.NEUTRAL)
                    .build();
            AudioConfig audioConfig = AudioConfig.newBuilder()
                    .setAudioEncoding(AudioEncoding.MP3)
                    .build();
            SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);
            ByteString audioContents = response.getAudioContent();
            try (OutputStream out = new FileOutputStream(outputFileName)) {
                out.write(audioContents.toByteArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void playAudio(byte[] audio) {
        try {
            // Audio ma'lumotlarini vaqtincha faylga yozish uchun test qilish
//            FileOutputStream fos = new FileOutputStream("test_audio.mp3");
//            fos.write(audio);
//            fos.close();

            // Audio ma'lumotlarini InputStream'ga aylantiramiz
            InputStream is = new ByteArrayInputStream(audio);
            // JLayer Player yaratamiz va uni boshlatamiz
            Player player = new Player(is);
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

