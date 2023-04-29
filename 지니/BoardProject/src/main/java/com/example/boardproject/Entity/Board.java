package com.example.boardproject.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
//public Board()
public class Board {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String title;

    private String content;

    public Board(int id, String title, String content) {
        Id = id;
        this.title = title;
        this.content = content;
    }


}
