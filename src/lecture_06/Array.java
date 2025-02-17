package lecture_06;

public class Array {
	int maxSize;
	int currentSize = 0;
	int[] array;

	/**
	 * Constructor for the Array class.
	 *
	 * @param maxSize the maximum size of the array instance
	 */
	public Array(int maxSize) {
		this.maxSize = maxSize;
		this.array = new int[maxSize];
	}

	/**
	 * Main method for the Array class.
	 *
	 * @param args the command line arguments, ignored.
	 */
	public static void main(String[] args) {
		/*
		 expected output:
		 >Array created with max size: 10
		 >Buffer Exceeded: value 10 too large
		*/
		Array a = new Array(10);
		System.out.println("Array `a` created with max size " + a.maxSize);
		for (int i = 0; i <= a.getMaxSize(); i++) {
			// try and add until we run out of space
			try {
				a.add(i);
			} catch (BufferExceededException e) {
				System.err.println(e.getMessage());
			}
		}

//		Array b = new Array(10);
//		System.out.println("Array `b` created with max size " + b.maxSize);
//		for (int i = 0; i <= b.getMaxSize(); i++) {
//			b.lazyAdd(i); // this won't work, we need to handle the exception!
//		}
	}

	/**
	 * Adds an integer to the next available position in the array instance. The exception is not explicitly dealt with
	 * here.
	 *
	 * @param i the integer to add at the next available position
	 * @throws BufferExceededException if the array is already full
	 */
	public void lazyAdd(int i) throws BufferExceededException {
		this.add(i);
	}

	/**
	 * Adds an integer to the next available position in the array instance.
	 *
	 * @param i the integer to add
	 * @throws BufferExceededException if the array is full
	 */
	private void add(int i) throws BufferExceededException {
		if (currentSize < maxSize) {
			array[currentSize] = i;
			currentSize++;
		} else {
			throw new BufferExceededException(i);
		}
	}

	/**
	 * @return the maximum size of the array instance.
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * @return the current size of the array instance.
	 */
	public int[] getArray() {
		return array;
	}
}
