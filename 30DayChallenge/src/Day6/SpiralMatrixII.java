package Day6;

public class SpiralMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Given a positive integer n,
		//generate an n x n matrix filled with elements from 1 to n*n in spiral order.
		
		int n = 5;
		
		int[][] matrix = new int[n][n];
        
        
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        
        int lastElement = n*n;
        int sequence = 1;
        
        while(sequence!=lastElement+1)
        {
            for(int i=left; i<=right && sequence!=lastElement+1; i++) matrix[top][i] = sequence++;
            
            top++;
            
            for(int i=top; i<=bottom && sequence!=lastElement+1; i++) matrix[i][right] = sequence++;
            
            right--;
            
            for(int i=right; i>=left && sequence!=lastElement+1; i--) matrix[bottom][i] = sequence++;
            
            bottom--;
            
            for(int i=bottom; i>=top && sequence!=lastElement+1; i--) matrix[i][left] = sequence++;
            
            left++;
        }
        
        for(int i=0; i<n; i++)
        {
        	for(int j=0; j<n; j++)
        		System.out.print(matrix[i][j]+ " ");
        	System.out.println();
        }

	}

}
