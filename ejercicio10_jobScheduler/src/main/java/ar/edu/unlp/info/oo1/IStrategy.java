package ar.edu.unlp.info.oo1;

import java.util.List;

public interface IStrategy {
	public JobDescription next(List<JobDescription> jobs, JobScheduler scheduler);
}
