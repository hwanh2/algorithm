import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        int left = 0;
        int right = n-1;
        int count = 0;
        while(left<right){
            if(array[left]+array[right]>m){
                right--;
            }
            else if(array[left]+array[right]==m){
                count++;
                left++;
            }
            else{
                left++;
            }
        }
        System.out.println(count);
    }
}
