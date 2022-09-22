package ar.edu.unlp.info.oo1;

import java.util.List;

public class FIFO implements IStrategy{
	
	public JobDescription next(List<JobDescription> jobs, JobScheduler scheduler) {
		JobDescription nextJob = jobs.get(0);
    	scheduler.unschedule(nextJob);
    	return nextJob;
	}

}
