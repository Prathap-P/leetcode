import java.lang.Math;

class Solution {
    public int maxArea(int[] array) {
		int max_area= 0;
		int height, width= 0;
		for(int i= 0;i< array.length; i++)
			for(int j= i+1;j< array.length; j++){
				width= j-i;
				height= Math.min(array[i], array[j]);
				if( (height * width) > max_area)
					max_area= (height * width);
				continue;
			}
		return max_area;
      
    }
}