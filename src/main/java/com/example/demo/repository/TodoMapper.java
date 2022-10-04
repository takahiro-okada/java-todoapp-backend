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

  @Insert("insert into todos (title,description) values (#{title},#{description})")
  int createTodo(CreateTodo createTodo);

  @Update("UPDATE todos"
      + " SET"
      + "  title = #{title},"
      + "  description = #{description}"
      + " WHERE"
      + "  id = #{id}")
  int updateTodo(@Param("id") int id, @Param("title") String title,
                 @Param("description") String description);

  @Delete("DELETE FROM todos"
      + " WHERE"
      + "  id = #{id}")
  int deleteTodo(int id);
}
