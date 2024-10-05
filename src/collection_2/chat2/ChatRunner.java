package collection_2.chat2;

import collection_2.chat2.entiti.Chat;
import collection_2.chat2.entiti.User;
import collection_2.chat2.util.ChatUtil;

import java.util.HashSet;
import java.util.Set;

public class ChatRunner {
    public static void main(String[] args) {
        User user1 = new User(1, "Serg", 12);
        User user2 = new User(2, "Max", 14);
        User user3 = new User(3, "Ivam", 18);
        User user4 = new User(4, "Bob", 19);
        User user5 = new User(5, "Stefan", 21);
        User user6 = new User(6, "Marsh", 32);
        User user7 = new User(7, "Rick", 42);
        User user8 = new User(8, "Morty", 15);
        User user9 = new User(9, "Emely", 20);
        User user10 = new User(10, "Jon", 25);
        User user11 = new User(11, "Mihail", 30);
        User user12 = new User(12, "Marta", 18);
        User user13 = new User(13, "Arnold", 17);
        User user14 = new User(14, "Sveta", 19);
        User user15 = new User(15, "Ira", 14);
        User user16 = new User(16, "Juli", 16);
        User user17 = new User(17, "Alex", 24);
        User user18 = new User(18, "Alik", 45);
        User user19 = new User(19, "Chester", 37);
        User user20 = new User(20, "Lincy", 17);

        Set<User> funStarWars = new HashSet<>();
        funStarWars.add(user1);
        funStarWars.add(user2);
        funStarWars.add(user3);
        funStarWars.add(user18);
        funStarWars.add(user20);

        Set<User> ufologists = new HashSet<>();
        ufologists.add(user4);
        ufologists.add(user5);
        ufologists.add(user6);
        ufologists.add(user19);
        Set<User> mimiPeople = new HashSet<>();
        mimiPeople.add(user7);
        mimiPeople.add(user8);
        mimiPeople.add(user9);
        mimiPeople.add(user10);
        mimiPeople.add(user11);
        Set<User> streetRacer = new HashSet<>();
        streetRacer.add(user12);
        streetRacer.add(user13);
        streetRacer.add(user14);
        streetRacer.add(user15);
        streetRacer.add(user16);
        streetRacer.add(user17);
        streetRacer.add(user10);

        Chat chat1 = new Chat("FunStarWars", funStarWars);
        Chat chat2 = new Chat("UFOlogists", ufologists);
        Chat chat3 = new Chat("MiniPeople", mimiPeople);
        Chat chat4 = new Chat("StreetRacer", streetRacer);

        Set<Chat> chatList = new HashSet<>();
        chatList.add(chat1);
        chatList.add(chat2);
        chatList.add(chat3);
        chatList.add(chat4);

        Set<User> users = ChatUtil.usersOverEighteen(chatList);
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println(ChatUtil.userAVGAgeUnderEighteen(chatList));

    }
}
