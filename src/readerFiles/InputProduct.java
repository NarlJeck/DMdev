package readerFiles;

import entity.Product;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface InputProduct {
     Map<String, Product> readFirsFile(File pathOfFileBeingRead, File pathForFileError) throws IOException;
     Map<String, Product> readSecondFile(File pathOfFileBeingRead, File pathForFileError) throws IOException;
}
