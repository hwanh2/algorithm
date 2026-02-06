import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        ArrayList<Stack<Integer>> list = new ArrayList<>();

        for(int i=0; i<=6; i++){
            list.add(new Stack<>());
        }

        int count = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            int line = Integer.parseInt(st.nextToken());
            int pl = Integer.parseInt(st.nextToken());

            while(!list.get(line).isEmpty() && list.get(line).peek()>pl){
                list.get(line).pop();
                count++;
            }

            if(list.get(line).isEmpty() || list.get(line).peek()<pl){
                list.get(line).push(pl);
                count++;
            }

        }
        System.out.println(count);
    }
}