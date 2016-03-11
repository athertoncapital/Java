import java.util.Scanner;
public class ShuntingYard
{
    private enum Precedence
    {
	lparen(0), rparen(1), plus(2), minus(3), divide(4), times(5), mod(6), eos(7), operand(8);

	private int index;
	Precedence(int index)
	{
	    this.index = index;
	}
	public int getIndex()
	{
	    return index;
	}
    }
    private static final int[] isp = {0, 19, 12, 12, 13, 13, 13, 0};
    private static final int[] icp = {20, 19, 12, 12, 13, 13, 13, 0};
    private static final char[] operators = {'{', '}', '+', '-', '/', '*', '%', ' '};
    private Precedence[] stack;
    private int top;
    private Precedence pop()
    {
	return stack[top--];
    }
    private void push(Precedence ele)
    {
	stack[++top] = ele;
    }
    public Precedence getToken(char symbol)
    {
	switch (symbol)
	    {
	    case '('  : return Precedence.lparen;
	    case ')'  : return Precedence.rparen;
	    case '+'  : return Precedence.plus;
	    case '-'  : return Precedence.minus;
	    case '/'  : return Precedence.divide;
	    case '*'  : return Precedence.times;
	    case '%'  : return Precedence.mod;
	    case ' '  : return Precedence.eos;
	    default   : return Precedence.operand;
	    }
    }
    public String postfix(String infix)
    {
	String postfix = "";
	top = 0;
	stack = new Precedence[infix.length()];
	stack[0] = Precedence.eos;
	Precedence token;
	for (int i = 0; i < infix.length(); i++)
	    {
		token = getToken(infix.charAt(i));
		if (token == Precedence.operand)
		    postfix = postfix + infix.charAt(i);
		else if (token == Precedence.rparen)
		    {
			while (stack[top] != Precedence.lparen)
			    postfix = postfix + operators[pop().getIndex()];
			pop();
		    }
		else
		    {
			while (isp[stack[top].getIndex()] >= icp[token.getIndex()])
			    postfix = postfix + operators[pop().getIndex()];
			push(token);
		    }
	    }
	while ((token = pop()) != Precedence.eos)
	    postfix = postfix + operators[token.getIndex()];

	return postfix;
    }
    public static void main (String[] args)
    {
	Scanner scan = new Scanner(System.in);
	ShuntingYard sy = new ShuntingYard();
	System.out.println("Please type infix expression");
	String infix = scan.next();
	String postfix = sy.postfix(infix);
	System.out.println("\nPostfix : "+ postfix);
    }
}
