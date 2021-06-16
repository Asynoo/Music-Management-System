package sample.gui.models;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    private static Clip audioClip;
    private static AudioInputStream audioStream;
    private static long clipTimePosition;
    private static String path;


    public static void play(String path) {
        String audioFilePath = path;
        File audioFile = new File(audioFilePath);

        try {
            audioStream = AudioSystem.getAudioInputStream(audioFile);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        try {
            audioClip = (Clip) AudioSystem.getLine(info);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            audioClip.open(audioStream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       audioClip.start();
    }

    public static void stopSong(){
        clipTimePosition = audioClip.getMicrosecondPosition();
        audioClip.stop();
    }

    public static void resume(String path){
       if(clipTimePosition>0) {
           audioClip.setMicrosecondPosition(clipTimePosition);
            audioClip.start();
       }
        else{
            play(path);
       }
    }
}
