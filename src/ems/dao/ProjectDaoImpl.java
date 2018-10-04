package ems.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	private DataSource myDataSource;
	private JdbcTemplate jdbcTemplate; // implementing datasource and jdbctemplate

	@Autowired
	public void setDataSource(DataSource myDataSource) {
		this.myDataSource = myDataSource;
		this.jdbcTemplate = new JdbcTemplate(myDataSource);
	}
}
