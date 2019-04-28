package com.example.demo;

import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;     
import com.example.demo.Project;    
import com.example.demo.ProjectDao; 

public class ProjectController {

	 @Autowired    
	    ProjectDao dao;//will inject dao from XML file    
	        
	    /*It displays a form to input data, here "command" is a reserved request attribute  
	     *which is used to display object data into form  
	     */    
	    @RequestMapping("/projectform")    
	    public String showform(Model m){    
	        m.addAttribute("command", new Project());  
	        return "projectform";   
	    }
	    
	    /*It saves object into database. The @ModelAttribute puts request data  
	     *  into model object. You need to mention RequestMethod.POST method   
	     *  because default request is GET*/    
	    @RequestMapping(value="/save",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("project") Project project){    
	        dao.save(project);    
	        return "redirect:/viewemp";//will redirect to viewemp request mapping    
	    }
	    
	    /* It provides list of employees in model object */    
	    @RequestMapping("/viewemp")    
	    public String viewemp(Model m){    
	        List<Project> list=dao.getProjects();    
	        m.addAttribute("list",list);  
	        return "viewemp";    
	    }
	    
	    
	
}
