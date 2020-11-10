package com.example.cs4550f20serverjavamichellekang.repositories;

import com.example.cs4550f20serverjavamichellekang.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository
    // object we wanna crud + datatype of primary key
    extends CrudRepository<Widget, Integer> {
    @Query(value = "SELECT * FROM widgets where topic_id=:tid", nativeQuery=true)
    public List<Widget> findWidgetsByTopicId(
            @Param("tid") String topicId);
}
