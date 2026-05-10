package com.nt.repository.offersrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.offersentity.Offers;

public interface IOffersRepository extends JpaRepository<Offers, Integer> {

}
