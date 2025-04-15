import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            ArrayList<String> arrayList = new ArrayList<>();
            Set<String> set = new LinkedHashSet<>();
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            while(st.hasMoreTokens()){
                String str = st.nextToken();
                arrayList.add(str);
                set.add(str);
            }

            while(true){
                st = new StringTokenizer(br.readLine()," ");
                st.nextToken();
                if(st.nextToken().equals("goes")){
                    String str = st.nextToken();
                    set.remove(str);
                }
                else{
                    for(String tmp : arrayList){
                        if(set.contains(tmp)){
                            sb.append(tmp+" ");
                        }
                    }
                    break;
                }
            }
            System.out.println(sb);
        }
    }
}