import java.io.*;
import java.util.*;

public class Main {
    static class Time implements Comparable<Time>{
        public int startTime;
        public int endTime;

        public Time(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Time o) {
            if (this.endTime == o.endTime) return this.startTime - o.startTime;
            return this.endTime - o.endTime;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Time> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            list.add(new Time(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        int count = 0;
        int[] rooms = new int[k];

        for (Time time : list) {
            int index = -1;
            int finishTime = -1;

            for (int i=0; i<k; i++) {
                if (rooms[i] < time.startTime) {
                    if (rooms[i] > finishTime) {
                        finishTime = rooms[i];
                        index = i;
                    }
                }
            }

            if (index!=-1) {
                rooms[index] = time.endTime;
                count++;
            }
        }
        System.out.println(count);
    }
}