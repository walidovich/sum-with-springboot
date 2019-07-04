package mp.task.sumnumbers.service;

import mp.task.sumnumbers.model.MyNumbers;
import org.springframework.stereotype.Service;

@Service
public class NumbersService {

	/**
	 * The service omits the part of Data persistence
	 *
	 * @param myNumbers model holding the values to be summed
	 * @return the sum of the 2 attribute values
	 */
	public Integer sumNumbers(MyNumbers myNumbers) {
		return myNumbers.getN1() + myNumbers.getN2();
	}
}
