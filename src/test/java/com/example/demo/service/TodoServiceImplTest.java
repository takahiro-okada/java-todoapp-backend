package com.example.demo.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.demo.controller.TodoResponse;
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

  //  テスト対象のクラスのインスタンスに付与することでインスタンス内の@Injectされたメンバーのインスタンスに
  //  @Mockのモックインスタンスを差し込むことができる
  @InjectMocks
  TodoServiceImpl todoServiceImpl;


  //  モック化するクラスのインスタンスを生成
  @Mock
  TodoMapper todoMapper;

  @Test
  public void 存在するTODOのIDを指定したときに正常にTODOが返されること() throws Exception {
    //    Patter 1 ※コメントアウトしていても、テストを「Patter 2」のテストを走らせるとエラーになるので削除してからテストを行うこと。
    //    doReturn(Optional.of(new Todo(1, "タイトル", "説明"))).when(todoMapper).findById(1);
    //    Todo actual = todoServiceImpl.findById(1);
    //    assertThat(actual).isEqualTo(new Todo(1, "タイトル", "説明"));

    //    Pattern 2
    doReturn(Optional.of(new Todo(1, "タイトル", "説明"))).when(todoMapper).findById(1);
    todoServiceImpl.findById(1);
    verify(todoMapper,times(1)).findById(1);
  }
}
