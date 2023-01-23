package com.patikadev.Model;

import com.patikadev.Helper.DBConnetor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Patika {

    private int id;
    private String name;

    public Patika(){};
    public Patika(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<Patika> getList(){
        ArrayList<Patika> patikaList = new ArrayList<>();
        String query = "SELECT * FROM patika";
        Patika obj;
        try {
            Statement st = DBConnetor.getInstance().createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()){
                obj = new Patika();
                obj.setId(resultSet.getInt("id"));
                obj.setName(resultSet.getString("name"));

                patikaList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patikaList;
    }

    public static boolean add(String name){
        String query = "INSERT INTO patika (name) VALUES (?)";
        try {
            PreparedStatement preparedStatement = DBConnetor.getInstance().prepareStatement(query);
            preparedStatement.setString(1,name);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean update(int id , String name){
        String query = "UPDATE patika SET name = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = DBConnetor.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }


    public static Patika getFetch(int id){
        String query = "SELECT * FROM patika WHERE id = ?";
        Patika obj = null;
        try {
            PreparedStatement pr = DBConnetor.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet resultSet = pr.executeQuery();
            if (resultSet.next()){
                obj = new Patika(resultSet.getInt("id"), resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }


    public static boolean delete(int id){
        String query = "DELETE FROM patika WHERE id = ?";
        ArrayList<Course> courses = Course.getList();
        for (Course obj: courses) {
            if (obj.getPatika().getId() == id){
                Course.delete(obj.getId());
            }
            
        }
        try {
            PreparedStatement preparedStatement = DBConnetor.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
