class Solution {
    public int searchInsert(int[] array, int target) {
		int n= array.length;
		for(int i= 0;i< n; i++){
			if(array[i] == target)
				return i;
			else if(array[i] > target)
				return i;
		}
		return n;
    
    }
}