package edu.mum.cs.cs425.gmd.service.impl;

import edu.mum.cs.cs425.gmd.model.Supplier;
import edu.mum.cs.cs425.gmd.repository.ISupplierRepository;
import edu.mum.cs.cs425.gmd.service.ISupplierService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("supplierService")
public class SupplierService implements ISupplierService {

	private final ISupplierRepository supplierRepository;

	public SupplierService(ISupplierRepository supplierRepository){
		this.supplierRepository = supplierRepository;
	}

	@Override
	public List<Supplier> findAll() {
		List<Supplier> suppliers = supplierRepository.findAll();
		return suppliers;
	}

	@Override
	public Supplier save(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public Supplier findById(Long id) {
		return supplierRepository.findBySupplierId(id);
	}

	@Override
	public Supplier update(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public void delete(Long id) {
		supplierRepository.deleteById( Integer.parseInt(""+id) );
	}

}
