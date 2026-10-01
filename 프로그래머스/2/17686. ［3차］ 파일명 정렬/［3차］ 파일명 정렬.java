import java.util.*;

class Solution {
    static class File{
        String file;
        String head;
        int number;
        
        public File(String file){
            this.file = file;
            int i=0;
            while(i<file.length() && !Character.isDigit(file.charAt(i))){
                i++;
            }
            this.head = file.substring(0,i).toLowerCase();
            
            int j=i;
            
            while (j<file.length() && Character.isDigit(file.charAt(j)) && j-i < 5) {
                j++;
            }
            
            this.number = Integer.parseInt(file.substring(i, j));
        }
    }
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        for(String file : files){
            list.add(new File(file));
        }
        
        list.sort(Comparator.comparing((File f) -> f.head)
            .thenComparingInt(f->f.number));
        
        String[] answer = new String[files.length];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).file;
        }
        
        return answer;
    }
}