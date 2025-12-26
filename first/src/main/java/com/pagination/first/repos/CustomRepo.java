package com.pagination.first.repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomRepo<T, ID> extends MongoRepository<T, ID> {

    List<T> findAll();

}
