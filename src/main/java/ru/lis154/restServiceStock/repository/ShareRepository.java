package ru.lis154.restServiceStock.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.lis154.restServiceStock.entity.ShareEntity;


import java.util.List;

public interface ShareRepository extends CrudRepository<ShareEntity, Long> {
    @Query(
            value = "select * from shares order by previous_volume desc limit 5",
            nativeQuery = true)
    List<ShareEntity> findHighestFiveCompanySharesDto();

    @Override
    <S extends ShareEntity> Iterable<S> saveAll(Iterable<S> iterable);

    ShareEntity findBySymbol(String symbol);

    @Query(value = "select count(symbol) from shares", nativeQuery = true)
    int countEntity();

    ShareEntity findShareEntityBySymbol(String symbol);
}
