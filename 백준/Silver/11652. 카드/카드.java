import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Long,Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            long key = Long.parseLong(br.readLine());
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }
            else{
                map.put(key,1);
            }
        }
        int max = 0;
        long index = 0;
        for(Long key: map.keySet()){
            if(map.get(key)>max){
                max = map.get(key);
                index = key;
            }
            else if(max == map.get(key)){
                index = Math.min(index,key);
            }
        }
        bw.write(index+"\n");
        bw.flush();
    }
}
