import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Lecture> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            list.add(new Lecture(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Lecture lec : list){
            if(!pq.isEmpty() && pq.peek()<=lec.start){
                pq.poll();
            }
            pq.add(lec.end);
        }
        System.out.println(pq.size());
    }
}

class Lecture implements Comparable<Lecture>{
    public int start;
    public int end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lecture o) {
        if(this.start!=o.start){
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}