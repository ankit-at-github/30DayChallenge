package Day4;

public class Search2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		
		//Element to be searched in the 2-D matrix
		int target = 5;
		
		//number of rows
		int row = matrix.length;
		//number of columns
		int col = matrix[0].length;
		
		//Think it as numbers are stores in 1-D array and total elements will be row*col (indexed from 0)
		
		int start = 0;
		int end = (row*col) - 1;
		
		boolean found = false;
		
		while(start <= end)
		{
			int mid = start + (end-start)/2;
			
			//to get the mid index as index in 2-D array
			
			if(matrix[mid/col][mid%col] == target)
			{
				found = true;
				break;
			}
			else
			{
				if(matrix[mid/col][mid%col] < target) start = mid+1;
				else end = mid-1;
			}
		}
		
		System.out.println(found);
	}

}
