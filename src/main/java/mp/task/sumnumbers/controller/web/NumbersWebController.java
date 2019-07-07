package mp.task.sumnumbers.controller.web;

import mp.task.sumnumbers.controller.rest.NumbersRestController;
import mp.task.sumnumbers.model.MyNumbers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NumbersWebController {

	private NumbersRestController numbersRestController;

	public NumbersWebController(NumbersRestController numbersRestController) {
		this.numbersRestController = numbersRestController;
	}

	@GetMapping("")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("myNumbers", new MyNumbers());
		return modelAndView;
	}

	@PostMapping("")
	public ModelAndView sumNumbers(ModelAndView modelAndView, @ModelAttribute("myNumbers") MyNumbers myNumbers,
	                               HttpServletRequest request) {
		modelAndView.setViewName("index");
		modelAndView.addObject("myNumbers", myNumbers);
		String sum = numbersRestController.sumNumbers(myNumbers, request);
		modelAndView.addObject("sum", sum);
		return modelAndView;
	}
}
