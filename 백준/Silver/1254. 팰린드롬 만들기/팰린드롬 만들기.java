import java.io.*;
import java.util.*;

public class Main {
    static boolean solve(String str){
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();

        for(int i=0; i<len; i++){
            String tmp = str.substring(i,len);
            if(solve(tmp)){
                System.out.println(tmp.length()+i*2);
                break;
            }
        }
    }
}
