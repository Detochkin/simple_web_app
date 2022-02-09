package com.detochkin.portfolio.services;


import com.detochkin.portfolio.entities.PurchaseEntity;
import com.detochkin.portfolio.repos.PurchaseRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    //создали публичный метод (название любое может быть)
//на вход принимает сущность и сохраняет ее в базу
    public void save(PurchaseEntity purchaseEntity){
        purchaseRepository.save(purchaseEntity); //реализовали метод внедренного бина
    }

    //возвращает лист всех сущностей из базы
/*    public List<PurchaseEntity> getAll(){

        return purchaseRepository.findAll(); //реализовали метод внедренного бина
    }*/

    public void saveAll(List<PurchaseEntity> purchaseEntityList) {
        for (PurchaseEntity purchaseEntity: purchaseEntityList) {
            purchaseRepository.save(purchaseEntity);
        }
    }

    //возвращает запись из таблицы по id
    public Optional<PurchaseEntity> getById(Long id){
        return purchaseRepository.findById(id);
    }

    //удаляет запись из таблицы по id
    public void delById(Long id){
        purchaseRepository.deleteById(id);
    }

    //возвращает true или false при поиске в таблице Фруктов объекта который соответствует типу FruitEntity или принадлежит к типу объекта который наследуется от FruitEntity
/*    public Boolean exist(Example<? extends PurchaseEntity> example){
        return purchaseRepository.exists(example);
    }*/

}