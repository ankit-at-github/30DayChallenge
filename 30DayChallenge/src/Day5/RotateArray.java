package Day5;

public class RotateArray {
	public static void reverse(int[] arr, int start, int end)
	{
		while(start < end)
		{
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//It is easy to solve using extra space. challenge is to to solve in-place, O(1) space complexity
		
		int[] nums = {1,2,3,4,5,6,7};
		
		System.out.println("Original Array");
		for(int n : nums)
		System.out.print(n+" ");
		
		int k = 5;
		
		//if k is equal to size of array that means no rotation needed as it will give same array
		k%=nums.length;
		
		//Logic is to first reverse the entire array and then reverse o to k-1 and k to arr.length-1 elements
		//this is for O(1) space complexity
		
		System.out.println();
		
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
		
		System.out.println("Rotated Array by K = "+k);
		for(int n : nums)
		System.out.print(n+" ");
		

	}

}
