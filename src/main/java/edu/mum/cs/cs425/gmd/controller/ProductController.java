package edu.mum.cs.cs425.gmd.controller;

import edu.mum.cs.cs425.gmd.model.Product;
import edu.mum.cs.cs425.gmd.model.Supplier;
import edu.mum.cs.cs425.gmd.service.IProductService;
import edu.mum.cs.cs425.gmd.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

	@Autowired
	private IProductService service;

	@Autowired
	private ISupplierService supplierService;
	
	@RequestMapping(value={"/products","/products/browse"}, method=RequestMethod.GET)
	public ModelAndView displayProducts() {
		ModelAndView mav = new ModelAndView();
		List<Product> products = service.findAll();
		mav.addObject("products", products);
		mav.setViewName("products/browse");
		return mav;
	}
	
	@RequestMapping(value="/products/new", method = RequestMethod.GET)
	public String createProductForm(Model model){
		model.addAttribute("product", new Product());
		List<Supplier> suppliers = supplierService.findAll();
		model.addAttribute("suppliers", suppliers);
		return "products/new";
	}
	
	@RequestMapping(value = "/products/new", method = RequestMethod.POST)
	public String registerNewStudent(@Valid @ModelAttribute("products") Product product,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			model.addAttribute("product",product);
			return "products/new";
		}
		service.save(product);
		return "redirect:/products/browse";
	}
	
	@RequestMapping(value="/products/edit/{id}", method = RequestMethod.GET)
	public String editStudent(@PathVariable Long id, Model model){
		Product s = service.findById(id);
		if (s != null) {
			model.addAttribute("product", s);
			return "products/edit";
		}
		return "products/browse";
	}
	
	@RequestMapping(value = "/products/edit", method = RequestMethod.POST)
	public String updateStudent(@Valid @ModelAttribute("product") Product product,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("product",product);
			return "products/edit";
		}
		service.save(product);
		return "redirect:/products/browse";
	}
}
