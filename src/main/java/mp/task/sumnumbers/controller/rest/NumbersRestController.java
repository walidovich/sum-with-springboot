package mp.task.sumnumbers.controller.rest;

import mp.task.sumnumbers.model.MyNumbers;
import mp.task.sumnumbers.service.NumbersService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class NumbersRestController implements HandlerInterceptor {

	private NumbersService numbersService;

	public NumbersRestController(NumbersService numbersService) {
		this.numbersService = numbersService;
	}

	@ResponseBody
	@PostMapping
	public String sumNumbers(@RequestBody MyNumbers myNumbers, HttpServletRequest request) {
		return request.getRemoteAddr() +
				", parameters " + myNumbers.getN1() + ", " + myNumbers.getN2() + ", result " + numbersService.sumNumbers(myNumbers);
	}
}
