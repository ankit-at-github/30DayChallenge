package Day27;

public class SmallestValueoftheRearrangedNumber {
	public static long minNumber(long num)
	{
		long result = 0;
		
		long[] freq = new long[10];
		
		boolean pos = false;
		if(num>0) pos = true;
		
		num = Math.abs(num);
		
		while(num>0)
		{
			long d = num%10;
			freq[(int)d]++;
			num/=10;
		}
		
		if(pos)
		{
			//assiging the leftmost bit with smallest number except zero
			for(int i=1; i<=9; i++)
			{
				if(freq[i]!=0)
				{
					result = i;
					freq[i]--;
					break;
				}
			}
			//appending rest of the bit in increasing order
			for(int i=0; i<=9; i++)
			{
				while(freq[i]!=0)
				{
					result = result * 10 + i;
					freq[i]--;
				}
			}
		}
		else
		{
			//assiging the leftmost bit with greater number except zero as the number is negative
			for(int i=9; i>=1; i--)
			{
				if(freq[i]!=0)
				{
					result = i;
					freq[i]--;
					break;
				}
			}
			//appending rest of the bit in decreasing order as the number is negative
			for(int i=9; i>=0; i--)
			{
				while(freq[i]!=0)
				{
					result = result * 10 + i;
					freq[i]--;
				}
			}
			
			result = -result;
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//We need to rearrange the digits of number and return the minimum number generated
		
		long num1 = 310;
		long num2 = -7568;
		
		System.out.println("First Number: "+num1);
		System.out.println("Minimum Number generated from first number: "+minNumber(num1));
		
		System.out.println("Second Number: "+num2);
		System.out.println("Minimum Number generated from Second number: "+minNumber(num2));

	}

}
