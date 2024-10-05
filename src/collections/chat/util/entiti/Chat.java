package collections.chat.util.entiti;

/**
 * Задание 1
 * Дан список чатов.
 * Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 * <p>
 * Задача:
 * <p>
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 * <p>
 * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
 * а если это количество совпадает, то по названию в алфавитном порядке.
 * <p>
 * - Также предоставить сортировку чатов по названию по умолчанию.
 */
public class Chat {
    private String nameChat;
    private Integer countUsers;

    public Chat(String nameChat, Integer countUsers) {
        this.nameChat = nameChat;
        this.countUsers = countUsers;
    }

    public String getNameChat() {
        return nameChat;
    }

    public void setNameChat(String nameChat) {
        this.nameChat = nameChat;
    }

    public Integer getCountUsers() {
        return countUsers;
    }

    public void setCountUsers(Integer countUsers) {
        this.countUsers = countUsers;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "nameChat='" + nameChat + '\'' +
                ", countUsers=" + countUsers +
                '}';
    }
}
