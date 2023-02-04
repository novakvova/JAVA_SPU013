package models;

import emums.QuestionType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="tbl_question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="text", nullable = false, length = 500)
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(name="queystion_type")
    private QuestionType questionType;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionItem> questionItems;
}
