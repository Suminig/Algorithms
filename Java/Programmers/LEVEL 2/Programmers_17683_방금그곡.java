import java.util.*;

class Solution {
    public String convert(String chords){
        String converted = chords;
        converted = converted.replaceAll("C#", "c");
        converted = converted.replaceAll("D#", "d");
        converted = converted.replaceAll("F#", "f");
        converted = converted.replaceAll("G#", "g");
        converted = converted.replaceAll("A#", "a");
        
        return converted;
    }
    
    public int getTime(String[] start, String[] end){
        int s = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        int e = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
        
        return e - s;
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxLength = 0;
        m = convert(m);
        
        for(String musicinfo : musicinfos){
            String[] music = musicinfo.split(",");
            int time = getTime(music[0].split(":"), music[1].split(":"));
            String title = music[2];
            String melody = convert(music[3]);
            
            if(time > melody.length())
                melody = String.join("", Collections.nCopies(time / melody.length() + 1, melody));
            else
                melody = melody.substring(0, time);
            
            if(melody.contains(m)){
                if(time > maxLength){
                    maxLength = time;
                    answer = title;
                }
            }
        }
        
        return answer.length() == 0 ? "(None)" : answer;
    }
}