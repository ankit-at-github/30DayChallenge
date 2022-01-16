package Day6;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Print the matrix in Spiral Order
		
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		
		System.out.println("Original Matrix");
		
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[i].length; j++)
			{
				System.out.print(matrix[i][j] +" ");
			}
		}
		
		List<Integer> ans = new ArrayList<>();
		
		int top = 0;
		int bottom = matrix.length-1;
		int left = 0;
		int right = matrix[0].length-1;
		
		int size = (matrix.length * matrix[0].length);
		
		//avoid adding duplicates, add until total elements are not added there could be the case where
		//top is equal to bottom and left is equal to right which will add duplicates.
		
		while(ans.size() < size)
		{
			for(int i = left; i<=right && ans.size() < size; i++)
			{
				ans.add(matrix[top][i]);
			}
			
			top++;
			
			for(int i = top; i<=bottom && ans.size() < size; i++)
			{
				ans.add(matrix[i][right]);
			}
			
			right--;
			
			for(int i = right; i>=left && ans.size() < size; i--)
			{
				ans.add(matrix[bottom][i]);
			}
			
			bottom--;
			
			for(int i = bottom; i>=top && ans.size() < size; i--)
			{
				ans.add(matrix[i][left]);
			}
			
			left++;
		}
		
		System.out.println();
		System.out.println("Spiral Matrix");
		
		for(int n : ans) System.out.print(n+" ");
		
	}

}
