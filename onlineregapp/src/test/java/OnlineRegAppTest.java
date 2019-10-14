import com.app.ora.dto.UserDto;
import com.app.ora.entity.User;
import com.app.ora.mapper.UserMapper;
import com.app.ora.repository.UserRepository;
import com.app.ora.service.UserService;
import com.app.ora.service.UserServiceimpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
public class OnlineRegAppTest {

    @MockBean
    UserRepository userRepository;

    @TestConfiguration
    static class UserServiceTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserServiceimpl();
        }
    }

    @Autowired
    private UserService userService;

    UserDto userDto;
    User user;

    @Before
    public void init() {

        userDto = new UserDto();
        userDto.setDateRegistered(new Date());
        userDto.setUserFullName("Malwandla Khubz");
        userDto.setUserIdNumber("900000912345");
        userDto.setUserRecordId(10000);

        user = new User();
        user.setUserRecordId(100000);
        user.setDateRegistered(new Date());
        user.setUserFullName("Ian Chidombwe");
        user.setUserIdNumber("34567898765456");

        Mockito.when(userRepository.findOne(String.valueOf(user.getUserRecordId()))).thenReturn(user);

    }

    @Test
    public void dtoToEntityMapperTest() {

        Assert.assertEquals(userDto.getUserFullName(), UserMapper.dtoToEntity(userDto).getUserFullName());
        Assert.assertEquals(userDto.getUserIdNumber(), UserMapper.dtoToEntity(userDto).getUserIdNumber());
    }

    @Test
    public void entityToDtoMapperTest() {

        Assert.assertEquals(user.getUserFullName(), UserMapper.entityToDto(user).getUserFullName());
        Assert.assertEquals(user.getUserFullName(), UserMapper.entityToDto(user).getUserFullName());
    }

    @Test
    public void registerUserTest() {

        Assert.assertTrue(userService.registerUser(userDto));
    }

    @Test
    public void getRegisteredUsersTest() {

        List<User> users = userRepository.findAll();

        Assert.assertEquals(0, users.size());
    }
}
