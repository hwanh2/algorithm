import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        list.add(st.nextToken());
        list.add(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        list.add(st.nextToken());
        list.add(st.nextToken());

        Collections.sort(list);

        Set<String> set = new HashSet<>();

        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++){
                String str = list.get(i);
                str+=" "+list.get(j);
                if(!set.contains(str)){
                    set.add(str);
                    sb.append(str).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}