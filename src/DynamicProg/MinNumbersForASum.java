package DynamicProg;

public class MinNumbersForASum {

	public static void main(String[] args) {

		int[] coins = {1, 3, 5};

		int sum = 11;

		int[] min = new int[sum+1];

		String[] choosen = new String[sum+1];
		
		for(int i =0; i<min.length; i++){
			min[i] = Integer.MAX_VALUE;
			choosen[i] = "";
		}

		min[0] =0;
		for(int i =0; i<sum+1; i++){
			for(int j=0; j<coins.length; j++){
				if(coins[j] <= i && min[i- coins[j]] + 1< min[i]){
					min[i] = min[i - coins[j]] + 1;
					choosen[i] = choosen[i-coins[j]] +" "+ coins[j];
				}
			}
		}

		for(int i=0; i<min.length; i++){
			System.out.println(min[i]);
		}
		
		for(int i=0; i<min.length; i++){
			System.out.println(choosen[i]);
		}
		
		System.out.println("no of coins : "+min[sum] +" coins are :"+ choosen[sum] );
	}

}
