package com.coll.OnlineCollaborateBackEnd.dao;

import java.util.List;

import com.coll.OnlineCollaborateBackEnd.model.JobApplied;

public interface IJobAppliedDAO {
	List<JobApplied> list();
	List<JobApplied> list(int id);
	JobApplied getJobApplied(int id);
	boolean addJobApplied(JobApplied ja);
	boolean updateJobApplied(JobApplied ja);
	boolean deleteJobApplied(JobApplied ja);
}
