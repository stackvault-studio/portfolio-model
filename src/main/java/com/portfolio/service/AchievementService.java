package com.portfolio.service;

import com.portfolio.model.Achievement;
import com.portfolio.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    public List<Achievement> getAllAchievements() {
        return achievementRepository.findAll();
    }

    public Optional<Achievement> getAchievementById(Long id) {
        return achievementRepository.findById(id);
    }

    public Achievement createAchievement(Achievement achievement) {
        return achievementRepository.save(achievement);
    }

    public Achievement updateAchievement(Long id, Achievement achievement) {
        achievement.setId(id);
        return achievementRepository.save(achievement);
    }

    public void deleteAchievement(Long id) {
        achievementRepository.deleteById(id);
    }
}
