import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] prime = new int[m+1];
        prime[1] = 1;
        for(int i=2; i*i<=m; i++){
            if(prime[i]==0){
                for(int j=i*i; j<=m; j+=i){
                    prime[j] = 1;
                }
            }
        }
        for(int i=n; i<=m; i++){
            if(prime[i]==0){
                bw.write(i+"\n");
            }
        }
        bw.flush();
    }
}
