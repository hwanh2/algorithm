import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<BigInteger> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            String str = br.readLine();
            String tmp = "";
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(Character.isDigit(c)){
                    tmp+=c;
                }
                else{
                    if (!tmp.isEmpty()) {
                        list.add(new BigInteger(tmp));
                        tmp = "";
                    }
                }
            }
            if (!tmp.isEmpty()) {
                list.add(new BigInteger(tmp));
            }
        }
        Collections.sort(list);
        for(BigInteger num : list){
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}
