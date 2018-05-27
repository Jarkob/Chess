package models;

/**
 * represents any value tuple
 * @author jakobbussas
 *
 * @param <X> the type of the first value
 * @param <Y> the type of the second value
 */
public class Tuple<X, Y> {
	
	/**
	 * creates new tuple
	 * @param first the first value
	 * @param second the second value
	 */
	public Tuple(X first, Y second) {
		this.first = first;
		this.second = second;
	}
	
	/**
	 * the first value
	 */
	public final X first;
	
	/**
	 * the second value
	 */
	public final Y second;
	
	/**
	 * formats tuple as string
	 * @return formatted string
	 */
	@Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

	/**
	 * checks if tuple is equal to
	 * @param other
	 * @return if tuples are equal by value/reference
	 */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Tuple)){
            return false;
        }

        @SuppressWarnings("unchecked")
		Tuple<X,Y> other_ = (Tuple<X,Y>) other;

        // this may cause NPE if nulls are valid values for x or y. The logic may be improved to handle nulls properly, if needed.
        return other_.first.equals(this.first) && other_.second.equals(this.second);
    }
}