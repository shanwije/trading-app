package com.shanwije.tradingapp.repository;

import com.shanwije.tradingapp.dto.FormattedPriceInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends MongoRepository<FormattedPriceInfo, String> {
}
