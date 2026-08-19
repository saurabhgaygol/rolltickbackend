package com.rolltick.rfidsetting.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RfidPartitionService {

    private final JdbcTemplate jdbcTemplate;

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy_MM_dd");

    public RfidPartitionService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createMissingPartitions() {

        // Database mein sabse purani partition ki date
        LocalDate firstDate = getLastPartitionDate();

        // Agar koi partition nahi mila
        if (firstDate == null) {
            System.out.println("No RFID partition found.");
            return;
        }

        LocalDate today = LocalDate.now();

        // First partition se aaj tak
        LocalDate date = firstDate;

        while (!date.isAfter(today)) {

            createPartition(date);

            date = date.plusDays(1);
        }

        // Kal ka partition bhi bana do
        createPartition(today.plusDays(1));

        System.out.println("RFID partitions checked successfully.");
    }


    private void createPartition(LocalDate date) {

        LocalDate nextDate = date.plusDays(1);

        String tableName =
                "rfid_attendance_" + date.format(FORMATTER);

        String sql = String.format("""
                CREATE TABLE IF NOT EXISTS %s
                PARTITION OF rfid_attendance
                FOR VALUES FROM ('%s 00:00:00')
                TO ('%s 00:00:00')
                """,
                tableName,
                date,
                nextDate
        );

        jdbcTemplate.execute(sql);

        System.out.println("Partition checked/created: " + tableName);
    }


    private LocalDate getLastPartitionDate() {

        String sql = """
                SELECT MAX(
                    to_date(
                        substring(tablename from 'rfid_attendance_(\\d{4}_\\d{2}_\\d{2})'),
                        'YYYY_MM_DD'
                    )
                )
                FROM pg_tables
                WHERE schemaname = 'public'
                AND tablename LIKE 'rfid_attendance_%'
                """;

        return jdbcTemplate.queryForObject(
                sql,
                LocalDate.class
        );
    }
}