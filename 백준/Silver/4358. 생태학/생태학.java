import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String,Integer> map = new HashMap<>();
        int count = 0;
        while(true){
            String str = br.readLine();
            if(str==null || str.isEmpty()){
                break;
            }
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }
            else{
                map.put(str,1);
            }
            count++;
        }
        ArrayList<String> array = new ArrayList<>(map.keySet());
        Collections.sort(array);
        for(String tmp : array){
            bw.write(String.format("%s %.4f\n",tmp,(double)map.get(tmp)/count*100));
        }
        bw.flush();

    }
}