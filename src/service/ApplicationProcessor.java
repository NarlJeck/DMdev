package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationProcessor {
    public static final String REGEX_DATE = "(\\d{4}-\\d{2}-\\d{2})T(\\d{2}:\\d{2})(:\\d{2})Z";
    public static final String REPLACE_DATE = "$1 $2";
    public static final String REGEX_NUMBER = "\\s*(\\d{2})\\s?(\\d{3})(\\d{2})(\\d{2})";
    public static final String REPLACE_NUMBER_PHONE = "+375 ($1) $2-$3-$4";

    public static List<String> readFirsFile(File pathOfFileBeingRead) throws IOException {
        List<String> newList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader((pathOfFileBeingRead)))) {
            List<String[]> collect = reader.lines()
                    .map(string -> string.split("\n"))
                    .collect(Collectors.toList());
            for (String[] st : collect) {
                newList.addAll(List.of(st));
            }
            return newList;
        }

    }

    public static void processingLogFile(List<String> list) throws IOException {
        for (int i = 0; i < list.size(); i++) {
            String lineLogFile = list.get(i);
            String[] split = lineLogFile.split(",");
            String id = split[0];
            String date = split[1];
            String numberPhone = split[3];
            outPutFileLogFormatted(id, date, numberPhone);
        }

    }

    private static void outPutFileLogFormatted(String id, String date, String numberPhone) throws IOException {
        File pathFirstFile = Path.of("resources", "log2.txt").toFile();
        if (!pathFirstFile.exists()) {
            Files.write(pathFirstFile.toPath(), Collections.EMPTY_LIST, StandardOpenOption.CREATE);
        } else {
            String dateFormatted = date.replaceAll(REGEX_DATE, REPLACE_DATE);
            String cleanPhone = numberPhone.replaceAll("\\+375", "");
            String numberFormatted = cleanPhone.replaceAll(REGEX_NUMBER, REPLACE_NUMBER_PHONE);
            Files.writeString(pathFirstFile.toPath(), id + ", " + dateFormatted + ", " + numberFormatted + "\n", StandardOpenOption.APPEND);
        }
    }


}






