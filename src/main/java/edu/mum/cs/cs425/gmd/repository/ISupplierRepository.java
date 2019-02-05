package edu.mum.cs.cs425.gmd.repository;

import edu.mum.cs.cs425.gmd.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplierRepository extends JpaRepository<Supplier, Integer> {
    Supplier findBySupplierId(Long id);
}
