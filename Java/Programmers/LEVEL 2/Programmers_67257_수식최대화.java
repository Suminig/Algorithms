import java.util.ArrayList;

class Solution {
    private long maxNum = 0;
    private String[][] priorities = {{"+","-","*"}, {"+","*","-"}, {"-","+","*"}, {"-","*","+"}, {"*","-","+"}, {"*","+","-"}};             
    
    public long solution(String expression) {
        for(int i = 0; i < 6; i++){
            StringBuilder sb = new StringBuilder();
            ArrayList<Long> numList = new ArrayList<>();
            ArrayList<String> operList = new ArrayList<>();
            
            for(int j = 0, size = expression.length(); j < size; j++){
                if(expression.charAt(j) == '+' || expression.charAt(j) == '-' || expression.charAt(j) == '*'){
                    numList.add(Long.parseLong(sb.toString()));
                    sb = new StringBuilder();
                    operList.add(String.valueOf(expression.charAt(j)));
                }else{
                    sb.append(expression.charAt(j));
                }
                
                if(!sb.toString().equals(""))
                    numList.add(Long.parseLong(sb.toString()));
                    
                for(int k = 0; k < 3; k++){
                    String priority = priorities[i][k];
                    
                    while(!operList.isEmpty()){
                        int index = operList.indexOf(priority);
                        
                        if(index == -1) break;
                        else{
                            if(priority.equals("+"))
                                numList.add(index, numList.get(index)+numList.get(index+1));
                            else if(priority.equals("+"))
                                numList.add(index, numList.get(index)-numList.get(index+1));
                            else
                                numList.add(index, numList.get(index)*numList.get(index+1));
                            
                            numList.remove(index+1);
                            numList.remove(index+1);
                            operList.remove(index);
                        }
                    }   
                }
                maxNum = Math.max(maxNum, Math.abs(numList.get(0)));
            }
        }
        return maxNum;
    }
}