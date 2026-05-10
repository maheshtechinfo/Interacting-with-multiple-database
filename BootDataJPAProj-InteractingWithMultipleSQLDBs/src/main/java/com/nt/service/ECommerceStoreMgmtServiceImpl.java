package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.offersentity.Offers;
import com.nt.entity.prodentity.Product;
import com.nt.repository.offersrepo.IOffersRepository;
import com.nt.repository.prodrepo.IProductRepository;


@Service
public class ECommerceStoreMgmtServiceImpl implements IECommerceStoreMgmtService {
	@Autowired
	private IProductRepository prodRepo;
	@Autowired
	private IOffersRepository  offersRepo;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String saveProductAndOffers(Product prod, Offers offer) {
		int idVal1=prodRepo.save(prod).getPid();
		int idVal2=offersRepo.save(offer).getOfferid();
		return "Product is saved with id value::"+idVal1+"  Offers is  saved with id value ::"+idVal2;
	}

}
