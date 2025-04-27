import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String,List<String>> map = new HashMap<>();

        for(int i=0; i<n; i++){
            String group = br.readLine();
            int num = Integer.parseInt(br.readLine());
            List<String> arrayList = new ArrayList<>();
            for(int j=0; j<num; j++){
                arrayList.add(br.readLine());
            }
            Collections.sort(arrayList);
            map.put(group,arrayList);
        }

        for(int i=0; i<m; i++){
            String question = br.readLine();
            int num = Integer.parseInt(br.readLine());

            if(num==1){
                for(String groupName : map.keySet()){
                    List<String> list = map.get(groupName);

                    if(list.contains(question)){
                        sb.append(groupName).append("\n");
                    }
                }
            }
            else if(num==0){
                List<String> list = map.get(question);
                for(String memberName : list){
                    sb.append(memberName).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
