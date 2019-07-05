package mp.task.sumnumbers.service;

import mp.task.sumnumbers.model.MyNumbers;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class NumbersService {
	
	@Cacheable(value = "sumNumbers", key = "#myNumbers", cacheManager = "cacheManager")
	public Integer sumNumbers(MyNumbers myNumbers) {
		return myNumbers.getN1() + myNumbers.getN2();
	}
}
