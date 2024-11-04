import service.ApplicationProcessor;
import util.CreateLog;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Реализовать эмулятор сервиса поддержки в Беларуси.
 * <p>
 * Все жалобы клиентов хранятся в хронологическом порядке в виде текстового лог-файла следующего формата (столбцы разделены через запятую):
 * <p>
 * - Порядковый номер клиента
 * - Дата и время звонка в ISO формате
 * - Фамилия и Имя клиента
 * - Телефон клиента
 * - Текст жалобы
 * <p>
 * Каждая новая жалоба идет с новой строки в лог-файле.
 * <p>
 * Например:
 * 1, 2021-09-13T10:15:30, Иванов Иван, +375 29 999 78 90, Не включается свет
 * 2, 2021-12-22T11:38:16, Петров Петр, +375257777765, Почему опять не работает интернет?
 * 3, 2021-12-28T06:55:24, Петров Петр, 333652193, Кто-то оборвал мне телефонный кабель
 * <p>
 * Задача:
 * С какой-то периодичностью (например, раз в 2 минуты) считывать все новые записи из лог-файла и отправлять их диспетчерам
 * для созвона с клиентами (ограничить количество диспетчеров, например, 2-3).
 * <p>
 * Созвон длится какое-то фиксированное время (например, 3-5 секунд), после чего он записывается в другой лог-файл в виде:
 * - Порядковый номер клиента с предыдущего лог файла
 * - Дата и время созвона
 * - Номер телефона клиента
 * <p>
 * Например:
 * 2, 2022-01-04 04:15, +375 (25) 777-77-65
 * 1, 2022-01-04 04:30, +375 (29) 999-78-90
 * 3, 2022-01-04 04:45, +375 (33) 365-21-93
 * <p>
 * Номера телефонов могут быть представлены по-разному, поэтому привести их к одному формату: +375 (29) 999-78-90.
 * <p>
 * * Желательно реализовать функционал добавления новых жалоб в конец лог-файла.
 */
public class RegularRunner {
    private static final File PATH_FIRST_FILE = Path.of("resources", "log.txt").toFile();

    public static void main(String[] args) throws IOException {
        Map<Integer, String> mapServiceRequest = CreateLog.createMapServiceRequest(10);

        //Создаем файл log запросов
        CreateLog.outputFileServiceRequest(PATH_FIRST_FILE, mapServiceRequest);
        // добавляем новый запрос в log
        CreateLog.addRecordInLogFile(PATH_FIRST_FILE, "Jeck", "Narel", 441115555, "Дождь");
        //Читаем log файл
        List<String> listLineLogFirst = ApplicationProcessor.readFirsFile(PATH_FIRST_FILE);
        //Создаем log2 - файл обработки запросов

        //ДОбавляем новую запись в log файл
        CreateLog.addRecordInLogFile(PATH_FIRST_FILE, "NER", "TRE", 339887744, "ВОДА");
        //Считываем log файл
        List<String> listLineLogFirst2 = ApplicationProcessor.readFirsFile(PATH_FIRST_FILE);
        //Добавляем запись в файл log2
        ApplicationProcessor.processingLogFile(listLineLogFirst2);


    }
}
