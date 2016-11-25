package com.namcha.repositories;

import com.namcha.models.Content;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContentRepository extends CrudRepository<Content, String> {
    List<Content> findAllByOrderByStartDateAsc();
}