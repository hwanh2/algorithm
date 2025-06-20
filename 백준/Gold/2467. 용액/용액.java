import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = n-1, startValue = 0, rightValue = 0;
        int min = Integer.MAX_VALUE;
        while(left<right){
            int sum = array[left]+array[right];
            if(min>Math.abs(sum)){
                startValue = array[left];
                rightValue = array[right];
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
        System.out.println(startValue+" "+rightValue);
    }
}
