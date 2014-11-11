package com.dyneinfo.pmdd.action;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.quartz.JobDetailBean;


public class RandomPrice {

	/**
	 * @param args
	 * @throws SchedulerException 
	 */
	public static void main(String[] args) throws SchedulerException {
		// TODO Auto-generated method stub
		 ClassPathResource res = new ClassPathResource( "applicationContext.xml" );
		  XmlBeanFactory factory = new XmlBeanFactory( res );
		  JobDetailBean job = ( JobDetailBean ) factory
		    .getBean( "randomPriceJob" );
		  CronTriggerBean trigger = ( CronTriggerBean ) factory
		    .getBean( "cronTrigger" );
		  Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler( );
		  scheduler.start( );
		  scheduler.scheduleJob( job, trigger );


	}

}
