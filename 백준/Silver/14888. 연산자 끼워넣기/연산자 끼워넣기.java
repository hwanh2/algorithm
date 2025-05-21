import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] num;
    static int[] operations;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static void backTracking(int depth,int result){
        if(depth==n){
            max = Math.max(max,result);
            min = Math.min(min,result);
            return;
        }
        for(int i=0; i<4; i++){
            if(operations[i]!=0){
                operations[i]--;
                switch (i){
                    case 0:
                        backTracking(depth+1,result+num[depth]);
                        break;
                    case 1:
                        backTracking(depth+1,result-num[depth]);
                        break;
                    case 2:
                        backTracking(depth+1,result*num[depth]);
                        break;
                    case 3:
                        backTracking(depth+1,result/num[depth]);
                        break;
                }
                operations[i]++;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        operations = new int[4];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<4; i++){
            operations[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(1,num[0]);

        System.out.println(max+"\n"+min);


    }
}
