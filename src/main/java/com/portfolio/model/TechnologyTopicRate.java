package com.portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.portfolio.model.enums.TechnologyCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyTopicRate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String coveredTopic;
    @OneToOne(cascade = CascadeType.ALL)
    private TranslationString description;
    @Enumerated(EnumType.STRING)
    private TechnologyCategory technology;
    private BigDecimal rate;
    @JsonBackReference("project-technologies")
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "certification_id")
    private Certification certification;

}
