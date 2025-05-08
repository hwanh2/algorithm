import java.io.*;
import java.util.*;

public class Main {
    static int l;
    static String check = "aeiou";
    static String[] tmp;
    static StringBuilder sb;
    static String[] array;
    static void backTracking(int depth,int start){
        if(depth==l){
            int count1 = 0;
            int count2 = 0;
            for(int i=0; i<tmp.length; i++){
                if(check.contains(tmp[i])){
                    count1++;
                }
                else{
                    count2++;
                }
            }
            if(count1>=1 && count2>=2){
                for(int i=0; i<tmp.length; i++){
                    sb.append(tmp[i]);
                }
                sb.append("\n");
            }
            return;
        }
        for(int i=start; i<array.length; i++){
            tmp[depth] = array[i];
            backTracking(depth+1,i+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        l = Integer.parseInt(st.nextToken()); // 깊이
        int c = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        tmp = new String[l];

        array = new String[c];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<c; i++){
            array[i] = st.nextToken();
        }

        Arrays.sort(array);

        backTracking(0,0);

        System.out.println(sb);

    }

}