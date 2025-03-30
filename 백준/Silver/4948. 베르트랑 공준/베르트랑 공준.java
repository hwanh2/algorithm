import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                System.out.println(sb);
                break;
            }
            int[] prime = new int[n*2+1];
            prime[0] = prime[1] = 1;
            for(int i=2; i*i<=2*n; i++){
                if(prime[i]==0){
                    for(int j=i*i; j<=2*n; j+=i){
                        prime[j] = 1;
                    }
                }
            }
            int count = 0;
            for(int j=n+1; j<=2*n; j++){
                if(prime[j]==0){
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
    }
}

