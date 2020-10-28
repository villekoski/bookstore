package hh.swd20.Bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository repository;
	
	@RequestMapping("/categorylist")
	 public String categoryList(Model model) {
        model.addAttribute("category", repository.findAll());
        return "categorylist";
	}
	  @RequestMapping(value ="/addC")
	    public String addCategory(Model model) {
		  model.addAttribute("category", new Category());
		  return "newcategory";
	}
	  @RequestMapping(value = "/saveC", method = RequestMethod.POST)
	  	public String save(Category category) {
		  repository.save(category);
		  return "redirect:categorylist";
	  }
}
