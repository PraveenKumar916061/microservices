package com.img.questionservice.dao;

import com.img.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findByCategory(String category);

    @Query(value = "select q.id from question q where q.category= :category order by RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Long> findRandomQuestionsByCategory(@Param("category") String category,@Param("numQ") Integer numQ);
}
