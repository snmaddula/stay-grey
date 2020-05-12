package com.barclays.compliance.delegation.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "PRODUCT_JOURNEY_TASK")
@ToString(exclude = "delegationTasks")
@EqualsAndHashCode(exclude = "delegationTasks")
public class ProductJourneyTaskEntity {

	@Id
	private String id;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private ProductJourneyEntity productJourneyId;
	private String taskName;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "productJourneyTasks")
	@JsonIgnoreProperties("productJourneyTasks")
	private Set<DelegationEntity> delegationTasks;

}
