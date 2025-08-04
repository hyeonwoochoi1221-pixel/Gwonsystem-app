import React, { useState, useEffect } from 'react';

const TodoList = () => {
    // `todos` 라는 state를 만들고, 초기값은 빈 배열로 설정합니다.
    const [todos, setTodos] = useState([]);

    // 컴포넌트가 처음 렌더링될 때 한 번만 실행될 useEffect
    useEffect(() => {
        // 백엔드의 API를 호출합니다.
        // package.json의 "proxy" 설정 덕분에 전체 주소를 적지 않아도 됩니다.
        fetch('/api/todos')
            .then(response => response.json()) // 응답을 JSON 형태로 파싱합니다.
            .then(data => setTodos(data)) // 파싱된 데이터를 todos state에 저장합니다.
            .catch(error => console.error('Error fetching todos:', error));
    }, []); // 두 번째 인자인 배열이 비어있으면, 컴포넌트가 마운트될 때 한 번만 실행됩니다.

    return (
        <div>
            <h1>My To-Do List</h1>
            <ul>
                {/* todos 배열을 순회하면서 각 todo 항목을 <li> 태그로 렌더링합니다. */}
                {todos.map(todo => (
                    <li key={todo.id} style={{ textDecoration: todo.completed ? 'line-through' : 'none' }}>
                        {todo.content}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default TodoList;