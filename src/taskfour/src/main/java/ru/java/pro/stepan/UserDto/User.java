package ru.java.pro.stepan.UserDto;

/**
 * @author SDudin
 */
public class User {
    private Long userId;
    private String userName;

    public User(Long id, String userName) {
        this.userId = id;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User() {

    }
}
