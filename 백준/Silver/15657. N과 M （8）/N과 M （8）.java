import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] tmp;
    static int[] array;
    static StringBuilder sb = new StringBuilder();
    static void backTracking(int start,int num){
        if(num==m){
            for(int i=0; i<m; i++){
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<n; i++){
            tmp[num] = array[i];
            backTracking(i,num+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];
        tmp = new int[m];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        backTracking(0,0);
        System.out.println(sb);

    }
}
