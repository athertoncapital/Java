import java.util.Scanner;
public class CubicConvergencePi
    public double get1fromPi(int k)
    {
	double ak = 1.0/3.0;
	double sk = (Math.sqrt(3) - 1)/2;
	double ak1, sk1, rk1;
	for (int i = 0; i < k; i++)
	    {
		rk1 = 3.0 / (1 + 2 * Math.pow((1 - sk * sk * sk), (1.0/3.0)));
		sk1 = (rk1 - 1)/2.0;
		ak1 = rk1 * rk1 * ak - Math.pow(3, i) * (rk1 * rk1 - 1);
		ak = ak1;
		sk = sk1;
	    }
	return ak;
    }
    public static void main (String[] args)
    {
	Scanner scan = new Scanner(System.in);
	System.out.println("Cubic Convergence 1/Pi Algorithm Test\n");
	CubicConvergencePi  cc = new CubicConvergencePi ();
	System.out.println("Enter number of iterations");
	int k = scan.nextInt();
	System.out.println("\nValue of 1/pi : "+ cc.get1fromPi(k));
    }
}
