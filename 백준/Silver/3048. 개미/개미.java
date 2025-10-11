import java.io.*;
import java.util.*;

public class Main {
    static class Ant{
        public char name;
        public int group;

        public Ant(char name, int group) {
            this.name = name;
            this.group = group;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String str1 = br.readLine();
        String str2 = br.readLine();

        List<Ant> list = new ArrayList<>();

        for(int i=n-1; i>=0; i--){
            list.add(new Ant(str1.charAt(i),1));
        }
        for(int i=0; i<m; i++){
            list.add(new Ant(str2.charAt(i),2));
        }

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            for(int j=0; j<list.size()-1; j++){
                Ant now = list.get(j);
                Ant next = list.get(j+1);
                if(now.group!=2 && now.group!=next.group){
                    list.set(j,next);
                    list.set(j+1,now);
                    j++;
                }
            }
        }

        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i).name);
        }
        System.out.println(sb);
    }
}