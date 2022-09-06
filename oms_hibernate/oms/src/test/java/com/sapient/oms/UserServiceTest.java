package com.sapient.oms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.oms.entity.User;
import com.sapient.oms.notification.EmailTemplate;
import com.sapient.oms.repository.UserRepository;
import com.sapient.oms.services.UserService;

@SpringBootTest
class UserServiceTest {
    @InjectMocks
    UserService userService;
    @Mock
    UserRepository userRepository;
    @Mock
    EmailTemplate emailTemplate;

    @Test
    void testCreateUserService() {
        User user = new User();
        user.setId(1);
        user.setFirstName("Rachit");
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(emailTemplate.mailUserOnCreation(user)).thenReturn("Mail successfully sent");
        User actualUser = userService.createUser(user);
        assertEquals(user, actualUser);

    }

}
