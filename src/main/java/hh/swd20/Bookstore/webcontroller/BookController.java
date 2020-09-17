package hh.swd20.Bookstore.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BookController {
	@RequestMapping("/index")
	public String Ind() {
		return "BookStore";
	}
	
}
