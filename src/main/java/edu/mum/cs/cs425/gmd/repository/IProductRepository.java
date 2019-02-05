package edu.mum.cs.cs425.gmd.repository;

import edu.mum.cs.cs425.gmd.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
