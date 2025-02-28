import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer> array;
    static void solve(int n){
        int count = 0;
        array.sort(Collections.reverseOrder());
        while(n <= array.get(0)){
            n++;
            array.set(0, array.get(0) - 1);
            array.sort(Collections.reverseOrder());
            count++;
        }
        System.out.println(count);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println(0);
            return;
        }
        int dasom = Integer.parseInt(br.readLine());
        array = new ArrayList<>();
        for(int i = 0; i < n - 1; i++){
            array.add(Integer.parseInt(br.readLine()));
        }
        solve(dasom);
    }
}
