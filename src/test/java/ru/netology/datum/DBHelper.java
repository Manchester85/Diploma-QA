package ru.netology.datum;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import java.sql.DriverManager;

public class DBHelper {

    @SneakyThrows
    public static DataHelper.StatusPayment getStatus() {
        String statusSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1;";
        val runner = new QueryRunner();
        String status = null;
        try (
                val conn = DriverManager.getConnection(
                        System.getProperty("db.url"), System.getProperty("db.user"), System.getProperty("db.password"))

        ) {
            status = runner.query(conn, statusSQL, new ScalarHandler<>());
        }
        return new DataHelper.StatusPayment(status);
    }
}
