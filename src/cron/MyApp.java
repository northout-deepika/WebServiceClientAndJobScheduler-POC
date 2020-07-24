package cron;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * MyApp for Invoke the job 
 * @author northout
 *
 */
public class MyApp {


	public static void main(String[] args) {
		try {
			
			//instance of the Job using the JobDetail class
			JobDetail job1 = JobBuilder.newJob(Job1.class).withIdentity("job1", "group1").build();

			//instance of the Trigger using the TriggerBuilder class and schedule cron expression with cronSchedule
			Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("cronTrigger1", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();

			//instance of the Scheduler using the StdSchedulerFactory class
			Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
			
			//Start the thread
			scheduler1.start();
			
			//Fire the execution of job
			scheduler1.scheduleJob(job1, trigger1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}