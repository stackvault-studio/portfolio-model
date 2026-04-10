package com.portfolio.service;

import com.portfolio.model.WorkExperience;
import com.portfolio.repository.WorkExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkExperienceService {

    private final WorkExperienceRepository workExperienceRepository;

    public List<WorkExperience> getAllWorkExperiences() {
        return workExperienceRepository.findAll();
    }

    public Optional<WorkExperience> getWorkExperienceById(Long id) {
        return workExperienceRepository.findById(id);
    }

    public WorkExperience createWorkExperience(WorkExperience workExperience) {
        return workExperienceRepository.save(workExperience);
    }

    public WorkExperience updateWorkExperience(Long id, WorkExperience workExperience) {
        workExperience.setId(id);
        return workExperienceRepository.save(workExperience);
    }

    public void deleteWorkExperience(Long id) {
        workExperienceRepository.deleteById(id);
    }
}
