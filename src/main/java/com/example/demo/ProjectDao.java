package com.example.demo;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    
import com.example.demo.Project;    

public class ProjectDao {
	
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	
	public int save(Project p){    
	    String sql="insert into Project(name,revenue) values('"+p.getName()+"',"+p.getRevenue()+"')";    
	    return template.update(sql);    
	}    
	
	public List<Project> getProjects(){    
	    return template.query("select * from Project",new RowMapper<Project>(){    
	        public Project mapRow(ResultSet rs, int row) throws SQLException {    
	            Project e=new Project();    
	            e.setId(rs.getInt(1));    
	            e.setName(rs.getString(2));    
	            e.setRevenue(rs.getFloat(3));
	            return e;    
	        }    
	    });    
	}    


}
