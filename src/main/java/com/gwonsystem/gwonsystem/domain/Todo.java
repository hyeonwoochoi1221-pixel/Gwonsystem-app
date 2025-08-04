package com.gwonsystem.gwonsystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 이 클래스가 데이터베이스 테이블과 매핑되는 JPA 엔티티임을 나타냅니다.
@Getter // Lombok: Getter 메소드를 자동으로 생성합니다.
@NoArgsConstructor // Lombok: 파라미터가 없는 기본 생성자를 자동으로 생성합니다.
public class Todo {

    @Id // 이 필드가 테이블의 Primary Key 임을 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 ID를 자동으로 생성하고 관리합니다 (AUTO_INCREMENT).
    private Long id;

    @Column(nullable = false) // 테이블의 컬럼에 매핑되며, null을 허용하지 않습니다.
    private String content;

    @Column(nullable = false)
    private boolean completed;
}