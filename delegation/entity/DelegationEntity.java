package com.barclays.compliance.delegation.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.barclays.compliance.delegation.enums.DelegationStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "DELEGATION")
@ToString(exclude = "productJourneyTasks")
@EqualsAndHashCode(exclude = "productJourneyTasks")
public class DelegationEntity {

	@Id
	private String id;
	private String delegaterBrid;
	private String delegateBrid;
	private String delegateName;
	private String delegationType;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Timestamp startTs;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Timestamp endTs;
	private String rational;
	private String emailSummaryFlag;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Timestamp lastUpdatedTs;
	private String lastUpdatedBy;
	@Enumerated(EnumType.STRING)
	private DelegationStatus status;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="DELEGATION_TASK",
              joinColumns={@JoinColumn(name="delegation_id", referencedColumnName="id")},
              inverseJoinColumns={@JoinColumn(name="product_journey_task_id", referencedColumnName="id")})
	@JsonIgnoreProperties("delegationTasks")
	private Set<ProductJourneyTaskEntity> productJourneyTasks;
	
	@PrePersist
	public void preInsert() {
		computeStatus();
		lastUpdatedTs = new Timestamp(System.currentTimeMillis());
	}
	
	@PreUpdate
	public void preUpdate() {
		computeStatus();
		lastUpdatedTs = new Timestamp(System.currentTimeMillis());
	}
	
	DelegationStatus computeStatus() {
		long currTime = System.currentTimeMillis();
		if(startTs != null && startTs.getTime() > currTime) {
			return DelegationStatus.Future;
		}else if(startTs != null && endTs != null && startTs.getTime() <= currTime && currTime >= endTs.getTime()) {
			return DelegationStatus.Present;
		} else {
			return DelegationStatus.Past;
		}
	}
}
