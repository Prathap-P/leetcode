class Solution {
    public int[] dailyTemperatures(int[] array) {
       		Stack<Integer>tempStack= new Stack<Integer>();
		int[] indexArray= new int[array.length];
		for(int j= 0;j< array.length; j++){
			while(!tempStack.isEmpty()){
				int peeked= tempStack.peek();
				if(array[peeked] < array[j]){
					int popped= tempStack.pop();
					indexArray[popped]= j-popped;
				}
				else break;
			}
			tempStack.push(j);
		}
		while(!tempStack.isEmpty()){
			int popped= tempStack.pop();
			indexArray[popped]= 0;
		}
		return indexArray;
 
    }
}