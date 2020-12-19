class Solution {
    public List<Integer> findDisappearedNumbers(int[] array) {
		List<Integer> o= new ArrayList<>();
		for(int i= 0;i< array.length; i++)
			array[Math.abs(array[i])- 1]= -Math.abs(array[Math.abs(array[i])- 1]);
		for(int i= 0;i< array.length; i++)
			if(array[i]> 0) 
				o.add(i+1);
 		return o;

    }
}