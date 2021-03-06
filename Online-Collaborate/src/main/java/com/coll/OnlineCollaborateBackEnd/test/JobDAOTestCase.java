package com.coll.OnlineCollaborateBackEnd.test;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.*;
import com.coll.OnlineCollaborateBackEnd.dao.IJobAppliedDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IJobDAO;
import com.coll.OnlineCollaborateBackEnd.model.Job;
import com.coll.OnlineCollaborateBackEnd.model.JobApplied;

public class JobDAOTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static IJobDAO jobDAO;
	private static Job job;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.coll.OnlineCollaborateBackEnd");
		context.refresh();
		
		jobDAO=(IJobDAO)context.getBean("jobDAO");
		job=(Job)context.getBean("job");
	}
	
	/*@Test
	public void addJobTest() {
		
		job.setId(1);
		job.setCompanyName("AP Digital LLC");
		job.setSubTitle("PHP web developer");
		job.setAbout("We are looking for PHP web developer for our newly startup digital marketing company. Applicant must have experience in his field and have to knowledge about:....");
		job.setJobProfile("Jr Software Developer");
		job.setQualification("Xth : 75% + XIIth with science: 75% Graduated in Computer Engineering with 60%+ 2 years of experience at least");
		job.setContactInfo("Send your resume to following address: 8, Balaji Estate Guru Ravidas Mark, Kalkaji "
				+ "Contact Number : 9330001411 email id : lmb@gmail.com");
		job.setPostDate(LocalDate.parse("2017-06-07"));
		job.setStatus("APPROVED");
		assertEquals("Successfully added a job inside the table!",true, jobDAO.addJob(job));
	}*/
	
	/*@Test
	public void updateJob() {
		job = jobDAO.getJob(2);
		job.setJobProfile("Software Developer");
		
		assertEquals("Successfully updated a job inside the table!",true, jobDAO.updateJob(job));
	}*/
	
	/*@Test
	public void getAllJobsTestCase() {
		int size = jobDAO.list().size();
		
		assertEquals(1, size);
		
	}*/
	
	/*@Test
	public void deleteJob() {
		job = jobDAO.getJob(1);
		
		assertEquals("Successfully deleted a job from the table!",true, jobDAO.deleteJob(job));
	}*/
	
}
