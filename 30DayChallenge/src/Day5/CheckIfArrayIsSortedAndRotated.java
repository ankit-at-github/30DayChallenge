package Day5;

public class CheckIfArrayIsSortedAndRotated {
	public static boolean checkSorted(int[] nums)
    {
        int count = 0;
        int n = nums.length;
        for(int i=1; i<=n; i++)
        {
            if(count > 1) return false;
            if(nums[(i-1)%n] > nums[i%n]) count++;
        }
        if(count > 1) return false;
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Just check if array is sorted or not as rotation is allowed at x = 0;
		//If array is sorted in non-decreasing order then it can be rotated to form original array.
		
		int[] nums = {2,1,3,4}; //[1,2,3]
		
	    if(!checkSorted(nums)) System.out.println("False");
	    else System.out.println("True");

	}

}
