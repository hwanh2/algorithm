import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            list.add(new Person(name,k,e,m));
        }

        Collections.sort(list);

        for(Person person : list){
            System.out.println(person.name);
        }

    }
}
class Person implements Comparable<Person>{
    public String name;
    public int k;
    public int e;
    public int m;

    public Person(String name, int k, int e, int m) {
        this.name = name;
        this.k = k;
        this.e = e;
        this.m = m;
    }

    @Override
    public int compareTo(Person o) {
        if (this.k!=o.k) {
            return o.k - this.k;
        }
        if (this.e!=o.e) {
            return this.e - o.e;
        }
        if (this.m!=o.m) {
            return o.m - this.m;
        }
        return this.name.compareTo(o.name);
    }

}