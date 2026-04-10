package com.portfolio.service;

import com.portfolio.model.TechnologyTopicRate;
import com.portfolio.repository.TechnologyTopicRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TechnologyTopicRateService {

    private final TechnologyTopicRateRepository technologyTopicRateRepository;

    public List<TechnologyTopicRate> getAllTechnologyTopicRates() {
        return technologyTopicRateRepository.findAll();
    }

    public Optional<TechnologyTopicRate> getTechnologyTopicRateById(Long id) {
        return technologyTopicRateRepository.findById(id);
    }

    public TechnologyTopicRate createTechnologyTopicRate(TechnologyTopicRate technologyTopicRate) {
        return technologyTopicRateRepository.save(technologyTopicRate);
    }

    public TechnologyTopicRate updateTechnologyTopicRate(Long id, TechnologyTopicRate technologyTopicRate) {
        technologyTopicRate.setId(id);
        return technologyTopicRateRepository.save(technologyTopicRate);
    }

    public void deleteTechnologyTopicRate(Long id) {
        technologyTopicRateRepository.deleteById(id);
    }

    public List<TechnologyTopicRate> getDistinctTechnologies() {
        return technologyTopicRateRepository.findDistinctTechnologies();
    }
}
