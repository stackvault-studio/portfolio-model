package com.portfolio.service;

import com.portfolio.model.Responsibility;
import com.portfolio.repository.ResponsibilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResponsibilityService {

    private final ResponsibilityRepository responsibilityRepository;

    public List<Responsibility> getAllResponsibilities() {
        return responsibilityRepository.findAll();
    }

    public Optional<Responsibility> getResponsibilityById(Long id) {
        return responsibilityRepository.findById(id);
    }

    public Responsibility createResponsibility(Responsibility responsibility) {
        return responsibilityRepository.save(responsibility);
    }

    public Responsibility updateResponsibility(Long id, Responsibility responsibility) {
        responsibility.setId(id);
        return responsibilityRepository.save(responsibility);
    }

    public void deleteResponsibility(Long id) {
        responsibilityRepository.deleteById(id);
    }
}
