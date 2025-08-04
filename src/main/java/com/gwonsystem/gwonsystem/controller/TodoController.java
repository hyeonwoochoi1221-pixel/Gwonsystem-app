package com.gwonsystem.gwonsystem.controller;

import com.gwonsystem.gwonsystem.domain.Todo;
import com.gwonsystem.gwonsystem.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // 이 클래스는 RESTful API 컨트롤러임을 나타냅니다. 반환값은 자동으로 JSON으로 변환됩니다.
@RequestMapping("/api") // 이 컨트롤러의 모든 API는 /api 로 시작됩니다.
public class TodoController {

    @Autowired // 스프링이 자동으로 TodoRepository 인스턴스를 주입해줍니다.
    private TodoRepository todoRepository;

    @GetMapping("/todos") // HTTP GET 요청을 http://.../api/todos 주소로 받습니다.
    public List<Todo> getAllTodos() {
        // todoRepository를 사용해 DB에 있는 모든 Todo 데이터를 조회하여 반환합니다.
        return todoRepository.findAll();
    }
}