package database;

public class DatabaseManager {
    package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class DatabaseManager {
        private static final String URL = "jdbc:mysql://localhost:3306/animal_db";
        private static final String USER = "root";
        private static final String PASSWORD = "your_password";

        public DatabaseManager() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Сохранение животного в базу данных
        public void saveAnimal(String type, String name, int age, int weight, String color) {
            String query = "INSERT INTO animals (type, name, age, weight, color) VALUES (?, ?, ?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, type);
                stmt.setString(2, name);
                stmt.setInt(3, age);
                stmt.setInt(4, weight);
                stmt.setString(5, color);
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Получение всех животных из базы данных
        public List<String> getAllAnimals() {
            List<String> animals = new ArrayList<>();
            String query = "SELECT * FROM animals";

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    String type = rs.getString("type");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    int weight = rs.getInt("weight");
                    String color = rs.getString("color");

                    animals.add(String.format("Type: %s, Name: %s, Age: %d, Weight: %d, Color: %s", type, name, age, weight, color));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return animals;
        }

        // Фильтрация животных по типу
        public List<String> getAnimalsByType(String type) {
            List<String> animals = new ArrayList<>();
            String query = "SELECT * FROM animals WHERE type = ?";

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, type);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    int weight = rs.getInt("weight");
                    String color = rs.getString("color");

                    animals.add(String.format("Name: %s, Age: %d, Weight: %d, Color: %s", name, age, weight, color));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return animals;
        }

        // Обновление данных животного
        public void updateAnimal(int id, String name, int age, int weight, String color) {
            String query = "UPDATE animals SET name = ?, age = ?, weight = ?, color = ? WHERE id = ?";
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, name);
                stmt.setInt(2, age);
                stmt.setInt(3, weight);
                stmt.setString(4, color);
                stmt.setInt(5, id);
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
