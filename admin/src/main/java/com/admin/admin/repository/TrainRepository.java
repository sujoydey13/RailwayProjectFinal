package com.admin.admin.repository;

import com.admin.admin.entity.Trains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

public interface TrainRepository extends CrudRepository<Trains, Long> {
}
