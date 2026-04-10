package com.portfolio.repository;

import com.portfolio.model.TechnologyTopicRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologyTopicRateRepository extends JpaRepository<TechnologyTopicRate, Long> {

    @Query(value = "SELECT * FROM technology_topic_rate t WHERE t.name IN (SELECT DISTINCT name FROM technology_topic_rate)", nativeQuery = true)
    List<TechnologyTopicRate> findDistinctTechnologies();
}