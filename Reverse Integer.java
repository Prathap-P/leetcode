import java.lang.Math.*;

class Solution {
    public int reverse(int x) {
		double sum= 0;
		double limit= Math.pow(2, 31);
		int remainder= 0;
		while(x != 0){
			remainder= x % 10;
			x /= 10;
			sum = (sum* 10 ) + remainder;
		}
		if( sum >= (-limit) && sum <= limit-1)
			return (int)sum;
		return 0;
        
    }
}