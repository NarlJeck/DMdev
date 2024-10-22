import entity.Product;
import service.MergerMapsProduct;
import writerFiles.OutputProduct;
import readerFiles.InputProduct;
import readerFiles.InputProductImpl;

import java.io.*;
import java.nio.file.Path;
import java.util.Map;

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
public class RunnerIO {

    public static void main(String[] args) throws IOException {

        File pathFirstFile = Path.of("resources", "items-price.csv").toFile();
        File pathSecondFile = Path.of("resources", "items-name.csv").toFile();
        File pathFileError = Path.of("resources", "errors.csv").toFile();
        File pathResultFile = Path.of("resources", "result.csv").toFile();

        InputProduct inputProduct = new InputProductImpl();
        Map<String, Product> firstMapProduct = inputProduct.readFirsFile(pathFirstFile, pathFileError);
        Map<String, Product> secondMapProduct = inputProduct.readSecondFile(pathSecondFile, pathFileError);
        Map<String, Product> newMapProduct = MergerMapsProduct.createNewMap(firstMapProduct, secondMapProduct);
        OutputProduct.outPutFileProduct(newMapProduct,pathResultFile);


    }










}










