import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];

        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);

        int left = 0;
        int right = 1;

        int result = Integer.MAX_VALUE;

        while(right<n){
            int diff = array[right] - array[left];
            if(diff==m){
                result = diff;
                break;
            }
            if(diff>=m){
                result = Math.min(result,diff);
                left++;
            }
            else{
                right++;
            }
        }
        System.out.println(result);
    }
}