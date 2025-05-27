import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int v){
        if(v == parent[v]){
            return v;
        }
        return parent[v] = find(parent[v]);
    }

    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb){
            parent[fa] = fb;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<m; i++){
            list.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine()," ");
        int t = Integer.parseInt(st.nextToken());
        Set<Integer> truthPeople = new HashSet<>();
        for(int i=0; i<t; i++){
            truthPeople.add(Integer.parseInt(st.nextToken()));
        }

        // 파티 정보 저장 및 union
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int p = Integer.parseInt(st.nextToken());

            int first = -1;
            for(int j=0; j<p; j++){
                int person = Integer.parseInt(st.nextToken());
                list.get(i).add(person);
                if(first == -1){
                    first = person;
                } else {
                    union(first, person);
                }
            }
        }

        // 진실을 아는 사람들의 루트를 저장
        Set<Integer> truthRoots = new HashSet<>();
        for(int person : truthPeople){
            truthRoots.add(find(person));
        }

        // 각 파티마다 진실을 아는 루트가 있는지 확인
        int answer = 0;
        for(List<Integer> party : list){
            boolean canLie = true;
            for(int person : party){
                if(truthRoots.contains(find(person))){
                    canLie = false;
                    break;
                }
            }
            if(canLie) answer++;
        }

        System.out.println(answer);
    }
}
