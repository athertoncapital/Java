public static void bubblesort(Elem array[]) {
   int i,j;
   Elem tmp;
   for (i=0; i < array.length - 1; i++)
       for (j = array.length - 1; j > i; j--)
           if (array[j].key() < array[j-1].key()) {
                 tmp = array[j];
                 array[j] = array[j-1];
                 array[j-1] = tmp;
             }
 }
