package edu.mum.cs.cs425.gmd.service.impl;

import edu.mum.cs.cs425.gmd.model.Product;
import edu.mum.cs.cs425.gmd.repository.IProductRepository;
import edu.mum.cs.cs425.gmd.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

	private final IProductRepository repository;


	public ProductService(IProductRepository repository){
		this.repository = repository;
	}

	@Override
	public List<Product> findAll() {
		return repository.findAll();
	}

	@Override
	public Product save(Product product) {
		return repository.save(product);
	}

	@Override
	public Product findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Product update(Product product) {
		return repository.save(product);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById( id );
	}

}
