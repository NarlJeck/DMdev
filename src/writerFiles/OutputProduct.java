package writerFiles;

import entity.Product;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Map;

public class OutputProduct {

    public static void outPutFileProduct(Map<String, Product> map, File pathResultFile) throws IOException {
        Files.write(pathResultFile.toPath(), Collections.singleton("ID    NAME    PRICE"));

        for (Map.Entry<String, Product> entryProductList1 : map.entrySet()) {
            Files.write(pathResultFile.toPath(), Collections.singleton(entryProductList1.getValue().getId() + "   " +
                    entryProductList1.getValue().getName() + "   " + entryProductList1.getValue().getPrice()), StandardOpenOption.APPEND);

        }
    }


}
