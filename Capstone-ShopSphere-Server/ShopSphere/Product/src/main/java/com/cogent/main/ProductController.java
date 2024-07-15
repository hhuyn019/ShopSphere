package com.cogent.main;

import java.util.List;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	private final JobLauncher jobLauncher;
	private final Job job;
	
	@GetMapping("/products")
	public List<ProductEntity> allProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping("/admin/products")
	public ProductEntity addProduct(@RequestBody ProductEntity productEntity) {
		return productService.addNewProduct(productEntity);
	}
	
	@GetMapping("/products/{id}")
	public ProductEntity oneProduct(@PathVariable int id) {
		return productService.getOneProduct(id);
	}
	
	@PutMapping("/admin/products/{id}")
	public ProductEntity updateProduct(@RequestBody ProductEntity productEntity,@PathVariable int id) {
		return productService.updateProduct(productEntity, id);
	}
	
	@DeleteMapping("/admin/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}
	@GetMapping("/products/categories/{category}")
	public List<ProductEntity> getByCategory(@PathVariable Category category) {
		return productService.getByCategory(category);
	}
	
	@GetMapping("/products/categories")
	public List<String> getCategories() {
		return productService.getCategories();
	}
	
	@PostMapping("/admin/products/bulk-upload")
	public String uploadBatch() {
		try {
			JobParameters jobParameters = new JobParametersBuilder()
					.addLong("startAt", System.currentTimeMillis()).toJobParameters();
			
			JobExecution execution = jobLauncher.run(job, jobParameters);
			if(execution.getExitStatus().equals(ExitStatus.COMPLETED)) {
				return "Batch uploaded";
			} else {
				return "Failed to upload batch";
			}
		} catch (Exception e) {
			return "Failed to upload batch: " + e.getMessage();
		}
	}
}
