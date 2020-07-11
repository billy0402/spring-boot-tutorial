package edu.ntub.demo;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.ntub.demo.bean.UserBean;
import edu.ntub.demo.controller.UserController;
import edu.ntub.demo.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
@DisplayName("測試UserController")
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    @DisplayName("測試create")
    void testCreate() throws Exception {
        ObjectNode content = JsonNodeFactory.instance.objectNode();
        content.put("id", 10);
        content.put("name", "test");
        content.put("email", "test@gmail.com");
        content.put("phone", "0912345678");
        content.put("birthday", "1998-04-02");

        UserBean userBean = new UserBean();
        userBean.setId(1);
        Mockito.doReturn(userBean).when(userService).setUser(Mockito.any(UserBean.class));
//        Mockito.when(userService.setUser(Mockito.any(UserBean.class))).thenReturn(userBean);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/user/create")
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content.toString());
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.header().string("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }
}
