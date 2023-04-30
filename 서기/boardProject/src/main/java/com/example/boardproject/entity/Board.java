package com.example.boardproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // 엔티티는 기본생성자가 필요험. 따라서 위 ArgsConstructor 어노테이션 사용
public class Board {
    // id, title, content
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;



}
