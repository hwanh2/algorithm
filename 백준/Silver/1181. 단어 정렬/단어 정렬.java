import javax.lang.model.type.ArrayType;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] array = new String[n];
        for(int i=0; i<n; i++){
            array[i] = br.readLine();
        }
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        bw.write(array[0]+"\n");
        for(int i=1; i<n; i++){
            if(!array[i].equals(array[i-1])){
                bw.write(array[i]+"\n");
            }
        }
        bw.close();
    }
}