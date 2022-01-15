package Day4;

public class Search2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int target = 5;
		
		//Can be solved using binary search as it is given that elements of each row is sorted and elements
		//of each column are also sorted
		
		//Approach 2: Start from top-right corner and check if element is greater or smaller
		//if element is greater than target then increase row else decrease column
		
		int row = 0;
        int col = matrix[0].length-1;
        
        boolean found = false;
        
        while(row < matrix.length && col >= 0)
        {
            if(matrix[row][col] == target)
            {
            	found = true;
            	break;
            }
            else
            {
                if(matrix[row][col] > target) col--;
                else row++;
            }
        }
        
        System.out.println(found);
		
	}

}
