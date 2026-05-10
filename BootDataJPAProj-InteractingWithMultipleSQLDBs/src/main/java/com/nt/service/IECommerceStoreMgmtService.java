package com.nt.service;

import com.nt.entity.offersentity.Offers;
import com.nt.entity.prodentity.Product;

public interface IECommerceStoreMgmtService {
    public   String  saveProductAndOffers(Product prod,Offers offer);
}
