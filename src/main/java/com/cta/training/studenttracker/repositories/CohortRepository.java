package com.cta.training.studenttracker.repositories;

import com.cta.training.studenttracker.domain.Cohort;
import org.springframework.data.repository.CrudRepository;

public interface CohortRepository extends CrudRepository<Cohort, Integer> {
}
