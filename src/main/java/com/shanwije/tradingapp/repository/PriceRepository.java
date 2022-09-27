package com.shanwije.tradingapp.repository;

import com.shanwije.tradingapp.dto.FormattedPriceInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends ReactiveMongoRepository<FormattedPriceInfo, String> {
}
