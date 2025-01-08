package course.lesson6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppData {

    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void save(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Запись заголовка
            writer.write(String.join(";", header));
            writer.newLine();

            // Запись данных
            for (int[] row : data) {
                StringBuilder rowString = new StringBuilder();
                for (int i = 0; i < row.length; i++) {
                    rowString.append(row[i]);
                    if (i < row.length - 1) {
                        rowString.append(";");
                    }
                }
                writer.write(rowString.toString());
                writer.newLine();
            }
        }
    }

    public static AppData load(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Чтение заголовка
            String headerLine = reader.readLine();
            String[] header = headerLine.split(";");

            // Чтение данных
            String line;
            int[][] data = new int[100][header.length]; // Предполагаем максимальное количество строк
            int rowCount = 0;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");

                for (int i = 0; i < values.length; i++) {
                    data[rowCount][i] = Integer.parseInt(values[i].trim());
                }
                rowCount++;
            }

            // Уменьшаем размер массива данных до фактического количества строк
            int[][] actualData = new int[rowCount][header.length];
            for (int i = 0; i < rowCount; i++) {
                actualData[i] = data[i];
            }

            return new AppData(header, actualData);
        }
    }

    public class Main {
        public static void main(String[] args) {
            try {
                // Пример данных
                String[] header = {"value1", "value2", "value3"};
                int[][] data = {
                        {100, 200, 123},
                        {300, 400, 500}
                };

                AppData appData = new AppData(header, data);

                // Сохранение данных в файл
                appData.save("data.csv");

                // Загрузка данных из файла
                AppData loadedData = AppData.load("data.csv");

                // Пример вывода загруженных данных
                System.out.println("Header: " + String.join(", ", loadedData.header));
                for (int[] row : loadedData.data) {
                    StringBuilder rowData = new StringBuilder();
                    for (int value : row) {
                        rowData.append(value).append(" ");
                    }
                    System.out.println(rowData.toString().trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
