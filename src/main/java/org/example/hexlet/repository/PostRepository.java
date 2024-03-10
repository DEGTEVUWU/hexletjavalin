package org.example.hexlet.repository;

import org.example.hexlet.model.Course;
import org.example.hexlet.model.Post;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.example.hexlet.repository.BaseRepository.dataSource;

public class PostRepository {
    private static List<Post> entities = new ArrayList<>();

    public static void save(Post post) throws SQLException {
        String sql = "INSERT INTO posts (name, body) VALUES (?, ?)";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, post.getName());
            preparedStatement.setString(2, post.getBody());
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            // Устанавливаем ID в сохраненную сущность
            if (generatedKeys.next()) {
                post.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<Post> find(Long id) throws SQLException {
        var sql = "SELECT * FROM posts WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var name = resultSet.getString("name");
                var body = resultSet.getString("body");
                Post post = new Post(name, body);
                post.setId(id);
                return Optional.of(post);
            }
            return Optional.empty();
        }
    }

    public static List<Post> getEntities() throws SQLException {
        var sql = "SELECT * FROM posts";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<Post>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var body = resultSet.getString("body");
                Post post = new Post(name, body);
                post.setId(id);
                result.add(post);
            }
            return result;
        }
    }

//    public static void save(Post post) {
//        post.setId((long) entities.size() + 1);
//        entities.add(post);
//    }

    public static List<Post> search(String term) {
        var posts = entities.stream()
                .filter(entity -> entity.getName().startsWith(term))
                .toList();
        return posts;
    }

//    public static Optional<Post> find(Long id) {
//        return entities.stream()
//                .filter(entity -> entity.getId().equals(id))
//                .findAny();
//    }

    public static Optional<Post> findByName(String name) {
        return entities.stream()
                .filter(entity -> entity.getName().equals(name))
                .findAny();
    }

    public static boolean existsByName(String name) {
        return entities.stream()
                .anyMatch(value -> value.getName().equals(name));
    }

//    public static List<Post> getEntities() {
//        return entities;
//    }

    public static void clear() {
        entities.clear();
    }
}
