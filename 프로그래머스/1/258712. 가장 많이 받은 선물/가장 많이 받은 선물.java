class Solution{
	public int solution(String[] friends,String[] gifts) {
		int answer = 0;
		int index1 = 0; // i 가 j 에게 선물을 줄 때 i 의 값
		int index2 = 0; // i 가 j 에게 선물을 줄 때 j 의 값
		int[][] array = new int[friends.length][friends.length]; // 주고받은 선물을 확인하기 위한 2차원 배열
		int[] giftsValue = new int[friends.length]; // 선물지수 값 저장하는 배열
		int[] getGifts = new int[friends.length]; // 받을 선물의 개수를 저장하는 배열
		
		for(int i=0; i<friends.length; i++) {  // 2차원 배열을 0으로 초기화
			for(int j=0; j<friends.length; j++) {
				array[i][j] = 0;
			}
		}
		
		for(int i=0; i<friends.length; i++) { // 받을 선물의 개수 0으로 초기화
			getGifts[i] = 0; 
		}
		
		for(int i=0; i<gifts.length; i++) {
			String[] tmp = gifts[i].split("\\s"); // gifts 에 있는 문자열 배열을 공백 기준으로 나눔 tmp[0]과 tmp[1]에 저장
			
			for(int j=0; j<friends.length; j++) {
				if(tmp[0].equals(friends[j])) { // i 가 j 에게 선물을 줄 때 index1에 i의 값을, index2에 j의 값을 저장
					index1 = j;
				}
				if(tmp[1].equals(friends[j])) {
					index2 = j;
				}
			}
			array[index1][index2]++;
		}
		
		for(int i=0; i<friends.length; i++) {
			int tmp1 = 0; 
			int tmp2 = 0;
			for(int j=0; j<friends.length; j++) {
				tmp1+= array[i][j]; // i 가 준 선물의 개수
				tmp2+= array[j][i]; // i 가 받은 선물의 개수
			}
			giftsValue[i] = tmp1-tmp2; // 선물지수 = i 가 준 선물의 개수 - i 가 받은 선물의 개수
		}
		
		for(int i=0; i<friends.length; i++) {
			for(int j=0; j<friends.length; j++) {
				if(i==j) { // 본인이 본인이랑 비교할 때 넘어가기
					continue;
				}
				if(array[i][j]>array[j][i]) { // i 가 j 에게 선물을 더 많이 줬으면 i 가 받을 선물 증가
					getGifts[i]++;
				}
				else if(array[i][j] == array[j][i]) { // 주고받은 선물이 같거나 0이면 
					if(giftsValue[i]>giftsValue[j]) { // 선물지수가 큰 i 가 받을 선물 증가
						getGifts[i]++;
					}
				}
			}
		}
		
		answer = getGifts[0]; 
		for(int i=1; i<getGifts.length; i++) { // 받을 선물에서 최대값 찾기
			if(answer<getGifts[i]) {
				answer = getGifts[i];
			}
		}
		
		return answer;
	}
}
