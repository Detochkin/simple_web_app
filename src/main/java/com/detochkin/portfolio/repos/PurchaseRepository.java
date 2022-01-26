package com.detochkin.portfolio.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.detochkin.portfolio.entities.PurchaseEntity;


@Repository//помечаем что этот бин - репозиторий
public interface PurchaseRepository extends CrudRepository<PurchaseEntity, Long> {
}