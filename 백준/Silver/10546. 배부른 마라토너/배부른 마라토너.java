import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String str = br.readLine();
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(int i=0; i<n-1; i++){
            String str = br.readLine();
            if(map.get(str)==1){
                map.remove(str);
            }
            else{
                map.put(str,map.get(str)-1);
            }
        }
        for(String tmp : map.keySet()){
            sb.append(tmp+"\n");
        }
        System.out.println(sb);
    }
}