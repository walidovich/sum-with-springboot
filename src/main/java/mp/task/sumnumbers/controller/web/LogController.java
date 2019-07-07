package mp.task.sumnumbers.controller.web;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class LogController {

	private CacheManager cacheManager;

	public LogController(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	@GetMapping("log")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("log");
		Cache log = cacheManager.getCache("sumNumbers");
		List<String> addresses = new ArrayList<>();
		List<List<String>> keys = log.getKeys();
		for (List<String> key : keys) {
			addresses.add(key.get(0));
		}
		Map<Object, Element> logMap = log.getAll(keys);
		modelAndView.addObject("logMap", logMap);
		modelAndView.addObject("addresses", addresses);
		return modelAndView;
	}
}
