package cron;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.northout.service.CalserviceSoapBindingStub;

/**
 * Job Execution Class to perform task
 * 
 * @author northout
 *
 */
public class Job1 implements Job {

	// implement method execute of job
	public void execute(JobExecutionContext context) throws JobExecutionException {

		System.out.println("Web Service Job execution is started --->>> Time is " + new Date());

		java.net.URL endpointUrl = null;
		try {
			// Set the Web Service URL to invoke the service
			endpointUrl = new java.net.URL("http://localhost:8055/CalculatorService/services/Calservice");

			// instance of service class
			org.apache.axis.client.Service service = new org.apache.axis.client.Service();

			// configure endpointUrl and service object with Stud class Object
			CalserviceSoapBindingStub stud = new CalserviceSoapBindingStub(endpointUrl, service);

			int result;

			// invoke webservice add method with stud object
			result = stud.add(10, 10);
			System.out.println("Add Method Result" + result);

			int subResult = 0;

			// invoke webservice add method with stud object
			subResult = stud.sub(20, 10);

			System.out.println("Sub Method Result" + subResult);

		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
}