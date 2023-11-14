package project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.demo.entities.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}