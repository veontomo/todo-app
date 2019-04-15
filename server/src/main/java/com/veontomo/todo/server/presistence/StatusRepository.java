package com.veontomo.todo.server.presistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veontomo.todo.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>  {

}
