package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class CreateLog {
    private static final int TIME_FIRST_ENTRY = 1609999999;
    private static final int TIME_LAST_ENTRY = 1729999999;

    private static final int LOWER_LIMIT_PHONE_NUMBER = 1000000;
    private static final int UPPER_LIMIT_PHONE_NUMBER = 9999999;


    public static Integer numberRecord = 0;
    public static Random random = new Random();
    public static Map<Integer, String> listServiceRequest = new HashMap<>();


    public static String createComplain() {
        List<String> complaints = new ArrayList<>();
        complaints.add("Пропал свет");
        complaints.add("Не работает лифт");
        complaints.add("Нет горячей воды");
        complaints.add("Прорвало трубу");
        complaints.add("Сломана дверь в подъезде");
        complaints.add("В подъезде разбита лампочка");
        complaints.add("Пропал свет");
        complaints.add("Забит мусорапровод");

        int numberComplain = random.nextInt(complaints.size() - 1) + 1;
        return complaints.get(numberComplain);
    }

    public static String createName() {
        List<String> names = new ArrayList<>();
        names.add("Иван");
        names.add("Сергей");
        names.add("Алексей");
        names.add("Александр");
        names.add("Павел");
        names.add("Дмитрий");
        names.add("Игорь");
        names.add("Максим");
        names.add("Андрей");
        names.add("Матвей");
        names.add("Иван");
        int numberName = random.nextInt(names.size() - 1) + 1;

        return names.get(numberName);
    }

    public static String createLastName() {
        List<String> lastNames = new ArrayList<>();
        lastNames.add("Шах");
        lastNames.add("Воробей");
        lastNames.add("Низкий");
        lastNames.add("Родионов");
        lastNames.add("Голяс");
        lastNames.add("Харланчук");
        lastNames.add("Пупин");
        lastNames.add("Паученок");
        lastNames.add("Котов");
        lastNames.add("Медведь");
        lastNames.add("Емец");
        int numberLastName = random.nextInt(lastNames.size() - 1) + 1;
        return lastNames.get(numberLastName);
    }

    public static String createNumberPhone() {
        List<String> codNumberPhones = new ArrayList<>();
        codNumberPhones.add("29");
        codNumberPhones.add("29");
        codNumberPhones.add("33");
        codNumberPhones.add("25");
        codNumberPhones.add("44");
        codNumberPhones.add("+37544");
        codNumberPhones.add("+37525");
        codNumberPhones.add("+37529");
        codNumberPhones.add("+37533");
        codNumberPhones.add("+375 44 ");
        codNumberPhones.add("+375 29 ");
        codNumberPhones.add("+375 33 ");
        codNumberPhones.add("+375 25 ");
        int numberCod = random.nextInt(codNumberPhones.size() - 1) + 1;
        int numberPhone = random.nextInt(UPPER_LIMIT_PHONE_NUMBER - LOWER_LIMIT_PHONE_NUMBER) + LOWER_LIMIT_PHONE_NUMBER;
        return codNumberPhones.get(numberCod) + numberPhone;
    }

    public static String createDate() {
        int dateNano = random.nextInt(TIME_LAST_ENTRY - TIME_FIRST_ENTRY) + TIME_FIRST_ENTRY;
        Instant instant = Instant.ofEpochSecond(dateNano);
        return String.valueOf(instant);
    }

    public static Map<Integer, String> createMapServiceRequest(Integer numberRecords) {
        for (int i = 0; i < numberRecords; i++) {
            numberRecord++;
            String date = createDate();
            String name = createName();
            String lastName = createLastName();
            String numberPhone = createNumberPhone();
            String complain = createComplain();
            listServiceRequest.put(numberRecord, numberRecord + ", " + date + ", " + name + " " + lastName +
                    ", " + numberPhone + ", " + complain);
        }
        return listServiceRequest;

    }

    public static void outputFileServiceRequest(File file, Map<Integer, String> listServiceRequest) throws IOException {
        if (file.exists()) {
            Files.write(file.toPath(), Collections.EMPTY_LIST, StandardOpenOption.DELETE_ON_CLOSE);
            Files.write(file.toPath(), Collections.EMPTY_LIST, StandardOpenOption.CREATE);

        } else if (!file.exists()) {
            Files.write(file.toPath(), Collections.EMPTY_LIST, StandardOpenOption.CREATE);
        }
        for (Map.Entry<Integer, String> entryComplain : listServiceRequest.entrySet()) {

            Files.write(file.toPath(), Collections.singleton(entryComplain.getValue()), StandardOpenOption.APPEND);

        }

    }

    public static void addRecordInLogFile(File file, String name, String lastName, int numberPhone, String complain) throws IOException {
        listServiceRequest.put(listServiceRequest.size() + 1, listServiceRequest.size() + 1 + ", " +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + ", " +
                name + " " + lastName + ", " + numberPhone + ", " + complain);
        String newRecord = listServiceRequest.get(listServiceRequest.size());

        Files.writeString(file.toPath(), newRecord + "\n", StandardOpenOption.APPEND);
    }


}

