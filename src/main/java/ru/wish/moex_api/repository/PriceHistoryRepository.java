package ru.wish.moex_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.wish.moex_api.entity.PriceHistoryEntity;

@Repository
public interface PriceHistoryRepository extends CrudRepository<PriceHistoryEntity, Long> {

}
