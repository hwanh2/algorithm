import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            ArrayList<Person> array = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            for(int j=0; j<n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                array.add(new Person(a,b));
            }
            Collections.sort(array);

            int count = 1;
            int min = array.get(0).b;
            for(int j=1; j<array.size(); j++){
                if(array.get(j).b<min){
                    count++;
                    min = array.get(j).b;
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
    }
}
class Person implements Comparable<Person>{
    public int a;
    public int b;

    public Person(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Person o) {
        return this.a - o.a;
    }
}
