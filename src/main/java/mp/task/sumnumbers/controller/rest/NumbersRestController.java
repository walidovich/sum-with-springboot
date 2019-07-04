package mp.task.sumnumbers.controller.rest;

import mp.task.sumnumbers.model.MyNumbers;
import mp.task.sumnumbers.service.NumbersService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerInterceptor;

@RestController
@RequestMapping("/api")
public class NumbersRestController implements HandlerInterceptor {

	private NumbersService numbersService;

	public NumbersRestController(NumbersService numbersService) {
		this.numbersService = numbersService;
	}

	@ResponseBody
	@PostMapping
	public Integer sumNumbers(@RequestBody MyNumbers myNumbers) {
		return numbersService.sumNumbers(myNumbers);
	}
}
