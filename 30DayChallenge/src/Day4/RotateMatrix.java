package Day4;

public class RotateMatrix {

	public static void main(String[] args) {
		//The question is about matrix rotation (by 90 degree clockwise) of size nxn without using any extra space.
		
		int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		int n = matrix.length;
		
		System.out.println("Original Matrix");
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		//Step 1 : Transpose the matrix (In-Place)
		for(int i=0; i<n; i++)
		{
			for(int j=i+1; j<n; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		System.out.println();
		System.out.println("Transposed Matrix");
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		//Step 2 : Reflect/Mirror the matrix from start till mid (Row-Wise Traversal).
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n/2; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n-j-1];
				matrix[i][n-j-1] = temp;
			}
		}
		
		System.out.println();
		System.out.println("Matrix - Roatated by 90 degree Clockwise");
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
