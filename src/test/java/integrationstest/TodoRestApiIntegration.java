package integrationstest;

import com.example.demo.DemoApplication;
import com.example.demo.controller.TodoController;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Sql
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = DemoApplication.class)
public class TodoRestApiIntegration {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  TodoController target;

  @BeforeEach
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(target).build();
  }

  @Test
  @Sql(
      scripts = {"classpath:/sqlannotation/delete-todos.sql",
          "classpath:/sqlannotation/insert-todos.sql"}
  )
  @Transactional
  void Todoが全件取得に成功すると200で内容を返すこと() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/todos"))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  @Sql(
      scripts = {"classpath:/sqlannotation/delete-todos.sql",
          "classpath:/sqlannotation/insert-todos.sql"}
  )
  @Transactional
  void 取得した全件のTodoの中身が一致していること() throws Exception {
    String response = mockMvc.perform(MockMvcRequestBuilders.get("/todos"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

    JSONAssert.assertEquals("[" +
            "{" +
            "\"id\":1," +
            "\"title\":\"title1\"," +
            "\"description\":\"desc1\"," +
            "\"isCompleted\":false" +
            "}," +
            "{" +
            "\"id\":2," +
            "\"title\": \"title2\"," +
            "\"description\":\"desc2\"," +
            "\"isCompleted\":false" +
            "}," +
            "{" +
            "\"id\":3," +
            "\"title\": \"title3\"," +
            "\"description\":\"desc3\"," +
            "\"isCompleted\":false" +
            "}" +
            "]"
        , response, JSONCompareMode.STRICT);
  }

  @Test
  @Sql(
      scripts = {"classpath:/sqlannotation/delete-todos.sql",
          "classpath:/sqlannotation/insert-todos.sql"}
  )
  @Transactional
  void 存在しないtodoのidにアクセスしたときにと404とそのメッセージが返ること() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/todos/99"))
        .andExpect(MockMvcResultMatchers.status().is(404));
  }

}
