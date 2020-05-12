package com.barclays.compliance.delegation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.compliance.delegation.dto.DelegationDto;
import com.barclays.compliance.delegation.entity.DelegationEntity;
import com.barclays.compliance.delegation.service.DelegationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/delegation")
public class DelegationController {

	private final DelegationService delegationService;
	
	@GetMapping
	public List<DelegationDto> getAllDelegations() {
		return delegationService.getAllDelegations();
	}
	
	@PostMapping
	public DelegationEntity saveDelegation(@RequestBody DelegationEntity delegation) {
		return delegationService.saveDelegation(delegation);
	}
	
}
