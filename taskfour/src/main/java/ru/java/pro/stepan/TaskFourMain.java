package ru.java.pro.stepan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.java.pro.stepan.UserDto.User;
import ru.java.pro.stepan.service.UserService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author SDudin
 */
@ComponentScan
public class TaskFourMain {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskFourMain.class);
        UserService userService = context.getBean(UserService.class);
        userService.createUserDataBase();
        User userOptional = userService.getUserFromDataBase();
        List<User> userList = userService.getUsersFromDataBase();
        userService.deleteUserDataBase();
        System.out.println(userOptional);
        userList.forEach(user -> System.out.println(user.toString()));
    }
}