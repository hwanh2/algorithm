import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static void partition(int size, boolean blank){
        if(size==1 && blank==false){
            sb.append("-");
            return;
        }
        if(blank==true){
            for(int i=0; i<size; i++){
                sb.append(" ");
            }
            return;
        }
        size/=3;
        partition(size,false);
        partition(size,true);
        partition(size,false);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str = br.readLine();
            if(str==null || str.length()==0){
                break;
            }
            int n = (int)Math.pow(3,Integer.parseInt(str));


            partition(n,false);
            sb.append("\n");
        }
        System.out.println(sb);

    }
}