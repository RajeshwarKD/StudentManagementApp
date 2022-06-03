package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentData {

    public static boolean insertStudentDataToDB(Student st) {
        boolean answer = false;
        try {
            //jdbc code for insert student data in MySQL database
            Connection con = ConnectionProvider.createConnection();
            String query = "insert into students(sname, sphone, scity) values(?,?,?)";
            // PreparedStatement
            PreparedStatement pstmt = con.prepareStatement(query);
            // set the value of parameter
            pstmt.setString(1, st.getStudentName());
            pstmt.setString(2, st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());

            // execute..
            pstmt.executeUpdate();
            answer = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }

    public static boolean deleteStudentDataInBD(int studentId) {
        boolean answer = false;
        try {
            //jdbc code for delete student record in MySQL database
            Connection con = ConnectionProvider.createConnection();
            String query = "delete from students where sid=?";
            // PreparedStatement
            PreparedStatement pstmt = con.prepareStatement(query);
            // set the value of parameter
            pstmt.setInt(1, studentId);


            // execute..
            pstmt.executeUpdate();
            answer = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }

    public static void showAllStudentDataOfDB() {

        try {
            //jdbc code for show student database record from MySQL database
            Connection con = ConnectionProvider.createConnection();
            String query = "select * from students;";
            // CreateStatement
            Statement pstmt = con.createStatement();
            // set the value in ResultSet
            ResultSet set = pstmt.executeQuery(query);

            // execute..
            while (set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String phone = set.getString(3);
                String city = set.getString(4);

                System.out.println("ID :" + id);
                System.out.println("Name :" + name);
                System.out.println("Phone :" + phone);
                System.out.println("City :" + city);
                System.out.println("=======================================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean updateStudentDataInBD(Student updateStudent) {
        boolean answer = false;
            //jdbc code for update student record in MySQL database
        try {
            Connection con = ConnectionProvider.createConnection();
            String query = "update students set sname=?, sphone=?, scity=? where sid=?";
            // PreparedStatement
            PreparedStatement pstmt = con.prepareStatement(query);
            // set the value of parameter
            pstmt.setString(1, updateStudent.getStudentName());
            pstmt.setString(2,  updateStudent.getStudentPhone());
            pstmt.setString(3,  updateStudent.getStudentCity());
            pstmt.setInt(4, updateStudent.getStudentId());

            // execute..
            pstmt.executeUpdate();
            answer = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }
}