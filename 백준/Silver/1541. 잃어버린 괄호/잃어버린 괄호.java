import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sum = 0;

        StringTokenizer st1 = new StringTokenizer(str,"-");
        StringTokenizer st2 = new StringTokenizer(st1.nextToken(),"+");
        while(st2.hasMoreTokens()){
            sum+=Integer.parseInt(st2.nextToken());
        }

        while(st1.hasMoreTokens()){
            st2 = new StringTokenizer(st1.nextToken(),"+");
            while(st2.hasMoreTokens()){
                sum-=Integer.parseInt(st2.nextToken());
            }
        }

        System.out.println(sum);

    }
}

