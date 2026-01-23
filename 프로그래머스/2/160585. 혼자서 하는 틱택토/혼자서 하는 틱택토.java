class Solution {
    public int solution(String[] board) {
        int answer = 1;
        
        boolean ob = false;
        boolean xb = false;
        
        int oCount = 0;
        int xCount = 0;
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                if(board[i].charAt(j)=='O'){
                    oCount++;
                }
                else if(board[i].charAt(j)=='X'){
                    xCount++;
                }
            }
        }
        
        for(int i=0; i<3; i++){
            if(board[i].charAt(0) != '.' && board[i].charAt(0)==board[i].charAt(1) && board[i].charAt(1)==board[i].charAt(2)){
                if(board[i].charAt(0)=='O'){
                    ob = true;
                }
                else{
                    xb = true;
                }
            }
        }
        
        for(int i=0; i<3; i++){
            if(board[0].charAt(i) != '.' && board[0].charAt(i)==board[1].charAt(i) && board[1].charAt(i)==board[2].charAt(i)){
                if(board[0].charAt(i)=='O'){
                    ob = true;
                }
                else{
                    xb = true;
                }
            }
        }
        
        if(board[0].charAt(0) != '.' && board[0].charAt(0)==board[1].charAt(1) && board[1].charAt(1)==board[2].charAt(2)){
            if(board[0].charAt(0)=='O'){
                ob = true;
            }
            else{
                xb = true;
            }
        }
        
        if(board[0].charAt(2) != '.' && board[0].charAt(2)==board[1].charAt(1) && board[1].charAt(1)==board[2].charAt(0)){
            if(board[0].charAt(2)=='O'){
                ob = true;
            }
            else{
                xb = true;
            }
        }
        
        if(xCount > oCount){
            return 0;
        }
        if(Math.abs(oCount - xCount) >= 2){
            return 0;
        }
        
        if(ob){
            if(xCount == oCount){
                return 0;
            }
        }
        if(xb){
            if(oCount != xCount){
                return 0;
            }
        }
        
        if(ob && xb){
            return 0;
        }

        return answer;
    }
}