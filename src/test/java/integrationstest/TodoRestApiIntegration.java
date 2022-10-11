package integrationstest;

import com.example.demo.DemoApplication;
import java.nio.charset.StandardCharsets;
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
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Sql
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = DemoApplication.class)
public class TodoRestApiIntegration {

  @Autowired
  MockMvc mockMvc;

  @Test
  @Sql(
      scripts = {"classpath:/sqlannotation/delete-todos.sql",
          "classpath:/sqlannotation/insert-todos.sql"}
  )
  @Transactional
  void Todoが全件取得したときにステータスコードが200であること() throws Exception {
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
            "\"description\":\"desc1\"" +
            "}," +
            "{" +
            "\"id\":2," +
            "\"title\": \"title2\"," +
            "\"description\":\"desc2\"" +
            "}," +
            "{" +
            "\"id\":3," +
            "\"title\": \"title3\"," +
            "\"description\":\"desc3\"" +
            "}" +
            "]"
        , response, JSONCompareMode.STRICT);
  }
  
}
