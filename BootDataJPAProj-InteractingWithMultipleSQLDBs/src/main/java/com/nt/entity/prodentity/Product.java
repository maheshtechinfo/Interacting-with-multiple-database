package com.nt.entity.prodentity;

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
@Table(name="MDB_PRODUCT")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "PROD_ID_SEQ1",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer pid;

	@Column(length = 30)
	@NonNull
	private  String  pname;
	@NonNull
	private  Double price;
	@NonNull
	private   Double qty;
	

}
