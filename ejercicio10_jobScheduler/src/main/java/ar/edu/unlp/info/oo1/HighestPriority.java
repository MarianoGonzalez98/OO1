package ar.edu.unlp.info.oo1;

import java.util.List;

public class HighestPriority implements IStrategy{

	@Override
	public JobDescription next(List<JobDescription> jobs, JobScheduler scheduler) {
		JobDescription nextJob = jobs.stream()
			.max((j1,j2) -> Double.compare(j1.getPriority(), j2.getPriority()))
			.orElse(null);
		scheduler.unschedule(nextJob);
    	return nextJob;
	}

}
