package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.entity.Todo;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoMapperTest {

  @Autowired
  TodoMapper todoMapper;

  @Test
  @Sql(scripts = {"classpath:/sqlannotation/delete-todos.sql",
      "classpath:/sqlannotation/insert-todos.sql"})
  @Transactional
  void すべてのTodoが取得できること() {
    List<Todo> actual = todoMapper.findAll();
    assertThat(actual).hasSize(3);
  }

  @Test
  @Sql(scripts = {"classpath:/sqlannotation/delete-todos.sql",
      "classpath:/sqlannotation/insert-todos.sql"})
  @Transactional
  void 取得したTodoの中身が一致すること() {
    List<Todo> actual = todoMapper.findAll();
    List<Todo> expected = new ArrayList<>();
    Todo todo1 = new Todo(1, "title1", "desc1");
    Todo todo2 = new Todo(2, "title2", "desc2");
    Todo todo3 = new Todo(3, "title3", "desc3");
    expected.add(todo1);
    expected.add(todo2);
    expected.add(todo3);

    assertThat(actual).isEqualTo(expected);
  }
}
