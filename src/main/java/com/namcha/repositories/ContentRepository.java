package com.namcha.repositories;

import org.springframework.data.repository.CrudRepository;

import com.namcha.models.Content;

public interface ContentRepository extends CrudRepository<Content, String> {
}