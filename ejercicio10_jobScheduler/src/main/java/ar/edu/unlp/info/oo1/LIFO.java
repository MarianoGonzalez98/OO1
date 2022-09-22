package ar.edu.unlp.info.oo1;

import java.util.List;

public class LIFO implements IStrategy{

	@Override
	public JobDescription next(List<JobDescription> jobs, JobScheduler scheduler) {
		JobDescription nextJob = jobs.get(jobs.size()-1);
		scheduler.unschedule(nextJob);
    	return nextJob;
	}

}
