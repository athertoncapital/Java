public class power
{
    public static int mystery(int n)
    {
	if (n == 0)
	    return 1;
	else if (n==1)
	    return 2;
	else
	    return 2* mystery( n - 1);
    }

    public static void main(String argv[])
    {
	//int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	int n;
	int result = mystery(3);
	System.out.printf("Result is: %d%n", result);
    }
}
