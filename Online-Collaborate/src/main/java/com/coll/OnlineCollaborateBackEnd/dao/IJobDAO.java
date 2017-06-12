package com.coll.OnlineCollaborateBackEnd.dao;

import java.util.List;

import com.coll.OnlineCollaborateBackEnd.model.Job;

public interface IJobDAO {
	List<Job> list();
	List<Job> mainList();
	List<Job> list(String status);
	List<Job> getJobsByStatus(String status);
	List<Job> getUserJobs(int id);
	Job getJob(int id);
	boolean addJob(Job j);
	boolean updateJob(Job j);
	boolean deleteJob(Job j);
}
