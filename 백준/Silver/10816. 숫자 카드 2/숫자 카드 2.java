    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            HashMap<Integer,Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            for(int i=0; i<n; i++){
                int num = Integer.parseInt(st.nextToken());
                if(map.containsKey(num)){
                    map.put(num,map.get(num)+1);
                }
                else{
                    map.put(num,1);
                }
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");

            for(int i=0; i<m; i++){
                int num = Integer.parseInt(st.nextToken());
                if(map.containsKey(num)){
                    bw.write(map.get(num)+" ");
                }
                else{
                    bw.write(0+" ");
                }

            }

            bw.flush();
        }
    }
