import java.io.*;
import java.util.*;

public class Main {
    static class Student implements Comparable<Student>{
        String name;
        int d;
        int m;
        int y;

        public Student(String name, int d, int m, int y) {
            this.name = name;
            this.m = m;
            this.d = d;
            this.y = y;
        }


        @Override
        public int compareTo(Student o) {
            if(this.y==o.y){
                if(this.m==o.m){
                    return this.d - o.d;
                }
                return this.m - o.m;
            }
            return this.y - o.y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String name = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Student(name,d,m,y));
        }

        Collections.sort(list);

        System.out.println(list.get(list.size()-1).name);
        System.out.println(list.get(0).name);

    }
}
