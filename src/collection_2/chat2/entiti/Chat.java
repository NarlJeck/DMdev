package collection_2.chat2.entiti;

import java.util.Set;

/**
 * Задание 2
 * Дан список чатов с предыдущего задания, только вместо поля “количество пользователей”
 * будет список объектов типа Пользователь, который имеет 3 поля: id (целочисленный идентификатор), имя и возраст.
 * <p>
 * Задача:
 * <p>
 * - Преобразовать список чатов в один список пользователей всех чатов, возраст которых больше 18 лет
 * <p>
 * - С помощью итератора посчитать средний возраст всех оставшихся пользователей.
 */
public class Chat {
    private String name;
    private Set<User> usersList;


    public Chat(String name, Set<User> usersList) {
        this.name = name;
        this.usersList = usersList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(Set<User> usersList) {
        this.usersList = usersList;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", usersList=" + usersList +
                '}';
    }
}
