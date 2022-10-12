package com.example.demo.repository;

import com.example.demo.entity.CreateTodo;
import com.example.demo.entity.Todo;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TodoMapper {

  @Select("SELECT * FROM todos")
  List<Todo> findAll();

  @Select("SELECT * FROM todos WHERE id = #{id}")
  Optional<Todo> findById(int id);

  @Insert("INSERT INTO todos (title,description,isCompleted) values (#{title},#{description},#{isCompleted})")
  int createTodo(CreateTodo createTodo);

  @Update("UPDATE todos"
      + " SET"
      + "  title = #{title},"
      + "  description = #{description},"
      + "  isCompleted = #{isCompleted}"
      + " WHERE"
      + "  id = #{id}")
  int updateTodo(@Param("id") int id, @Param("title") String title,
                 @Param("description") String description,
                 @Param("isCompleted") boolean isCompleted);

  @Delete("DELETE FROM todos"
      + " WHERE"
      + "  id = #{id}")
  int deleteTodo(int id);
}
