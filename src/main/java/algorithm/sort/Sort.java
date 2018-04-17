package algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Sort {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getCanonicalName());
	
	public abstract void sort(int[] array);

}
