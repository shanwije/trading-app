package com.shanwije.tradingapp.repository;

import com.shanwije.tradingapp.dto.FormattedPriceInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PriceRepository extends ReactiveMongoRepository<FormattedPriceInfo, String> {
}
