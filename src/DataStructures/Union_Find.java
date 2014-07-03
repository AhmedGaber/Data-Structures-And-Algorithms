package DataStructures;


/**
 * @author Ahmed Gaber
 * @date 1/7/2014
 */
public class Union_Find {
	private int id[];
	private int siz[];
	private int count;

	/**
	 * Default Constructor with parameter for number of entries
	 * 
	 * @param n
	 *            Number of entries
	 */
	public Union_Find(int n) {
		count = n;
		id = new int[n];
		siz = new int[n];
		initialize();
	}

	/**
	 * Default Constructor
	 */
	public Union_Find() {
		count = 50;
		id = new int[50];
		siz = new int[50];
		initialize();
	}

	/**
	 * Initialize both id array and siz array.
	 */
	private void initialize() {
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
			siz[i] = 1;
		}
	}

	/**
	 * returns the number of unconnected components.
	 * 
	 * @return count
	 */
	public int count() {
		return count;
	}

	/**
	 * Finds the root for a given node.
	 * 
	 * @param i
	 *            node
	 * @return: the root of the given node
	 */
	private int root(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]]; // to compress the path
			i = id[i];
		}
		return i;
	}

	/**
	 * Do the union operation for two given nodes
	 * 
	 * @param p
	 *            First node
	 * @param q
	 *            Second node
	 */
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (i == j)
			return;
		if (siz[i] < siz[j]) {
			id[i] = j;
			siz[j] += siz[i];
		} else {
			id[j] = i;
			siz[i] += siz[j];
		}
		count--;
	}

	/**
	 * Check wither two nodes are connected
	 * 
	 * @param p
	 *            First node
	 * @param q
	 *            Second node
	 * @return: True if the two nodes are connected, false otherwise.
	 */
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void print() {

		for (int i = 0; i < id.length; i++) {
			System.out.print(id[i] + " ");
		}
		System.out.println();
	}
}
