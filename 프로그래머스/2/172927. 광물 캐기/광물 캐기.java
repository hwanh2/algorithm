import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = 0;
        for(int i=0; i<picks.length; i++){
            totalPicks+=picks[i];
        }
        int len = Math.min(minerals.length,totalPicks*5);
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0; i<len; i+=5){
            int dia = 0;
            int iron = 0;
            int stone = 0;
            for(int j=i; j<Math.min(i+5,len); j++){
                if(minerals[j].equals("diamond")){
                    dia++;
                }
                else if(minerals[j].equals("iron")){
                    iron++;
                }
                else{
                    stone++;
                }
            }
            
            List<Integer> chunk = new ArrayList<>();
            chunk.add(dia);
            chunk.add(iron);
            chunk.add(stone);

            list.add(chunk);
        }
        
        Collections.sort(list,(o1,o2)->{
            if(!o1.get(0).equals(o2.get(0))){
                return o2.get(0) - o1.get(0);
            }
            if(!o1.get(1).equals(o2.get(1))){
                return o2.get(1) - o1.get(1);
            }
            return o2.get(2) - o1.get(2);
        });
        
        for(List<Integer> chunk : list){
            int d = chunk.get(0);
            int i = chunk.get(1);
            int s = chunk.get(2);
            
            if(picks[0]>0){
                answer+=d+i+s;
                picks[0]--;
            }
            else if(picks[1]>0){
                answer+=d*5+i+s;
                picks[1]--;
            }
            else if(picks[2]>0){
                answer+=d*25+i*5+s;
                picks[2]--;
            }
        }
        return answer;
    }
}