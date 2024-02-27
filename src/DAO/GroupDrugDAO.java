package DAO;

import medicines.group_drug;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDrugDAO {
    private Connection connection;

    public GroupDrugDAO() {
        try {
            this.connection = DatabaseConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<group_drug> getAll() {
        List<group_drug> drugs = new ArrayList<>();
        String sql = "SELECT id, name, description FROM group_drug";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                group_drug drug = new group_drug(resultSet.getString("name"));
                drug.setId(resultSet.getInt("id"));
                drug.setDescription(resultSet.getString("description"));
                drugs.add(drug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drugs;
    }
    public void deleteById(int id) {
        String sql = "DELETE FROM group_drug WHERE ID = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insert(group_drug drug){
        String sql = "INSERT INTO group_drug (name, description) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, drug.getName());
            statement.setString(2, drug.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}