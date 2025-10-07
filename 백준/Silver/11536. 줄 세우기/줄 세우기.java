import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            list.add(br.readLine());
        }

        List<String> tmp = new ArrayList<>(list);
        Collections.sort(tmp);

        boolean isIncrease = true;
        boolean isDecrease = true;
        for(int i=0; i<n; i++){
            if(!list.get(i).equals(tmp.get(i))){
                isIncrease = false;
                break;
            }
        }
        for(int i=n-1; i>=0; i--){
            if(!list.get(i).equals(tmp.get(n-i-1))){
                isDecrease = false;
                break;
            }
        }
        if(isIncrease){
            System.out.println("INCREASING");
        }
        else if(isDecrease){
            System.out.println("DECREASING");
        }
        else{
            System.out.println("NEITHER");
        }
    }
}
