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
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(array);
        
        int count=0, left=0, right=n-1;
        
        while(left<right){
            int sum = array[left] + array[right];
            if(sum>x){
                right--;
            }
            else if(sum==x){
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