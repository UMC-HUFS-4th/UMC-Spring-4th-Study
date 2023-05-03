package com.example.board_project.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

// public Board() - 빈 생성자
public class Board {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    // id, title, content
    private Long Id;

    private String title;

    private String content;


}
