import java.io.*;
import java.util.*;

public class Main {
    static int[] array;
    static int count = 0;
    static int n,s;
    static void backTracking(int start,int depth,int sum){
        if(sum==s && depth>0){
            count++;
        }
        for(int i=start; i<n; i++){
            backTracking(i+1,depth+1,sum+array[i]);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");

        array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        backTracking(0,0,0);

        System.out.println(count);

    }
}
