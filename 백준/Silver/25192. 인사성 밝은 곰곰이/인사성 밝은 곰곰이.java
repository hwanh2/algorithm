import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            String str = br.readLine();
            if(str.equals("ENTER")){
                set.clear();
            }
            else{
                if(!set.contains(str)){
                    count++;
                    set.add(str);
                }
            }
        }
        System.out.println(count);
    }
}

