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
            map.put(group,arrayList);
        }

        for(int i=0; i<m; i++){
            String question = br.readLine();
            int num = Integer.parseInt(br.readLine());

            if(num==1){
                for(String groupName : map.keySet()){
                    List<String> list = map.get(groupName);

                    if(list.contains(question)){
                        sb.append(groupName+"\n");
                    }
                }
            }
            else{
                for(String groupName : map.keySet()){
                    if(question.equals(groupName)){
                        List<String> list = map.get(groupName);
                        Collections.sort(list);
                        for(String memberName : list){
                            sb.append(memberName+"\n");
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
