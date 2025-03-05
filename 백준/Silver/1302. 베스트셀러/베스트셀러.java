import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String,Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String str = br.readLine();
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }
            else{
                map.put(str,1);
            }
        }
        int max = 0;
        String result = null;
        for(String key:map.keySet()){
            if(max<map.get(key)){
                max = map.get(key);
                result = key;
            }
            else if(max == map.get(key)){
                if(key.compareTo(result)<0){
                    result = key;
                }
            }
        }
        bw.write(result+"\n");
        bw.flush();
    }
}
