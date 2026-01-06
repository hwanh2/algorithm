class Solution {
    static int[] servers;
    static int[] count;
    public int solution(int[] players, int m, int k) {
        int len = players.length;
        servers = new int[len];
        count = new int[len];
        
        for(int i=0; i<len; i++){
            int server = players[i]/m; // 현재 필요한 서버
            if(players[i]!=0 && server>servers[i]){ // 서버 증설이 필요할때만 추가
                int plusServer = server-servers[i];
                for(int j=i; j<i+k && j<len; j++){
                    servers[j]+=plusServer;
                }
                count[i] = plusServer;
            }
        }
        int answer = 0;
        for(int i=0; i<len; i++){
            answer+=count[i];
        }
        return answer;
    }
}