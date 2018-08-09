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
	 * generates the hashcode of the instance
	 * @return the hashcode
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

	/**
	 * checks if tuple is equal to
	 * @param other
	 * @return if tuples are equal by value/reference
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuple<?, ?> other = (Tuple<?, ?>) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}
}