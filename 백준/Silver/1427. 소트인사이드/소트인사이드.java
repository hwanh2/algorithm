import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        char[] array = new char[str.length()];
        for(int i=0; i<str.length(); i++){
            array[i] = str.charAt(i);
        }
        Arrays.sort(array);
        for(int i=str.length()-1; i>=0; i--){
            bw.write(array[i]);
        }
        bw.flush();
    }
}
