/**
 * 
 */
package DynamicProgramming;

public class BuySellStocks {

	public static int maxProfit(int[] prices) {
	    if(prices==null||prices.length<=1)
	        return 0;
	 
	    int min=prices[0]; // min so far
	    int result=0;
	 
	    for(int i=1; i<prices.length; i++){
	        result = Math.max(result, prices[i]-min);
	        min = Math.min(min, prices[i]);
	    }
	 
	    return result;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {3, 2, 1, 5};
		
		int max = maxProfit(arr);
		System.out.println(max);
	}
}
