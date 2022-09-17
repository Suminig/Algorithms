import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0);map.put('T', 0);map.put('C', 0);map.put('F', 0);
        map.put('J', 0);map.put('M', 0);map.put('A', 0);map.put('N', 0);
        
        for (int i = 0, size = survey.length; i < size; i++){
            int score = choices[i] - 4;
            char front = survey[i].charAt(0);
            char back = survey[i].charAt(1);
            
            if(score == 0)
                continue;
            else{
                if(score < 0)
                    map.put(front, map.get(front) + score * -1);
                else
                    map.put(back, map.get(back) + score);
            }
        }
        
        if(map.get('R') == map.get('T'))
            sb.append('R');
        else
            sb.append(map.get('R') > map.get('T') ? 'R' : 'T');
        
        if(map.get('C') == map.get('F'))
            sb.append('C');
        else
            sb.append(map.get('C') > map.get('F') ? 'C' : 'F');
        
        if(map.get('J') == map.get('M'))
            sb.append('J');
        else
            sb.append(map.get('J') > map.get('M') ? 'J' : 'M');
        
        if(map.get('A') == map.get('N'))
            sb.append('A');
        else
            sb.append(map.get('A') > map.get('N') ? 'A' : 'N');
        
        System.out.println(map);
        return sb.toString();
    }
}