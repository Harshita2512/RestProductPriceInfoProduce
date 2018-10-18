package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pojo.ProductPriceInfo;
import com.service.ProductPriceInfoService;

@RestController
public class ProductPriceInfoController {
	
	@Autowired
	ProductPriceInfoService productPriceInfoService;
	
	@RequestMapping(value ="/productpriceinfo/{Id}", method =RequestMethod.GET, produces= "application/json")
	public ResponseEntity<ProductPriceInfo> getProducts (@PathVariable int Id) {
		
		ResponseEntity<ProductPriceInfo> response =  null;
		
		try {

			ProductPriceInfo p = productPriceInfoService.getProducts(Id);
		
			if(p!=null) {
				response =  new ResponseEntity<ProductPriceInfo>(p, HttpStatus.OK);
			}else {
				response = new ResponseEntity<ProductPriceInfo>(HttpStatus.NOT_FOUND);
			}
			
			
		} catch(Exception e) {
			response = new ResponseEntity<ProductPriceInfo>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
			return response;
	}
	
	@RequestMapping(value ="/productpriceinfo/{Id}", method =RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProduct (@PathVariable int Id) {

		ResponseEntity<Void> response =  null;
		
		productPriceInfoService.deleteProducts(Id);
		
		response =  new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		return response;
		
	}
	
	@RequestMapping(value ="/productpriceinfo", method =RequestMethod.POST, consumes= "application/json")
	public ResponseEntity<ProductPriceInfo> saveProduct (@RequestBody ProductPriceInfo p) {
		
		ResponseEntity<ProductPriceInfo> response = null;

			int id = productPriceInfoService.saveProducts(p);
			
			p.setId(id);
			
			response =  new ResponseEntity<ProductPriceInfo>(p, HttpStatus.CREATED);
			
			

		return response;
		
	}
	
	@RequestMapping(value ="/productpriceinfo/{Id}", method =RequestMethod.PUT, consumes= "application/json")
	public  ResponseEntity<Void> updateProduct (@PathVariable int Id, @RequestBody ProductPriceInfo p) {
		
		ResponseEntity<Void> response = null;
		
			if(Id != p.getId()) {
				response =  new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				productPriceInfoService.updateProducts(p);
				response =  new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}

		return response;
	}
	
	@RequestMapping(value ="/productpriceinfo", method =RequestMethod.GET, produces= "application/json")
	public ResponseEntity<ArrayList<ProductPriceInfo>> getProductsInfo (){
		
		ResponseEntity<ArrayList<ProductPriceInfo>> response =  null;
		
		ArrayList<ProductPriceInfo> productPriceInfo = productPriceInfoService.getAllProducts();
		
		response = new ResponseEntity<ArrayList<ProductPriceInfo>>(productPriceInfo, HttpStatus.OK);
		
		return response;
	}

}
