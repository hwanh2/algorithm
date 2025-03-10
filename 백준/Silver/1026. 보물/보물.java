import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array1.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array2.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(array1);
        Collections.sort(array2);
        Collections.reverse(array2);
        int sum = 0;
        for(int i=0; i<n; i++){
            sum+=array1.get(i)*array2.get(i);
        }
        bw.write(sum+"\n");
        bw.flush();
    }
}
