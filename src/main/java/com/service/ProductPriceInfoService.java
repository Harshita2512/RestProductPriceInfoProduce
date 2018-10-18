package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.ProductPriceInfoDatabase;

import com.pojo.ProductPriceInfo;


@Service
public class ProductPriceInfoService {
	
	@Autowired
	ProductPriceInfoDatabase productPriceInfoDatabase;
	
    public ProductPriceInfo getProducts(int id) {
    	
	ProductPriceInfo p = productPriceInfoDatabase.getProducts(id);
    	
    	return p;
	
}
    public void deleteProducts(int id) {
    	
    	productPriceInfoDatabase.deleteProduct(id);
    }
    
    public void updateProducts(ProductPriceInfo p) {
    	
    	productPriceInfoDatabase.updateProduct(p);
    }
    
    public int saveProducts(ProductPriceInfo p) {
    	
    	return productPriceInfoDatabase.savePersons(p);
    }
    
    public ArrayList<ProductPriceInfo> getAllProducts (){
		
		ArrayList<ProductPriceInfo> productInfo = productPriceInfoDatabase.getAllProducts();
		
		return productInfo;
		
	}

}
