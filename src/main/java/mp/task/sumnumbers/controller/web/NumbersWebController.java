package mp.task.sumnumbers.controller.web;

import mp.task.sumnumbers.model.MyNumbers;
import mp.task.sumnumbers.service.NumbersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NumbersWebController {

	private NumbersService numbersService;

	public NumbersWebController(NumbersService numbersService) {
		this.numbersService = numbersService;
	}

	@GetMapping("")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("myNumbers", new MyNumbers());
		return modelAndView;
	}

	@PostMapping("")
	public ModelAndView sumNumbers(@ModelAttribute("myNumbers") MyNumbers myNumbers) {
		Integer sum = numbersService.sumNumbers(myNumbers);
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("sum", sum);
		modelAndView.addObject("myNumbers", myNumbers);
		return modelAndView;
	}
}
