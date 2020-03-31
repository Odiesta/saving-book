package com.odiesta.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Iterator;

public class SavingData {

    public static final String DATABASE_NAME = "savingBook.db";
    public static final String TABLE_NAME = "savings";
    private static SavingData database = new SavingData();
    private ObservableList<Saving> savingList;
    private ObservableList<Saving> newSavingList;

    public SavingData() {

    }

    public static SavingData getDatabase() {
        return database;
    }

    public ObservableList<Saving> getSavingList() {
        return savingList;
    }

    public ObservableList<Saving> getNewSavingList() {
        return newSavingList;
    }

    public void load() {

        String url = "jdbc:sqlite:/home/odis/IdeaProjects/OdiestasBlog/SavingBook/src/" + DATABASE_NAME;
        savingList = FXCollections.observableArrayList();
        newSavingList = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(\n"
                    + "    date TEXT NOT NULL,\n"
                    + "    amountSaved INTEGER NOT NULL,\n"
                    + "    totalSaving INTEGER NOT NULL\n"
                    + ");";
            stmt.execute(createTable);

            String sql = "SELECT * FROM " + TABLE_NAME + ";";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Saving saving = new Saving();
                saving.setDate(rs.getString("date"));
                saving.setAmountSaved(rs.getLong("amountSaved"));
                saving.setTotalSaving(rs.getLong("totalSaving"));
                savingList.add(saving);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void save() {
        String url = "jdbc:sqlite:/home/odis/IdeaProjects/OdiestasBlog/SavingBook/src/" + DATABASE_NAME;
        // For windows start with the drive letter: \\C:\database-directory

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(\n"
                    + "    date TEXT NOT NULL,\n"
                    + "    amountSaved INTEGER NOT NULL,\n"
                    + "    totalSaving INTEGER NOT NULL\n"
                    + ");";
            stmt.execute(sql);

            Iterator<Saving> iterator = newSavingList.iterator();

            while (iterator.hasNext()) {
                Saving saving = iterator.next();
                String insert = "INSERT INTO " + TABLE_NAME + " (date, amountSaved, totalSaving) "
                        + "VALUES (?,?,?);";
                PreparedStatement pstmt = conn.prepareStatement(insert);
                pstmt.setString(1, saving.getDate());
                pstmt.setLong(2, saving.getAmountSaved());
                pstmt.setLong(3, saving.getTotalSaving());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addSaving(Saving saving) {
        if (saving != null) {
            savingList.add(saving);
            newSavingList.add(saving);
        } else {
            System.out.println("saving is null");
        }
    }

}
