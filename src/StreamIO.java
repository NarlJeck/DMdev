import entity.Product;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Даны два файла в формате CSV.
 * <p>
 * CSV (Comma-Separated Values) файл - это обычный текстовый файл, где через запятую (может использоваться и любой другой символ)
 * перечислены значения. Также может быть в первой строчке таких файлов заголовок с названием колонок.
 * <p>
 * Формат первого файла items-price.csv:
 * <p>
 * ID,PRICE
 * 1,9.98
 * 2,25.05
 * 3,16.45
 * <p>
 * Формат второго файла items-name.csv:
 * <p>
 * ID,NAME,DESCRIPTION
 * 1,Шарф,Теплый зимний шарф красного цвета
 * 2,Шапка,Вязаная зеленая шапка
 * 3,Ботинки,Осенние ботинки на толстой подошве
 * <p>
 * Задача:
 * <p>
 * Считать оба CSV файла и объединить их по полю ID в один result.csv, где будут следующие поля: ID,NAME,PRICE.
 * <p>
 * Желательно реализовать доп. функционал:
 * Если для каких-то ID не будет значений в обоих файлах, то записать их в один файл errors.csv, где будет лишь одно поле ID.
 */
public class StreamIO {

    public static void main(String[] args) throws IOException {

        File pathPrice = Path.of("resources", "items-price.csv").toFile();
        File pathName = Path.of("resources", "items-name.csv").toFile();
        Map<String, Product> integerProductMap = addFirstProductList(pathPrice);
        Map<String, Product> integerProductMap1 = addSecondProductList(pathName);
        Map<String, Product> newMap = createNewMap(integerProductMap, integerProductMap1);
        outPutFileProduct(newMap, Path.of("resources", "result.csv"));

        System.out.println(integerProductMap1);
    }

    private static Map<String, Product> addFirstProductList(File path) throws IOException {
        Map<String, Product> productList = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader((path)))) {
            List<String[]> collect = reader.lines()
                    .map(x -> x.split("\n"))
                    .flatMap(x -> Arrays.stream(x).map(y -> y.split(",")))
                    .collect(Collectors.toList());

            for (String a[] : collect) {
                Product product = new Product();
                for (int i = 0; i < a.length; i++) {
                    if (a.length == 1) {

                        Files.write(Path.of("resources", "errors.csv"), Collections.singleton(a[0]));
                    } else if (a[i].contains("ID") || a[i].contains("PRICE")) {

                    } else {
                        product.setPrice(Float.valueOf(a[1]));
                        product.setId((a[0]));
                        productList.put((a[0]), product);
                    }

                }
            }
        }
        return productList;
    }

    private static Map<String, Product> addSecondProductList(File path) throws IOException {
        Map<String, Product> productList = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader((path)))) {
            List<String[]> collect = reader.lines()
                    .map(x -> x.split("\n"))
                    .flatMap(x -> Arrays.stream(x).map(y -> y.split(",")))
                    .collect(Collectors.toList());

            for (String a[] : collect) {
                Product product = new Product();
                for (int i = 0; i < a.length; i++) {
                    if (a.length == 1) {

                        Files.write(Path.of("resources", "errors.csv"), Collections.singleton(a[0]));
                    } else if (a[i].contains("ID") || a[i].contains("NAME") || a[i].contains("DESCRIPTION")) {

                    } else {
                        product.setId((a[0]));
                        product.setName(a[1]);
                        product.setDescription(a[2]);
                        productList.put(a[0], product);
                    }

                }
            }
        }
        return productList;
    }

    public static Map<String, Product> createNewMap(Map<String, Product> firstProduct, Map<String, Product> secondProduct) throws IOException {
        Map<String, Product> newListProduct = new HashMap<>();
        for (Map.Entry<String, Product> entryProductList1 : firstProduct.entrySet()) {
            String key = entryProductList1.getKey();
            for (Map.Entry<String, Product> entryProductList2 : secondProduct.entrySet()) {
                String key2 = entryProductList2.getKey();
                if (key.equals(key2)) {
                    newListProduct.put(key, new Product(entryProductList2.getKey(), entryProductList1.getValue().getPrice(), entryProductList2.getValue().getName()));
                    break;
                }
            }
        }
        return newListProduct;
    }

    public static void outPutFileProduct(Map<String, Product> map, Path path) throws IOException {
        Files.write(path, Collections.singleton("ID    NAME    PRICE"));

        for (Map.Entry<String, Product> entryProductList1 : map.entrySet()) {
            Files.write(path, Collections.singleton(entryProductList1.getValue().getId() + "   " +
                    entryProductList1.getValue().getName() + "   " + entryProductList1.getValue().getPrice()), StandardOpenOption.APPEND);

        }
    }


}










