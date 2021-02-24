package com.srx.fiscalia.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.srx.fiscalia.app.entities.Issue;

public interface IssueRepository extends CrudRepository<Issue, Integer> {


}
