import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            map.put(st.nextToken(),i+1);
        }

        st = new StringTokenizer(br.readLine()," ");
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            answer[i] = st.nextToken();
        }

        int count = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                String str1 = answer[i];
                String str2 = answer[j];
                if(map.get(str1)<map.get(str2)){
                    count++;
                }
            }
        }

        System.out.println(count+"/"+n*(n-1)/2);

    }
}