import java.util.Scanner;
public class Shoelace
{
    public double area(int[][] arr)
    {
	int n = arr.length;
	arr[n - 1][0] = arr[0][0];
	arr[n - 1][1] = arr[0][1];
	double det = 0.0;
	for (int i = 0; i < n - 1; i++)
	    det += (double)(arr[i][0] * arr[i + 1][1]);
	for (int i = 0; i < n - 1; i++)
	    det -= (double)(arr[i][1] * arr[i + 1][0]);
	det = Math.abs(det);
	det /= 2;
	return det;
    }
    public static void main (String[] args)
    {
	Scanner scan = new Scanner(System.in);
	Shoelace s = new Shoelace();
	System.out.println("\nEnter number of points");
	int n = scan.nextInt();
	int[][] arr = new int[n + 1][2];
	System.out.println("Enter "+ n +"");
	for (int i = 0; i < n; i++)
	    {
		arr[i][0] = scan.nextInt();
		arr[i][1] = scan.nextInt();
	    }
	double area = s.area(arr);
	System.out.println("\nArea = "+ area);
    }
}
