package com.example.demo.repository;

import com.example.demo.entity.CreateTodo;
import com.example.demo.entity.Todo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TodoMapper {
    @Select("SELECT * FROM todos")
    List<Todo> findAll();

    @Select("SELECT * FROM todos WHERE id = #{id}")
    Todo findById(int id);

    @Insert("insert into todos (title,description) values (#{title},#{description})")
    void createTodo(CreateTodo createTodo);

}
