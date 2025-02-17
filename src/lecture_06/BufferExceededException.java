package lecture_06;

public class BufferExceededException extends Exception { // needs to extend exception to *be* an exception
	private int max;

	public BufferExceededException(int max) {
		super("Buffer Exceeded: value " + max + " too large");
		this.max = max;
	}
}
