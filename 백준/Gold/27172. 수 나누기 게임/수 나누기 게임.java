import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        int[] check = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
            check[array[i]] = i+1;
        }

        int[] result = new int[n];

        for(int i=0; i<n; i++){
            int current = array[i];
            for(int j=current*2; j<1000001; j+=current){
                if(check[j]!=0){
                    result[i]++;
                    result[check[j]-1]--;
                }
            }
        }

        for(int num : result){
            sb.append(num).append(" ");
        }

        System.out.println(sb);

    }
}