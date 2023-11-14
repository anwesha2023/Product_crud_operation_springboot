package project.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.demo.entities.Product;
import project.demo.repository.ProductRepo;
@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepo productRepo1;
	
	@Override
	public Product saveProduct(Product product) {
		
		return productRepo1.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepo1.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return productRepo1.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		Product product=productRepo1.findById(id).get();
		
		if(product!=null)
		{
			productRepo1.delete(product);
			return "Product Delete Successfully";
		}
		return " Something wrong on server";
	}

	@Override
	public Product editProduct(Product p, Integer id) {
		Product oldproduct=productRepo1.findById(id).get();
		
		oldproduct.setProductname(p.getProductname());
		oldproduct.setDescription(p.getDescription());
		oldproduct.setPrice(p.getPrice());
		oldproduct.setStatus(p.getStatus());
		
		return productRepo1.save(oldproduct);
	}

	
	

}
