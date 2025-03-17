import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> array = new ArrayList<>();
        for(int i=0; i<n; i++){
            String str = br.readLine();
            if(str.length()>=m){
                if(map.containsKey(str)){
                    map.put(str,map.get(str)+1);
                }
                else{
                    map.put(str,1);
                }
            }
        }
        for(String str : map.keySet()){
            array.add(str);
        }
        Collections.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) != map.get(o2)) { // 값이 다르면 내림차순 정렬
                    return map.get(o2) - map.get(o1);
                }
                else { // 값이 같으면 길이순 정렬
                    if (o2.length() != o1.length()) {
                        return o2.length() - o1.length();
                    } else {
                        return o1.compareTo(o2);
                    }
                }
            }
        });

        for(int i=0; i<array.size(); i++){
            bw.write(array.get(i)+"\n");
        }
        bw.flush();
    }
}
