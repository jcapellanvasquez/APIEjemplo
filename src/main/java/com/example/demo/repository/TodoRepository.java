package com.example.demo.repository;

import com.example.demo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    Optional<Todo> findById(Integer id);

   @Query(
           value = "select * from public.todo where id=:id",
           nativeQuery = true
   )
    Todo findByIdCustom(@Param("id") Integer id);
}
