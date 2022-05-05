import com.example.sep3_t2.Sep3T2Application;
import com.example.sep3_t2.controller.UserController;
import com.example.sep3_t2.model.User;
import com.example.sep3_t2.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Sep3T2Application.class)
@WebMvcTest(UserController.class)
public class RestMethodTest {


    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    UserService userService;

    User user1 = new User("Aleks","Spaghetti","somethin@something.com",
            "pass123",null);
    User user2 = new User("Dimitr","Angelo","somethin@something.com",
            "pass123",null);

    @Test
    public void getAllUseres_success() throws Exception {
        List<User> users = new ArrayList<>(Arrays.asList(user1,user2));

        Mockito.when(userService.getAllUsers()).thenReturn(Optional.of(users));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createUser_success() throws Exception {


        //Mockito.when(authService.saveUser(user1)).thenReturn(user1);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(user1));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Test
    public void updateUser_success() throws Exception {
      //  Mockito.when(authService.getUserById(user1.getId())).thenReturn(user1);
      //  Mockito.when(authService.saveUser(user1)).thenReturn(user1);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/users/"+user1.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(user1));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Test
    public void deleteUserById_success() throws Exception {
    //    Mockito.when(authService.getUserById(user1.getId())).thenReturn((user1));

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/users/"+user1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
