import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(),".");
            st.nextToken();
            String str = st.nextToken();
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }
            else{
                map.put(str,1);
            }
        }

        ArrayList<String> array = new ArrayList<>(map.keySet());
        Collections.sort(array);

        for(String str : array){
            sb.append(str+" "+map.get(str)+"\n");
        }
        System.out.println(sb);
    }
}


