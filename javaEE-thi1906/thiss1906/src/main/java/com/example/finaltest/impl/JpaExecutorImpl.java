package com.example.finaltest.impl;/*Welcome to my show !

@author: NgKhanh
Date: 6/14/2023
Time: 7:10 PM

ProjectName: jpa_sem4*/

import com.example.finaltest.JpaExecutors;
import com.example.finaltest.annotation.Column;
import com.example.finaltest.annotation.Entity;
import com.example.finaltest.annotation.Id;
import com.example.finaltest.config.DBConnection;
import com.example.finaltest.entity.Employee;
import com.example.finaltest.utils.SelectQueryBuilder;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JpaExecutorImpl<T> implements JpaExecutors<T> {
    private Class<T> clazz;
    private String className;
    private String tableName;

    public JpaExecutorImpl(Class<T> clazz){
        this.clazz = clazz;
        this.className = clazz.getSimpleName();
        this.tableName = (clazz.getAnnotation(Entity.class) != null) ? clazz.getAnnotation(Entity.class).tablename() :
                this.className.toLowerCase();
    }

    public List<T> entityParser(ResultSet rs){
        List<T> entitys = new ArrayList<>();
        try {
            while(rs.next()){
                T entity = clazz.getDeclaredConstructor().newInstance();
                for(Field f : entity.getClass().getDeclaredFields()){
                    String columnName = f.getName();
                    if (f.isAnnotationPresent(Column.class) && !StringUtils.isEmpty(f.getAnnotation(Column.class).name())) {
                        Column columnInfo = f.getAnnotation(Column.class);
                        //todo: chưa lấy ra được id
                        columnName = columnInfo.name();
                        f.setAccessible(true);
                            switch (columnInfo.dataType()) {
                                case INTEGER:
                                    f.set(entity, rs.getInt(columnName));
                                    break;
                                case TEXT:
                                    f.set(entity, rs.getString(columnName));
                                    break;
                                case BIG_INTEGER:
                                    f.set(entity, rs.getInt(columnName));
                                    break;
                                case SMALL_INTEGER:
                                    f.set(entity, rs.getInt(columnName));
                                    break;
                                case DATE:
                                    f.set(entity, rs.getDate(columnName));
                                    break;
                                case FLOAT:
                                    f.set(entity, rs.getFloat(columnName));
                                    break;
                                case DOUBLE:
                                    f.set(entity, rs.getInt(columnName));
                                    break;
                                // todo : Làm tiếp tục với các kiểu dữ liệu còn lại
                                // fixme: Fix nốt đê
                        }
                    }
                    if (f.isAnnotationPresent(Id.class) && !StringUtils.isEmpty(f.getAnnotation(Id.class).name())){
                        Id id = f.getAnnotation(Id.class);
                        f.setAccessible(true);
                        f.set(entity, rs.getInt(id.name()));
                        System.err.println(entity);
                    }
                }
                entitys.add(entity);
            }
        }
        catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            throw new RuntimeException();
        }

        return entitys;
    }
    public List<T> findall(){
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(conn == null) {
            // todo: log
            System.err.println("Connection is null" + conn);
        } else {
            System.err.println(conn);
        }

        SelectQueryBuilder select = new SelectQueryBuilder(tableName);

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(select.getQuery());

            ResultSet rs = preparedStatement.executeQuery();
            //todo: serr query
            System.err.println(select.getQuery());
            return entityParser(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn!=null && !conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void createNew(String fullname, String birthDate, String position, String address, String department) throws SQLException {
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(conn == null) {
            // todo: log
            System.err.println("Connection is null" + conn);
        } else {
            System.err.println(conn);
        }

        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO employee(fullName, address, birthDay, position, department) VALUE("
                + "'" + fullname + "'" + "," + "'" + birthDate + "'" + "," + "'" + address + "'" + "," + "'" + position + "'" + "," + "'" + department + "'" + ")");

        preparedStatement.executeUpdate();
        System.out.println(preparedStatement);
    }
}
