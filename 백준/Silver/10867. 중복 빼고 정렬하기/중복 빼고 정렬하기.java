import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        int[] array = new int[set.size()];
        int index = 0;
        for(int num : set){
            array[index++] = num;
        }
        Arrays.sort(array);
        for(int num : array){
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}