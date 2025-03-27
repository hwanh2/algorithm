import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String,String> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String key = st.nextToken();
            String value = st.nextToken();
            map.put(key,value);
        }
        ArrayList<String> array = new ArrayList<>();
        for(String key : map.keySet()){
            array.add(key);
        }
        Collections.sort(array,Collections.reverseOrder());
        for(String key : array){
            if(map.get(key).equals("enter")){
                sb.append(key+"\n");
            }
        }
        System.out.println(sb);
    }

}

