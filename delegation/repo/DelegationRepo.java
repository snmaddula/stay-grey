package com.barclays.compliance.delegation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.compliance.delegation.entity.DelegationEntity;

@Repository
public interface DelegationRepo extends JpaRepository<DelegationEntity, String> {

}
