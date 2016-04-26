public class 0020_singleton {
    private 0020_singleton() {}
    public static 0020_singleton myInstance;        // by default, this field is initialized to null
    public static 0020_singleton getInstance() {
	if(myInstance == null) {
	    myInstance = new 0020_singleton();
	}
	return myInstance;
    }
}
