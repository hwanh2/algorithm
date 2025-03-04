import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> array = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            String y = st.nextToken();
            array.add(new Person(x,y));
        }
        Collections.sort(array);

        for(int i=0; i<n; i++){
            bw.write(array.get(i).x+" "+array.get(i).y+"\n");
        }
        bw.flush();
    }
}
class Person implements Comparable<Person>{
    public int x;
    public String y;

    public Person(int x, String y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Person o) {
        return this.x - o.x;
    }
}