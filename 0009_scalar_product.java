//007
//09122015
//William Chuang
// Calculate the product of three integers.
import java.util.Scanner; // program uses Scanner 

public class Product
{
    public static void main(String[] args) 
    {
	// create Scanner to obtain input from command window
	Scanner input = new Scanner(System.in);
	
	double x; // first number input by user
	int y; // second number input by user
	int z; // third number input by user
	int result; // product of numbers
	
	System.out.print("Enter first integer: "); // prompt for input
	x = input.nextInt(); // read first integer
	
	System.out.print("Enter the second integer: ");
	y = input.nextInt();
	
	System.out.print("Enter the third integer: ");
	z = input.nextInt();
	
	result = x * y * z;
	
	System.out.printf("Product is %d%n", result);
    } // end method main
} // end class Product