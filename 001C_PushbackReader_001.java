import java.io.*;
public class PushbackReaderDemo {
    public static void main(String[] args) {
	String s = "Beware of bugs in the above code; I have only proved it correct, not tried it";
	StringReader sr = new StringReader(s);
	PushbackReader pr = new PushbackReader(sr, 20);
	try {
	    for (int i = 0; i < 32; i++) { /*print 32 chars*/
		char c = (char) pr.read();
		System.out.print("" + c);
	    }
	    System.out.println();
	    pr.close();
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
    }
}
