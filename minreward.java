import java.util.*;
import java.util.stream.*;
class Program {
  public static int minRewards(int[] scores) {
    // Write your code here.
		int[] reward = new int[scores.length];
		Arrays.fill(reward, 1);
		int minscore= scores[0];
		int minIdx = 0;
		for (int i = 1 ; i <= scores.length-1; i++){
			   if(minscore > scores[i]){
					 minscore = scores[i];
					 minIdx = i;
				 }
		}
		
		int leftside = minIdx - 1;
		for (int i = leftside; i >= 0; i--){
		  int j = i+1;
			int current = scores[i +1];
			int nextleft = scores[i];
			if (current < nextleft){
				reward[i] = reward[i +1] +1;
			}
			else{
				while(j <= leftside && scores[j] > scores[j-1]){
					reward[j] = Math.max(reward[j], reward[j-1]+1);
					j++;
				}
			}
		}
		int rightside = minIdx + 1;
		for(int i = rightside; i <= scores.length - 1;i++){
			int j = i-1;
			int current = scores[i-1];
			int nextleft = scores[i];
			if (current < nextleft){
				reward[i] = reward[i-1] + 1;
			}else{
				while(j >= rightside && scores[j] > scores[j+1]){
					reward[j] = Math.max(reward[j], reward[j+1]+1);
					j--;
				}}
		
		}
	
			return IntStream.of(reward).sum() ;
  }
}
