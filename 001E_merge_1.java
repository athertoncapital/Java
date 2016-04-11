public void merge(int A[], int m, int B[], int n) {
    int s = m - 1;
    int t = n - 1;
    int u = m + n - 1;

    while (u >= 0) {
	if (t < 0 || (s >= 0 && A[s] > B[t]))
	    A[u--] = A[s--];
	else
	    A[u--] = B[t--];
    }
}
