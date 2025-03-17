import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if(n%2==0){
            bw.write("CY"+"\n");
        }
        else{
            bw.write("SK"+"\n");
        }
        bw.flush();
    }
}