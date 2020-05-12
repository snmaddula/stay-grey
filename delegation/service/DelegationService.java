package com.barclays.compliance.delegation.service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

import org.springframework.stereotype.Service;

import com.barclays.compliance.delegation.dto.DelegationDto;
import com.barclays.compliance.delegation.dto.ProductJourneyTaskDto;
import com.barclays.compliance.delegation.entity.DelegationEntity;
import com.barclays.compliance.delegation.repo.DelegationRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DelegationService {

	private final DelegationRepo delegationRepo;
	
	public DelegationEntity saveDelegation(DelegationEntity delegation) {
		return delegationRepo.save(delegation);
	}

	public List<DelegationDto> getAllDelegations() {
		return delegationRepo.findAll().stream().map(this::toDto).collect(Collectors.toList());
	}
	
	
	public DelegationDto toDto(DelegationEntity entity) {
		DelegationDto dto = new DelegationDto();
		dto.setDelegateBrid(entity.getDelegateBrid());
		dto.setDelegateName(entity.getDelegateName());
		dto.setDelegaterBrid(entity.getDelegaterBrid());
		dto.setDelegationType(entity.getDelegationType());
		dto.setEndTs(entity.getEndTs());
		dto.setStartTs(entity.getStartTs());
		dto.setStatus(entity.getStatus());
		dto.setLastUpdatedTs(entity.getLastUpdatedTs());
		dto.setProductJourneyTasks(entity.getProductJourneyTasks().stream().map(te -> new ProductJourneyTaskDto(te.getProductJourneyId().getProductJourneyName(), te.getTaskName())).collect(toList()));
		return dto;
	}
	
}
