package collections.chat.util;

import collections.chat.entiti.Chat;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 * *
 * * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
 * * а если это количество совпадает, то по названию в алфавитном порядке.
 * *
 * * - Также предоставить сортировку чатов по названию по умолчанию.
 */
public final class ChatUtil {
    private static final Integer countUsers = 1000;


    private ChatUtil() {
    }

    /**
     * Удаляет из списка те чаты, что содержат менее 1000 пользователей.
     * * *
     */
    public static void LengthChat(List<Chat> list) {
        for(Iterator<Chat> listIterator = list.listIterator();listIterator.hasNext();){
            Chat nextValue = listIterator.next();
            if (nextValue.getCountUsers() < countUsers) {
                listIterator.remove();
            }
        }
    }

    public static void showChatList(List<Chat> list) {
        for (Iterator<Chat> listIterator = list.listIterator(); listIterator.hasNext();) {
            Chat nextValue = listIterator.next();
            System.out.println(nextValue);
        }
    }

    public static void decreasingNumberUsers(List<Chat> list) {
        list.sort(new CountUsersChatComparator());


    }

    /**
     * сортировку чатов по названию по умолчанию
     */
    public static void alphabeticalNameOrderDefault(List<Chat> list) {
        list.sort(new NameChatComparator());
    }

    public static class NameChatComparator implements Comparator<Chat> {

        @Override
        public int compare(Chat o1, Chat o2) {

            return o1.getNameChat().compareTo(o2.getNameChat());

        }
    }

    /**
     * сортировка по убыванию по количеству пользователей,
     * а если это количество совпадает, то по названию в алфавитном порядке.
     */
    public static class CountUsersChatComparator implements Comparator<Chat> {

        @Override
        public int compare(Chat o1, Chat o2) {
            if (o1.getCountUsers() > o2.getCountUsers()) {
                return 1;
            } else if (o1.getCountUsers().equals(o2.getCountUsers())) {
                return o1.getNameChat().compareTo(o2.getNameChat());

            } else return -1;
        }

    }
}
