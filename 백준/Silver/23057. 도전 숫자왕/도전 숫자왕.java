import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] array;
    static Set<Integer> set = new HashSet<>();
    static void backTracking(int depth,int sum){
        if(depth == n){
            set.add(sum);
            return;
        }
        backTracking(depth+1,sum);
        backTracking(depth+1,sum+array[depth]);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        array = new int[n];

        int m = 0;

        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
            m+=array[i];
        }

        backTracking(0,0);

        System.out.println(m-set.size()+1);

    }
}
