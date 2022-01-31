package Day20;

public class SlidingWindow {

	public static void main(String args[]) {
	      int[] arr = {1,2,7,7,4,3,6};
	      int k = 3;
	      
	      System.out.print("Given Array: ");
	      for(int x : arr) System.out.print(x+" ");
	      
	      System.out.println();
	      System.out.println("K: "+k);
	      
	      int maxi = Integer.MIN_VALUE;
	      int sum = 0;
	      
	      //the size of boolean will vary as per given constraints on numbers to be present in the array
	      boolean[] hash = new boolean[10];
	      int j = 0;
	      
	      for(int i=0; i<arr.length; i++)
	      {
	          if(!hash[arr[i]])
	          {
	              //marking element as seen
	              hash[arr[i]] = true;
	              sum+=arr[i];
	          }
	          else
	          {
	              while(j<i)
	              {
	                  hash[arr[j]] = false;
	                  j++;
	                  sum-=arr[j];
	              }
	              hash[arr[j]] = true;
	              sum = arr[j];
	          }
	          //if difference is equal to window size,now window size will remain constant
	          if(i-j+1==k)
	          {
	              maxi = Math.max(maxi,sum);
	              hash[arr[j]] = false;
	              sum-=arr[j];
	              j++;
	          }
	      }
	      
	      System.out.println("Maximum Sum of Subarray of size k with distinct elements: "+maxi);
	      
	    }

}
