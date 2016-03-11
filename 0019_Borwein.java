import java.util.Scanner;
public class Borwein
{
    public double get1fromPi(int k)
    {
	double ak = 6.0 - 4 * Math.sqrt(2);
	double yk = Math.sqrt(2) - 1.0;

	double ak1 ;
	double yk1 ;
	for (int i = 0; i < k; i++)
	    {
		yk1 = (1 - Math.pow((1 - yk * yk * yk * yk),(0.25)))/(1 + Math.pow((1 - yk * yk * yk * yk),(0.25)));
		ak1 = ak * Math.pow((1 + yk1), 4) - Math.pow(2, 2 * i + 3) * yk1 * (1 + yk1 + yk1 * yk1);
		yk = yk1;
		ak = ak1;
	    }
	return ak;
    }

    public static void main (String[] args)
    {
	Scanner scan = new Scanner(System.in);
	Borwein b = new Borwein();
	System.out.println("Enter number of iterations ");
	int k = scan.nextInt();
	System.out.println("\nValue of 1/pi : "+ b.get1fromPi(k));
    }
}
