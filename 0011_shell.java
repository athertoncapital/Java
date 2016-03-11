public static void ShellSort(Elem[] A)
{
 int n = A.length;
 int increment, offset;
 for (increment = n/2; increment >  0; increment = increment / 2)
     for (offset=0; offset < increment; offset++)
 InsertionSort(A, offset, increment);
     }
public static void InsertionSort(Elem[] A,int offset,int increment)
{
 int i,j;
 int n = A.length;
 for (i=offset + increment; i<n; i=i+increment)
         {
     Elem insert_elem = A[i];
     for(j=i-increment; j>=0 && A[j].key() > insert_elem.key(); j = j - increment)
     {
	 A[j+increment] = A[j] ;
     }
     A[j+increment] = insert_elem;
 }
}
//Reference: David Galles' note
