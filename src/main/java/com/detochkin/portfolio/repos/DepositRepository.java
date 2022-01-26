package com.detochkin.portfolio.repos;

import com.detochkin.portfolio.entities.DepositEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends CrudRepository<DepositEntity, Long> {
}
