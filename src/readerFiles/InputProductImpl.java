package readerFiles;

import entity.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class InputProductImpl implements InputProduct {

    private static final String ID = "ID";
    private static final String PRICE = "PRICE";
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final int READ_ID = 0;
    private static final int READ_PRICE = 1;
    private static final int READ_NAME = 1;
    private static final int READ_DESCRIPTION = 2;
    private static final int INVALID_NUMBER_WORDS_LINE = 1;

    @Override
    public Map<String, Product> readFirsFile(File pathOfFileBeingRead, File pathForFileError) throws IOException {
        Map<String, Product> productList = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader((pathOfFileBeingRead)))) {
            List<String[]> collect = reader.lines()
                    .map(string -> string.split("\n"))
                    .flatMap(string -> Arrays.stream(string)
                            .map(strings -> strings.split(",")))
                    .collect(Collectors.toList());
            getStringFirstFile(productList, collect, pathForFileError);
        }
        return productList;
    }

    @Override
    public  Map<String, Product> readSecondFile(File pathOfFileBeingRead, File pathForFileError) throws IOException {
        Map<String, Product> productList = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader((pathOfFileBeingRead)))) {
            List<String[]> collect = reader.lines()
                    .map(string -> string.split("\n"))
                    .flatMap(string -> Arrays.stream(string)
                            .map(strings -> strings.split(",")))
                    .collect(Collectors.toList());
            getStringSecondFile(productList, collect, pathForFileError.toPath());

        }
        return productList;

    }


    private static void getStringFirstFile(Map<String, Product> productList, List<String[]> collect, File pathForFileError) throws IOException {
        for (String[] productOfCollect : collect) {
            Product product = new Product();
            for (int i = 0; i < productOfCollect.length; i++) {
                if (productOfCollect.length == INVALID_NUMBER_WORDS_LINE) {
                    Files.write(pathForFileError.toPath(), Collections.singleton(productOfCollect[READ_ID]));
                } else if (!productOfCollect[i].contains(ID) || !productOfCollect[i].contains(PRICE)) {
                    product.setPrice(productOfCollect[READ_PRICE]);
                    product.setId((productOfCollect[READ_ID]));
                    productList.put((productOfCollect[READ_ID]), product);
                }
            }

        }
    }


    private static void getStringSecondFile(Map<String, Product> productList, List<String[]> collect, Path pathForFileError) throws IOException {
        for (String[] productOfCollect : collect) {
            Product product = new Product();
            for (int i = 0; i < productOfCollect.length; i++) {
                if (productOfCollect.length == INVALID_NUMBER_WORDS_LINE) {
                    Files.write(pathForFileError, Collections.singleton(productOfCollect[READ_ID]));
                } else if (!productOfCollect[i].contains(ID) || !productOfCollect[i].contains(NAME) || !productOfCollect[i].contains(DESCRIPTION)) {
                    product.setId((productOfCollect[READ_ID]));
                    product.setName(productOfCollect[READ_NAME]);
                    product.setDescription(productOfCollect[READ_DESCRIPTION]);
                    productList.put(productOfCollect[READ_ID], product);
                }
            }

        }
    }


}
