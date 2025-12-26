package com.pagination.first.repos.impl;

import com.pagination.first.repos.CustomRepo;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

public class CustomRepoImpl<T, ID> extends SimpleMongoRepository<T, ID> implements CustomRepo<T, ID> {

    public CustomRepoImpl(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
    }
}
