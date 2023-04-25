package org.example;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LongestLineInFile {

    public static void main(String[] args) {
        String filename = "src/main/java/org/example/names.txt";
        List<String> lines = null;
        try {
            lines = Files.readAllLines( Paths.get( filename ) );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int maxLen = 0;
        String name = "";
        for (String line : lines) {
            if(line.length() > maxLen){
                maxLen = line.length();
                name = line;
            }
        }
        System.out.println(name);

        try {
            Clip clip = AudioSystem.getClip();
//            LineUnavailableException – if a clip object is not available due to resource restrictions
//            SecurityException – if a clip object is not available due to security restrictions
//            IllegalArgumentException – if the system does not support at least one clip instance through any installed mixer
            clip.open( AudioSystem.getAudioInputStream( new File("") ) );
//            open:
//            LineUnavailableException – if the line cannot be opened due to resource restrictions
//            IOException – if an I/O exception occurs during reading of the stream
//            IllegalArgumentException – if the stream's audio format is not fully specified or invalid
//            IllegalStateException – if the line is already open
//            SecurityException – if the line cannot be opened due to security restrictions
//            getAudioInputStream:
//            UnsupportedAudioFileException – if the File does not point to valid audio file data recognized by the system
//            IOException – if an I/O exception occurs
//            NullPointerException – if file is null
            clip.start();
            TimeUnit.MICROSECONDS.sleep( clip.getMicrosecondLength() + 50 );
//            sleep:
//            InterruptedException – if interrupted while sleeping
//            getMicrosecondLength:
            clip.close();
//            SecurityException – if the line cannot be closed due to security restrictions<
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
