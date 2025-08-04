package com.gwonsystem.gwonsystem.repository;

import com.gwonsystem.gwonsystem.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // 이것만으로도 findAll(), findById(), save(), delete() 등
    // 기본적인 DB 오퍼레이션을 모두 사용할 수 있습니다.
}