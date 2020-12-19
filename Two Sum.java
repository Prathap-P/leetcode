class Solution {
    public int[] twoSum(int[] nums, int target) {
		int[] array= nums;
		int[] result= new int[2];
		calc_fun(array, result, target);
        return result;        
    }
	public static void calc_fun(int[] array, int[] result, int target){
		for(int o= 0;o< array.length; o++)
			for(int p= o+1;p< array.length; p++){
				if( (array[o] + array[p]) == target){
					result[0]= o;
					result[1]= p;
					return;
				}
			}
	}
}
// Return two indices which adds up to the target in an array
