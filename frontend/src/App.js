import React from 'react';
import TodoList from './components/TodoList'; // 우리가 만든 TodoList 컴포넌트를 import 합니다.
import './App.css';

function App() {
    return (
        <div className="App">
            <header className="App-header">
                {/* 기존의 리액트 로고 대신 TodoList 컴포넌트를 렌더링합니다. */}
                <TodoList />
            </header>
        </div>
    );
}

export default App;