import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while(n>=0){
            if(n%5==0){
                count+=n/5;
                bw.write(count+"\n");
                bw.close();
                return;
            }
            n-=2;
            count++;
        }
        bw.write(-1+"\n");
        bw.close();
    }
}