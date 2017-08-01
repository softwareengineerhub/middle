package com.app;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by denys on 8/1/2017.
 */
public class JdbcPersonDao implements  PersonDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public String getNameById(int id) {
        return jdbcTemplate.queryForObject("SELECT name FROM persons WHERe id = ?", new Object[]{id}, String.class);
    }

    public int getAgeById(int id) {
        String sql = "SELECT age from persons WHERE id=:id";
        SqlParameterSource namParameterSource = new MapSqlParameterSource("id", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namParameterSource, Integer.class);
    }

    public List<Person> getAll() {
        String sql = "SELECT * from persons";
        return jdbcTemplate.query(sql, new PersonRowMapper());
    }

    public List<Person> getAllSimple() {
        try(Connection c = null){
            PreparedStatement ps = c.prepareStatement(" WHERE ID=?");
            ps.setString(1, "TEST");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){

            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
}
