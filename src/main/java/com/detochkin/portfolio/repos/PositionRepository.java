package com.detochkin.portfolio.repos;

import com.detochkin.portfolio.entities.PositionEntity;
import com.detochkin.portfolio.entities.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<PositionEntity, Long> {

}
