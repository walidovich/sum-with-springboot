package mp.task.sumnumbers.controller.rest;

import mp.task.sumnumbers.model.MyInputs;
import mp.task.sumnumbers.service.NumbersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SumRestController implements HandlerInterceptor {

	private NumbersService numbersService;

	public SumRestController(NumbersService numbersService) {
		this.numbersService = numbersService;
	}

	@ResponseBody
	@PostMapping("/addition")
	public String sumNumbers(@RequestBody MyInputs myInputs, HttpServletRequest request) {
		return numbersService.sumNumbers(myInputs, request);
	}
}
