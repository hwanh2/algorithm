import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int maxIndex;
    static int[] array;
    static int[] maxDp;
    static int[] minDp;
    static void solveMaxDp(){
        maxDp[0] = 1;
        for(int i=1; i<n; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(array[i]>array[j]){
                    max = Math.max(max,maxDp[j]);
                }
            }
            maxDp[i] = max+1;
        }
    }
    static void solveMinDp(){
        minDp[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            int max = 0;
            for(int j=n-1; j>i; j--){
                if(array[i]>array[j]){
                    max = Math.max(max,minDp[j]);
                }
            }
            minDp[i] = max+1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n];
        maxDp = new int[n];
        minDp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        solveMaxDp();
        solveMinDp();

        int result = 0;
        for(int i=0; i<n; i++){
            result = Math.max(maxDp[i]+minDp[i]-1,result);
        }
        System.out.println(result);




    }
}