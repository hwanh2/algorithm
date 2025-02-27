import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000-Integer.parseInt(br.readLine());
        int[] array = {500,100,50,10,5};
        int count = 0;
        for(int i=0; i<array.length; i++){
            count+=n/array[i];
            n%=array[i];
        }
        System.out.println(count+n);
    }
}
