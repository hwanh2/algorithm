import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int[] array1 = new int[n];
        int[] array2 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array1[i] = Integer.parseInt(st.nextToken());
            array2[i] = array1[i];
        }

        Arrays.sort(array2);

        int index = 0;
        for(int i=0; i<n; i++){
            if(!map.containsKey(array2[i])){
                map.put(array2[i],index++);
            }
        }

        for(int i=0; i<n; i++){
            sb.append(map.get(array1[i])).append(" ");
        }

        System.out.println(sb);

    }
}

