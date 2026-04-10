package com.portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.portfolio.model.enums.Methodology;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String projectName;
    @OneToOne(cascade = CascadeType.ALL)
    private TranslationString projectDescription;
    private String teamSize;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    @Enumerated(EnumType.STRING)
    private Methodology methodology;
    @JsonManagedReference("project-responsibilities")
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Responsibility> responsibilities;
    @JsonManagedReference("project-achievements")
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Achievement> achievements;
    @JsonManagedReference("project-technologies")
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<TechnologyTopicRate> technologies;
    @JsonBackReference("company-projects")
    @ManyToOne
    @JoinColumn(name = "company_id")
    private WorkExperience company;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "project_client",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> clients;

}
