import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] array = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<n; i++){
            array[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(array);

        long min = Long.MAX_VALUE;
        long k = 0;
        long leftIndex = 0;
        long rightIndex = 0;

        for(int i=0; i<n; i++){
            long num = array[i];
            int left = i+1;
            int right = n-1;
            while(left<right){
                long sum = num+array[left]+array[right];
                if(min>Math.abs(sum)){
                    k = num;
                    leftIndex = array[left];
                    rightIndex = array[right];
                    min = Math.abs(sum);
                }
                if(sum<0){
                    left++;
                }
                else if(sum==0){
                    break;
                }
                else{
                    right--;
                }
            }
        }
        System.out.println(k+" "+leftIndex+" "+rightIndex);
    }
}