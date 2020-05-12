package com.barclays.compliance.delegation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.compliance.delegation.entity.ProductJourneyEntity;

@Repository
public interface ProductJourneyRepo extends JpaRepository<ProductJourneyEntity, String> {

}
