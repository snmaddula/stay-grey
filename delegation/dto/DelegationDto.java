package com.barclays.compliance.delegation.dto;

import java.sql.Timestamp;
import java.util.List;

import com.barclays.compliance.delegation.enums.DelegationStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class DelegationDto {

	private String id;
	private String delegaterBrid;
	private String delegateBrid;
	private String delegateName;
	private String delegationType;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp startTs;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp endTs;
	private String rational;
	private String emailSummaryFlag;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp lastUpdatedTs;
	private String lastUpdatedBy;
	private DelegationStatus status;
	private List<ProductJourneyTaskDto> productJourneyTasks;
}
