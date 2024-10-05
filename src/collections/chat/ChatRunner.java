package collections.chat;

import collections.chat.util.ChatUtil;
import collections.chat.util.entiti.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatRunner {

    public static void main(String[] args) {
        Chat chat1 = new Chat("StreetRacer", 300);
        Chat chat2 = new Chat("Coder", 2000);
        Chat chat3 = new Chat("MiniPeople", 830);
        Chat chat4 = new Chat("UFOLog", 4000);
        Chat chat5 = new Chat("CCGamers", 3000);
        Chat chat6 = new Chat("TOWGamers", 7000);
        Chat chat7 = new Chat("PotterMans", 5000);
        Chat chat8 = new Chat("Scientologists", 6000);
        Chat chat9 = new Chat("FunStarWars", 6000);

        List<Chat> chats = new ArrayList<>();
        chats.add(chat1);
        chats.add(chat2);
        chats.add(chat3);
        chats.add(chat4);
        chats.add(chat5);
        chats.add(chat6);
        chats.add(chat7);
        chats.add(chat8);
        chats.add(chat9);
        ChatUtil.LengthChat(chats);
        ChatUtil.decreasingNumberUsers(chats);
        ChatUtil.alphabeticalNameOrderDefault(chats);
        ChatUtil.showChatList(chats);
    }
}
