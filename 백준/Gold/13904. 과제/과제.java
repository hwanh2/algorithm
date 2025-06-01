import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<myClass> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new myClass(a, b));
            maxDay = Math.max(maxDay, a);
        }

        Collections.sort(list, (o1, o2) -> o2.day - o1.day);

        PriorityQueue<myClass> pq = new PriorityQueue<>(); // 점수 큰 순
        int result = 0;
        int idx = 0;

        // 날짜를 거꾸로 순회하면서 해당 날짜에 가능한 과제 중 점수 큰 것 선택
        for (int day = maxDay; day >= 1; day--) {
            while (idx < n && list.get(idx).day >= day) {
                pq.add(list.get(idx++));
            }
            if (!pq.isEmpty()) {
                result += pq.poll().point;
            }
        }

        System.out.println(result);
    }
}

class myClass implements Comparable<myClass> {
    int day;
    int point;

    public myClass(int day, int point) {
        this.day = day;
        this.point = point;
    }

    @Override
    public int compareTo(myClass o) {
        return o.point - this.point;
    }
}
