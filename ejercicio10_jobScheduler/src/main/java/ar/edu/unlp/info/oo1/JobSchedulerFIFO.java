package ar.edu.unlp.info.oo1;

public class JobSchedulerFIFO extends JobScheduler{

	@Override
	public JobDescription next() {
		JobDescription nextJob = jobs.get(0);
    	this.unschedule(nextJob);
    	return nextJob;
	}

}
