package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.entity.Todo;
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
  @Sql(
      scripts = {"classpath:/sqlannotation/delete-todos.sql",
          "classpath:/sqlannotation/insert-todos.sql"}
  )
  @Transactional
  void すべてのTodoが取得できること() {
    List<Todo> actual = todoMapper.findAll();
    assertThat(actual)
        .hasSize(3);
  }
}
