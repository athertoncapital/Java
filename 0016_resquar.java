import java.util.Scanner;
public class RepeatedSquaring
{
    public double expBySquaring(double x, int n)
    {
	if (n < 0)
	    return expBySquaring(1 / x, -n);
	else if (n == 0)
	    return 1;
	else if (n == 1)
	    return x;
	else if (n % 2 == 0)
	    return expBySquaring(x * x, n / 2);
	else
	    return x * expBySquaring(x * x, (n - 1)/2);
    }
    public static void main (String[] args)
    {
	Scanner scan = new Scanner(System.in);
	RepeatedSquaring rs = new RepeatedSquaring();
	System.out.println("\nEnter n and k of (N ^ K)");
	double n = scan.nextDouble();
	int k = scan.nextInt();
	double result = rs.expBySquaring(n, k);
	System.out.println("\nResult : "+ result);
    }
}
