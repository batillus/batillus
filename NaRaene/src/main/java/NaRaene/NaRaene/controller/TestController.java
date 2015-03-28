package NaRaene.NaRaene.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping(value="testjsp")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		ModelAndView model = new ModelAndView();
		
		String str = "mamanjka";
		
		model.setViewName("testjsp");
		model.addObject("model" , str);
		return model;
	}

}
