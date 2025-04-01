import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int na = Integer.parseInt(st.nextToken());
        int nb = Integer.parseInt(st.nextToken());

        HashMap<Long,Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<na; i++){
            long num = Long.parseLong(st.nextToken());
            map.put(num,0);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<nb; i++){
            long num = Long.parseLong(st.nextToken());
            if(map.containsKey(num)){
                map.remove(num);
            }
        }
        ArrayList<Long> array = new ArrayList<>(map.keySet());
        Collections.sort(array);
        int size = map.size();
        if(map.size()==0){
            System.out.println(0);
        }
        else{
            sb.append(size).append("\n");
            for(Long num : array){
                sb.append(num).append(" ");
            }
            System.out.println(sb);
        }


    }
}

