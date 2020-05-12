package com.barclays.compliance.delegation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT_JOURNEY")
public class ProductJourneyEntity {

	@Id
	private String id;
	private String productJourneyName;
	
}
