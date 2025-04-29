import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    static void partition(int r,int c,int size){
        if(size==1){
            return;
        }
        if(r<size/2 && c<size/2){
            partition(r,c,size/2);
        }
        else if(r<size/2 && c>=size/2){
            count+=(size/2)*(size/2);
            partition(r,c-size/2,size/2);
        }
        else if(r>=size/2 && c<size/2){
            count+=(size/2)*(size/2)*2;
            partition(r-size/2,c,size/2);
        }
        else{
            count+=(size/2)*(size/2)*3;
            partition(r-size/2,c-size/2,size/2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        n = (int) Math.pow(2,n);
        partition(r,c,n);
        System.out.println(count);


    }
}
