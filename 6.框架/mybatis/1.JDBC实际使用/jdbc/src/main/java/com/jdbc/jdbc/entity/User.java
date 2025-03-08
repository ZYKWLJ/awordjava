package com.jdbc.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    @Override
    public String toString(){
        return "id="+this.id+"\tname="+this.name;
    }
}
