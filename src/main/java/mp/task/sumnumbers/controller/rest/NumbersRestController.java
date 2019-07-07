package mp.task.sumnumbers.controller.rest;

import mp.task.sumnumbers.model.MyNumbers;
import mp.task.sumnumbers.service.NumbersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;

@RestController
public class NumbersRestController implements HandlerInterceptor {

	private NumbersService numbersService;

	public NumbersRestController(NumbersService numbersService) {
		this.numbersService = numbersService;
	}

	@ResponseBody
	@PostMapping("/addition")
	public String sumNumbers(@RequestBody MyNumbers myNumbers, HttpServletRequest request) {
		String response = request.getRemoteAddr() +
				", parameters " + myNumbers.getN1() + ", " + myNumbers.getN2() + ", result " + numbersService.sumNumbers(myNumbers, request);
		return response;
	}
}
