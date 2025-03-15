import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        boolean flag = false;
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<str.length(); i++){
            if(flag == false && str.charAt(i)=='1'){
                count1++;
                flag = true;
            }
            else if(str.charAt(i)=='0'){
                flag = false;
            }
        }
        flag = false;
        for(int i=0; i<str.length(); i++){
            if(flag == false && str.charAt(i)=='0'){
                count2++;
                flag = true;
            }
            else if(str.charAt(i)=='1'){
                flag = false;
            }
        }
        bw.write(Math.min(count1,count2)+"\n");
        bw.flush();
    }
}
