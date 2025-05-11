import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> arrayList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            arrayList.add(br.readLine());
        }

        String dna = "";
        for(int i=0; i<m; i++){
            Map<Character,Integer> map = new HashMap<>();
            for(int j=0; j<n; j++){
                char c = arrayList.get(j).charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);
            }
            int max = 0;
            char maxChar = ' ';
            for(char c : map.keySet()){
                if(map.get(c)>max){
                    maxChar = c;
                    max = map.get(c);
                }
                else if(map.get(c)==max){
                    if(c<maxChar){
                        maxChar = c;
                    }
                }
            }
            dna+=maxChar;
        }

        int distance = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arrayList.get(i).charAt(j)!=dna.charAt(j)){
                    distance++;
                }
            }
        }
        sb.append(dna).append("\n").append(distance);
        System.out.println(sb);

    }

}

