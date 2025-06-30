package jdbc;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class MySQLSSHConnection {

    public static void main(String[] args) {
        String sshHost = "213.230.125.214";
        int sshPort = 22;
        String sshUser = "root";
        String sshPassword = "6887546!@#$Mmm";

        String remoteHost = "localhost";
        int remotePort = 3306;
        int localPort = 3307; // Biz ochadigan tunnel uchun mahalliy port

        String dbUser = "root";
        String dbPassword = "6887546!@#$Mmm";
        String dbName = "echat";

        Session session = null;

        try {
            // 1. SSH tunnel ochamiz
            JSch jsch = new JSch();
            session = jsch.getSession(sshUser, sshHost, sshPort);
            session.setPassword(sshPassword);

            // Xavfsiz ulanishni tasdiqlash uchun:
            session.setConfig("StrictHostKeyChecking", "no");

            // Ulash
            session.connect();

            // SSH tunnel orqali ulanish uchun portni 'forward' qilamiz
            session.setPortForwardingL(localPort, remoteHost, remotePort);
            System.out.println("SSH tunnel o'rnatildi.");

            // 2. MySQL bazasiga JDBC orqali ulanamiz (SSH tunnel orqali)
            String jdbcUrl = "jdbc:mysql://localhost:" + localPort + "/" + dbName;
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            System.out.println("Ma'lumotlar bazasiga muvaffaqiyatli ulandik!");

            // SQL so'rov bajarish
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM table_name");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }

            // Yopamiz
            resultSet.close();
            statement.close();
            connection.close();
            session.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

