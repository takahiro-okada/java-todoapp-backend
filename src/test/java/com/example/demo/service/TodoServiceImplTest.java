package com.example.demo.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoMapper;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TodoServiceImplTest {

  @InjectMocks
  TodoServiceImpl todoServiceImpl;

  @Mock
  TodoMapper todoMapper;

  @Test
  public void 存在するTODOのIDを指定したときに正常にTODOが返されること() throws Exception {
    doReturn(Optional.of(new Todo(1, "タイトル", "説明", false))).when(todoMapper).findById(1);
    Todo actual = todoServiceImpl.findById(1);
    assertThat(actual).isEqualTo(new Todo(1, "タイトル", "説明", false));
  }
}
