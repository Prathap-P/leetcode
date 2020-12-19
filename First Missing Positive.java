class Solution {
    public int firstMissingPositive(int[] array) {
		int n= array.length;
		int[] temp= new int[n];
		for(int i= 0;i< n; i++)
			if(array[i] > 0 && array[i] <= n)
				temp[array[i]- 1]= array[i];
		for(int i= 0;i< n; i++)
			if(temp[i] == 0)
				return i+1;
		return n+1;
        
    }
}