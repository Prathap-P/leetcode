class Solution {
    public int[] plusOne(int[] array) {
        int n= array.length;
		array[n-1] += 1;
		int i=1;
		while(array[n-i] > 9){
			array[n-i] = 0;
			if((n-i) == 0 ){
				array= func2(array);
				return array;
			}	
			else
				array[n-i-1] += 1;
			i++;
		}
		return array;
	}
	
	public static int[] func2(int[] array2){
		int n= array2.length;
		int[] temp_arr= new int[n+1];
		temp_arr[0]= 1;
		for(int o= 1;o< n+1;o++)
			temp_arr[o]= 0;
		array2= temp_arr;
		return array2;
   }
}