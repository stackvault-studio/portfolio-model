package com.portfolio.repository;

import com.portfolio.model.Responsibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibilityRepository extends JpaRepository<Responsibility, Long> {

}