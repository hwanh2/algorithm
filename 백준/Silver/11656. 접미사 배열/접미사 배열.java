import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String[] tmp = new String[str.length()];
        for(int i=0; i<str.length(); i++){
            tmp[i] = str.substring(i,str.length());
        }
        Arrays.sort(tmp);
        for(int i=0; i<tmp.length; i++){
            bw.write(tmp[i]+"\n");
        }
        bw.flush();
    }
}
