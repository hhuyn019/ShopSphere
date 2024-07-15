package com.cogent.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController
{
	@Autowired
	private DiscountService discountService;
	
	@PostMapping("/code")
	public int getDiscount(@RequestParam String code)
	{
		return discountService.findDiscount(code);
	}
	@PostMapping("/admin/add")
	public DiscountEntity addDiscount(@RequestBody DiscountEntity discountEntity)
	{
		return discountService.addDiscount(discountEntity);
	}
	@DeleteMapping("/admin/{id}")
	public void deleteDiscount(@PathVariable int id)
	{
		discountService.delete(id);
	}
}
