package pl.makuta.day_04.jdbc;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    private static final Logger logger = Logger.getLogger(BookDao.class);
    // ZAPYTANIA SQL
    private static final String CREATE_BOOK_QUERY = "INSERT INTO book(title,author,isbn) VALUES (?,?,?)";
    private static final String DELETE_BOOK_QUERY = "DELETE FROM book where id = ?";
    private static final String FIND_ALL_BOOKS_QUERY = "SELECT * FROM book";
    private static final String READ_BOOK_QUERY = "SELECT * from book where id = ?";
    private static final String UPDATE_BOOK_QUERY = "UPDATE book SET title = ? , author = ?, isbn = ? WHERE	id = ?";

    public static Book read(Integer bookId) {
        Book book = new Book();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_BOOK_QUERY);
        ) {
            statement.setInt(1, bookId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    book.setId(resultSet.getInt("id"));
                    book.setTitle(resultSet.getString("title"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setIsbn(resultSet.getInt("isbn"));
                }
            }
        } catch (Exception e) {
            logger.error("Błąd odczytu książki o id=" + bookId, e);
            e.getMessage();
        }
        return book;

    }

    public static List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_BOOKS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Book bookToAdd = new Book();
                bookToAdd.setId(resultSet.getInt("id"));
                bookToAdd.setTitle(resultSet.getString("title"));
                bookToAdd.setAuthor(resultSet.getString("author"));
                bookToAdd.setIsbn(resultSet.getInt("isbn"));
                bookList.add(bookToAdd);
            }
        } catch (SQLException e) {
            logger.error("Błąd odczytu wszystkich książek", e);
            e.getMessage();
        }
        return bookList;

    }

    public static Book create(Book book) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_BOOK_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, book.getTitle());
            insertStm.setString(2, book.getAuthor());
            insertStm.setInt(3, book.getIsbn());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                RuntimeException ex = new RuntimeException("Nie udało się utworzyć nowej książki");
                logger.error("Błąd tworzenia książki", ex);
                throw ex;
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    book.setId(generatedKeys.getInt(1));
                    return book;
                } else {
                    RuntimeException ex = new RuntimeException("Nie utworzono klucza dla książki");
                    logger.error("Błąd tworzenia książki", ex);
                    throw ex;
                }
            }
        } catch (Exception e) {
            logger.error("Błąd zapisu książki", e);
        }
        return null;
    }


    public static boolean delete(Integer bookId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BOOK_QUERY)) {

            statement.setInt(1, bookId);
            int resultsCount = statement.executeUpdate();
            return resultsCount == 1;
        } catch (Exception e) {
            logger.error("Błąd usunięcia książki", e);
            return false;
        }
    }

    public static void update(Book book) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK_QUERY);) {
            statement.setInt(4, book.getId());
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getIsbn());

            statement.executeUpdate();
        } catch (Exception e) {
            logger.error("Błąd aktualizacji książki", e);
        }
    }
}
