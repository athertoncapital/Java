public static void insertionsort(Elem[] array) {
    int i, j;
    Elem current;
    for (i=1; i < array.length; i++) {
	current = array[i];
	for (j=i-1; j >= 0 && array[j].key() > current.key(); j--)
	    array[j+1] = array[j];
	array[j+1] = current;
    }
}
