package mp.task.sumnumbers.service;

import mp.task.sumnumbers.model.MyInputs;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class NumbersService {

	@Cacheable(value = "sumNumbers", key = "{#request.getRemoteAddr(), #myInputs.n1, #myInputs.n2}", cacheManager = "cacheManager")
	public String sumNumbers(MyInputs myInputs, HttpServletRequest request) {
		try {
			return String.valueOf(Integer.valueOf(myInputs.getN1()) + Integer.valueOf(myInputs.getN2()));
		} catch (Exception e) {
			return "error";
		}
	}
}
