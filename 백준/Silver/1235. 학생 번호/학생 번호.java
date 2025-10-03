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

        int len = list.get(0).length();
        int count = 0;

        for(int i=1; i<=len; i++){
            List<String> tmp = new ArrayList<>();
            int flag = 0;
            for(int j=0; j<n; j++){
                String str = list.get(j).substring(len-i,len);
                if(tmp.contains(str)){
                    flag = 1;
                    break;
                }
                else{
                    tmp.add(str);
                }
            }
            if(flag==0){
                count = i;
                break;
            }
        }
        System.out.println(count);
    }
}
