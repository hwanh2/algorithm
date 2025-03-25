import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] setArray = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(count>=array[i] && setArray[j]==0){
                    setArray[j] = i+1;
                    break;
                }
                if(setArray[j]==0){
                    count++;
                }
            }
        }
        for(int i=0; i<n; i++){
            sb.append(setArray[i]+" ");
        }
        sb.append("\n");
        System.out.println(sb);
    }
}
