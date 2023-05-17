package com.example.boardproject.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity // 엔티티는 기본생성자가 필요험. 따라서 위 ArgsConstructor 어노테이션 사용
public class Board {
    // id, title, content
    // id auto_increment로 올려줌
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;

}
