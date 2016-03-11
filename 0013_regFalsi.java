public class RegularFalsi
{
    public double f(double x)
    {
	return Math.cos(x) - x * x * x;
    }
    public double findRoot(double s, double t, double e, int m)
    {
	double r = 0.0,fr;
	int n, side = 0;
	double fs = f(s);
	double ft = f(t);
	for (n = 0; n < m; n++)
	    {
		r = (fs * t - ft * s) / (fs - ft);
		if (Math.abs(t - s) < e * Math.abs(t + s))
		    break;
		fr = f(r);
		if (fr * ft > 0)
		    {
			t = r;
			ft = fr;
			if (side == -1)
			    fs /= 2;
			side = -1;
		    }
		else if (fs * fr > 0)
		    {
			s = r;
			fs = fr;
			if (side == +1)
			    ft /= 2;
			side = +1;
		    }
		else
		    {
			break;
		    }
	    }
	return r;
    }
    public static void main(String[] args)
    {
	RegularFalsi rf = new RegularFalsi();
	double s = 0;
	double t = 1;
	double e = 5E-15;
	int iterations = 100;
	System.out.println("\nRoot : "+ rf.findRoot(s, t, e, iterations));
    }
}
