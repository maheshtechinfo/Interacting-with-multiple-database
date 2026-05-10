package com.nt.entity.offersentity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="MDB_OFFERS")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Offers {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "OFFER_ID_SEQ1",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer offerid;

	@Column(length = 30)
	@NonNull
	private  String  name;
	@NonNull
	private  Double discount;
	@NonNull
	private   LocalDate expiryDate;
	

}
