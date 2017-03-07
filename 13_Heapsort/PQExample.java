

public class PQExample {
	public static void main(String ...args) {
		PQ<Integer> myPQ = new PQ<>(10);
		
		myPQ.insert(5);
		myPQ.insert(3);
		myPQ.insert(2);
		myPQ.insert(9);
		myPQ.insert(7);
		myPQ.insert(4);
		myPQ.insert(6);
		myPQ.insert(8);
		myPQ.insert(1);
		
		System.out.println("Removed: "+myPQ.removeMost());
		System.out.println("Removed: "+myPQ.removeMost());
		System.out.println("Removed: "+myPQ.removeMost());
		System.out.println("Removed: "+myPQ.removeMost());
		System.out.println("Removed: "+myPQ.removeMost());
		System.out.println("Removed: "+myPQ.removeMost());
		System.out.println("Removed: "+myPQ.removeMost());
		System.out.println("Removed: "+myPQ.removeMost());
		System.out.println("Removed: "+myPQ.removeMost());
	}
}

class PQ<C extends Comparable<C>> {

	private int MAX_SIZE;
	private int N;
	private C[] heap;

	public PQ(int maxSize) {
		MAX_SIZE = maxSize;
		heap = (C[]) new Comparable[MAX_SIZE + 1];
		N = 0;
	}

	private int parent(int i) {
		return i >> 1; // 0.5i
	}

	private int left(int i) {
		return i << 1; // 2i
	}

	private int right(int i) {
		return i << 1 | 1; // 2i + 1
	}

	private void swap(int i, int j) {
		C t = heap[i];
		heap[i] = heap[j];
		heap[j] = t;
	}

	private void heapifySink(int i) {
		while (2 * i <= N) {
			int l = left(i), r = right(i), most = i;
			if (l <= N && heap[l] != null && heap[i].compareTo(heap[l]) > 0)
				most = l;
			if (r <= N && heap[r] != null && heap[most].compareTo(heap[r]) > 0)
				most = r;
			if (most == i)
				break;
			swap(i, most);
			i = most;
		}
	}

	private void heapifySwim(int i) {
		while (i > 1 && heap[parent(i)].compareTo(heap[i]) > 0) {
			int paren = parent(i);
			swap(paren, i);
			i = paren;
		}
	}

	// Exposed API

	public void insert (C el) {
            heap[++N] = el;
            heapifySwim(N);
        }

	public C most() {
		return heap[1];
	}

	public C removeMost() {
		C mos = most();
		if (mos != null) {
			swap(1, N--);
			heap[N + 1] = null;
			heapifySink(1);
		}
		return mos;
	}

	public int size() {
		return N;
	}
}
