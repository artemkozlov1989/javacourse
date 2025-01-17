package course_moodle.lesson6;
import java.io.*;
import java.util.Arrays;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void save(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // Записываем заголовок
            writer.println(String.join(";", header));

            // Записываем данные
            for (int[] row : data) {
                writer.println(Arrays.toString(row)
                        .replace("[", "")
                        .replace("]", "")
                        .replace(",", ";"));
            }

            System.out.println("Данные успешно сохранены в файл " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении данных в файл");
            e.printStackTrace();
        }
    }

    public void load(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Считываем заголовок
            header = reader.readLine().split(";");

            // Считываем данные
            String line;
            int linesCount = (int) reader.lines().count() + 1;
            data = new int[linesCount][header.length];
            reader.close();

            BufferedReader newReader = new BufferedReader(new FileReader(fileName));
            newReader.readLine(); // Пропускаем строку заголовка
            int i = 0;
            while ((line = newReader.readLine()) != null) {
                String[] values = line.split(";");
                for (int j = 0; j < values.length; j++) {
                    data[i][j] = Integer.parseInt(values[j].trim());
                }
                i++;
            }

            System.out.println("Данные успешно загружены из файла " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке данных из файла");
            e.printStackTrace();
        }
    }

    public void displayData() {
        System.out.println("Header: " + Arrays.toString(header));
        System.out.println("Data:");
        for (int[] row : data) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        String[] header = {"value1", "value2", "value3"};
        int[][] data = {{100, 200, 123}, {300, 400, 500}};

        AppData appData = new AppData(header, data);

        // Сохранение данных в CSV файл
        appData.save("data.csv");

        // Загрузка данных из CSV файла
        appData.load("data.csv");

        // Вывод данных
        appData.displayData();
    }
}
