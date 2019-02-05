package edu.mum.cs.cs425.gmd.controller;

import java.util.List;
import javax.validation.Valid;

import edu.mum.cs.cs425.gmd.model.Supplier;
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

@Controller
public class SupplierController {

	@Autowired
	private ISupplierService service;
	
	@RequestMapping(value={"/suppliers","/suppliers/browse"}, method=RequestMethod.GET)
	public ModelAndView displaySuppliers() {
		ModelAndView mav = new ModelAndView();
		List<Supplier> suppliers = service.findAll();
		mav.addObject("suppliers", suppliers);
		mav.setViewName("suppliers/browse");
		return mav;
	}
	
	@RequestMapping(value="/suppliers/new", method = RequestMethod.GET)
	public String createSupplierForm(Model model){
		model.addAttribute("supplier", new Supplier());
		return "suppliers/new";
	}
	
	@RequestMapping(value = "/suppliers/new", method = RequestMethod.POST)
	public String createSupplier(@Valid @ModelAttribute("supplier") Supplier supplier,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("supplier",supplier);
			return "suppliers/new";
		}
		service.save(supplier);
		return "redirect:/suppliers/browse";
	}
	
	@RequestMapping(value="/suppliers/edit/{id}", method = RequestMethod.GET)
	public String editSupplier(@PathVariable Long id, Model model){
		Supplier s = service.findById(id);
		if (s != null) {
			model.addAttribute("supplier", s);
			return "suppliers/edit";
		}
		return "suppliers/browse";
	}
	
	@RequestMapping(value = "/suppliers/edit", method = RequestMethod.POST)
	public String updateSupplier(@Valid @ModelAttribute("supplier") Supplier supplier,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("supplier",supplier);
			return "suppliers/edit";
		}
		service.save(supplier);
		return "redirect:/suppliers/browse";
	}
}
