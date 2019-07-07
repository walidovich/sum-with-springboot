package mp.task.sumnumbers.service;

import mp.task.sumnumbers.model.MyNumbers;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class NumbersService {

	@Cacheable(value = "sumNumbers", key = "{#request.getRemoteAddr(), #myNumbers.n1, #myNumbers.n2}", cacheManager = "cacheManager")
	public String sumNumbers(MyNumbers myNumbers, HttpServletRequest request) {
		try {
			return String.valueOf(Integer.valueOf(myNumbers.getN1()) + Integer.valueOf(myNumbers.getN2()));
		} catch (Exception e) {
			return "error";
		}
	}
}
