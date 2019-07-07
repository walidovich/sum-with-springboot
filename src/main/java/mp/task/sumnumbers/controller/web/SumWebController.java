package mp.task.sumnumbers.controller.web;

import mp.task.sumnumbers.controller.rest.SumRestController;
import mp.task.sumnumbers.model.MyInputs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SumWebController {

	private SumRestController sumRestController;

	public SumWebController(SumRestController sumRestController) {
		this.sumRestController = sumRestController;
	}

	@GetMapping("")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("myInputs", new MyInputs());
		return modelAndView;
	}

	@PostMapping("")
	public ModelAndView sumNumbers(ModelAndView modelAndView, @ModelAttribute("myInputs") MyInputs myInputs,
	                               HttpServletRequest request) {
		modelAndView.setViewName("index");
		modelAndView.addObject("myInputs", myInputs);
		String sum = sumRestController.sumNumbers(myInputs, request);
		modelAndView.addObject("sum", sum);
		return modelAndView;
	}
}
