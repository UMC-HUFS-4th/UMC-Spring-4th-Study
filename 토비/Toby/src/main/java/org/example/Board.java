package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

    private Long id;
    private String title;
    private String content;

    public Board(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

}