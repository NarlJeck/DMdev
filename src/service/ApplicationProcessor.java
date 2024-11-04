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

    public static final File PATH_SECOND_FILE = Path.of("resources", "log2.txt").toFile();


    public static final int CLIENT_ID = 0;
    public static final int DATE_CRATE_CLIENT_REQUEST = 1;
    public static final int CLIENT_NUMBER_PHONE = 3;


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

        if (logFileCheck()) {
            String lineLogFile = list.get(list.size() - 1);
            String[] split = lineLogFile.split(",");
            String id = split[CLIENT_ID];
            String date = split[DATE_CRATE_CLIENT_REQUEST];
            String numberPhone = split[CLIENT_NUMBER_PHONE];
            outPutFileLogFormatted(id, date, numberPhone);

        } else {
            for (String lineLogFile : list) {
                String[] split = lineLogFile.split(",");
                String id = split[CLIENT_ID];
                String date = split[DATE_CRATE_CLIENT_REQUEST];
                String numberPhone = split[CLIENT_NUMBER_PHONE];
                outPutFileLogFormatted(id, date, numberPhone);
            }
        }


    }

    private static void outPutFileLogFormatted(String id, String date, String numberPhone) throws IOException {
        String dateFormatted = date.replaceAll(REGEX_DATE, REPLACE_DATE);
        String cleanPhone = numberPhone.replaceAll("\\+375", "");
        String numberFormatted = cleanPhone.replaceAll(REGEX_NUMBER, REPLACE_NUMBER_PHONE);
        Files.writeString(PATH_SECOND_FILE.toPath(), id + ", " + dateFormatted + ", " + numberFormatted + "\n", StandardOpenOption.APPEND);

    }

    private static boolean logFileCheck() throws IOException {
        if (!PATH_SECOND_FILE.exists()) {
            Files.write(PATH_SECOND_FILE.toPath(), Collections.EMPTY_LIST, StandardOpenOption.CREATE);
            return false;
        }
        return true;

    }


}






