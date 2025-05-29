package ru.vish.moex_api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vish.moex_api.entity.PriceHistoryEntity;

import java.util.List;

@Repository
public interface PriceHistoryRepository extends CrudRepository<PriceHistoryEntity, Long> {
    @Query(value = "SELECT * FROM price_history WHERE ticker=:ticker ORDER BY timestamp DESC LIMIT :count", nativeQuery = true)
    List<PriceHistoryEntity> getLastPrices(String ticker, int count);
}
