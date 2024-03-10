package org.example.hexlet.repository;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;

import static org.example.hexlet.repository.BaseRepository.dataSource;

public class UserRepository {
    private static List<User> entities = new ArrayList<>();
    public static void save(User user) throws SQLException {
        String sql = "INSERT INTO users (name, lastName, email, password) VALUES (?, ?, ?, ?)";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());

            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            // Устанавливаем ID в сохраненную сущность
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<User> find(Long id) throws SQLException {
        var sql = "SELECT * FROM users WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var name = resultSet.getString("name");
                var lastName = resultSet.getString("lastName");
                var email = resultSet.getString("email");
                var password = resultSet.getString("password");
                User user = new User(name, lastName, email, password);
                user.setId(id);
                return Optional.of(user);
            }
            return Optional.empty();
        }
    }

    public static List<User> getEntities() throws SQLException {
        var sql = "SELECT * FROM users";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<User>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var lastName = resultSet.getString("lastName");
                var email = resultSet.getString("email");
                var password = resultSet.getString("password");

                User user = new User(name, lastName, email, password);
                user.setId(id);
                result.add(user);
            }
            return result;
        }
    }

//    public static void save(User user) {
//        user.setId((long) entities.size() + 1);
//        entities.add(user);
//    }

    public static List<User> search(String term) {
        List<User> users = entities.stream()
                .filter(entity -> entity.getName().startsWith(term))
                .toList();
        return users;
    }

//    public static Optional<User> find(Long id) {
//        Optional<User> user = entities.stream()
//                .filter(entity -> entity.getId().equals(id))
//                .findAny();
//        return user;
//    }
    public static User findByName(String name) {
        return entities.stream()
                .filter(entity -> entity.getName().equals(name))
                .findAny()
                .orElse(null);
    }

//    public static List<User> getEntities() {
//        return entities;
//    }

    public static void delete(Long id) {
        entities = entities.stream()
                .filter(user -> !user.getId().equals(id))
                .collect(Collectors.toList());
    }
}
