package collection_2.chat2.util;

import collection_2.chat2.entiti.Chat;
import collection_2.chat2.entiti.User;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * - Преобразовать список чатов в один список пользователей всех чатов, возраст которых больше 18 лет
 * <p>
 * - С помощью итератора посчитать средний возраст всех оставшихся пользователей.
 */


public final class ChatUtil {

    private static final int age = 18;

    public static Set<User> usersOverEighteen(Set<Chat> chatList) {
        Set<User> userListOverEight = new HashSet<>();

        for (Iterator<Chat> listIteratorChat = chatList.iterator(); listIteratorChat.hasNext(); ) {
            Chat nextValue = listIteratorChat.next();
            Set<User> usersList = nextValue.getUsersList();
            for (User user : usersList) {
                if (user.getUserAge() >= age) {

                    userListOverEight.add(user);
                }
            }
        }
        return userListOverEight;

    }

    public static int userAVGAgeUnderEighteen(Set<Chat> chatList) {
        int sumAge = 0;
        int countUser = 0;
        for (Iterator<Chat> listIteratorChat = chatList.iterator(); listIteratorChat.hasNext(); ) {
            Chat nextValue = listIteratorChat.next();
            Set<User> usersList = nextValue.getUsersList();
            for (User user : usersList) {
                if (user.getUserAge() < age) {
                    sumAge += user.getUserAge();
                    countUser++;
                }
            }
        }
        return sumAge / countUser;
    }

}
