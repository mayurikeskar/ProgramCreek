package DynamicProg;

public class LongestNon_IncreasingSequence {

	public static void main(String[] args) {

		int[] seq = {5, 3, 4, 8, 6, 7};

		int[] len = new int[seq.length];

		for(int i=0; i<len.length; i++){
			len[i] = 1;
		}

		len[0] =1;

		for(int i=1; i<seq.length; i++){
			for(int j=0; j<i; j++){
				if(seq[i] > seq[j] && len[j] <= len[i]){
					len[i] = len[j] + 1;
				}
			}
		}

		for(int i=0; i<len.length; i++){
			System.out.println(len[i]);
		}

	}

}
