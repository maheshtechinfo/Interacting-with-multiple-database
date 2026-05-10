//TwoDBsTestRunner.java
package com.nt.runners;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.offersentity.Offers;
import com.nt.entity.prodentity.Product;
import com.nt.service.IECommerceStoreMgmtService;

@Component
public class TwoDBsTestRunner implements CommandLineRunner {
	@Autowired
	private  IECommerceStoreMgmtService storeService;	

	@Override
	public void run(String... args) throws Exception {
		try {
			Product prod=new Product("table",8900.0,10.0);
			Offers offer=new Offers("sale", 10.0, LocalDate.of(2025, 11, 30));
		String msg=storeService.saveProductAndOffers(prod, offer);
	        System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
