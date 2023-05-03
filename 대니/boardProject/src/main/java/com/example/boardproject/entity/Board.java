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
@Entity

public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id, title, content
    private long Id;

    private String title;

    private String content;

}
