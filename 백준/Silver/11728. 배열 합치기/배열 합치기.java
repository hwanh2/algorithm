import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m  =Integer.parseInt(st.nextToken());

        List<Integer> arrayList = new ArrayList<>();
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            arrayList.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<m; i++){
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arrayList);
        for(int num : arrayList){
            sb.append(num+" ");
        }

        System.out.println(sb);

    }
}
