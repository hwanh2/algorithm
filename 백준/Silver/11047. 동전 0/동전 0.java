import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        for(int i=n-1; i>=0; i--){
            count+=k/array[i];
            k%=array[i];
        }
        bw.write(count+"\n");
        bw.close();
    }
}