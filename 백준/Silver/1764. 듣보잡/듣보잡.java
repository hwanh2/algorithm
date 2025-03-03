import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] str1 = new String[n];
        String[] str2 = new String[m];
        for(int i=0; i<n; i++){
            str1[i] = br.readLine();
        }
        for(int i=0; i<m; i++){
            str2[i] = br.readLine();
        }
        Arrays.sort(str1);
        Arrays.sort(str2);
        int count = 0;
        List<String> result = new ArrayList<>();
        for(int i=0; i<m; i++){
            if(Arrays.binarySearch(str1,str2[i])>=0){
                result.add(str2[i]);
                count++;
            }
        }
        bw.write(count+"\n");
        for(int i=0; i<result.size(); i++){
            bw.write(result.get(i)+"\n");
        }
        bw.close();
    }
}