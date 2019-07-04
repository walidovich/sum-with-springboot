package mp.task.sumnumbers.controller.web;

import mp.task.sumnumbers.model.MyNumbers;
import mp.task.sumnumbers.service.NumbersService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public ModelAndView sumNumbers(ModelAndView modelAndView, @ModelAttribute("myNumbers") MyNumbers myNumbers,
	                               BindingResult bindingResult) {

		modelAndView.setViewName("index");
		modelAndView.addObject("myNumbers", myNumbers);

		if (bindingResult.hasErrors()) {
			modelAndView.addObject("sum", "error");
		} else {
			Integer sum = numbersService.sumNumbers(myNumbers);
			modelAndView.addObject("sum", sum);
		}
		return modelAndView;
	}
}
