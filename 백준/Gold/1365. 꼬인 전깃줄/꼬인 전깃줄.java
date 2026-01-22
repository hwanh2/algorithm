import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] lis = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = array[0];
        int index = 0;

        for(int i=1; i<n; i++){
            if(lis[index]<array[i]){
                lis[++index] = array[i];
            }
            else{
                int left = 0;
                int right = index;

                while(left<right){
                    int mid = (left+right)/2;
                    if(lis[mid]<array[i]){
                        left = mid+1;
                    }
                    else{
                        right = mid;
                    }
                }
                lis[left] = array[i];
            }
        }
        System.out.println(n-(index+1));
    }
}