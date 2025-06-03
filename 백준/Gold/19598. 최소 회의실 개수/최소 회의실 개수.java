import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<MyClass> arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arrayList.add(new MyClass(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(arrayList);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arrayList.get(0).end);
        for(int i=1; i<n; i++){
            if(arrayList.get(i).start>=pq.peek()){
                pq.poll();
            }
            pq.add(arrayList.get(i).end);
        }
        System.out.println(pq.size());
    }
}

class MyClass implements Comparable<MyClass>{
    public int start;
    public int end;

    public MyClass(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(MyClass o) {
        return this.start - o.start;
    }
}
