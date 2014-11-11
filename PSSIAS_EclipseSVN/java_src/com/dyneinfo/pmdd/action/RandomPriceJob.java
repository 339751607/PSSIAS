package com.dyneinfo.pmdd.action;

import org.apache.log4j.Category;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author shenshan
 * @version 1.0
 */
public class RandomPriceJob extends QuartzJobBean
{
 private static final Category cat = Category
            .getInstance( RandomPriceJob.class );

 private int      timeout;

 /**
  * @param timeout
  */
 public void setTimeout( int timeout )
 {
  this.timeout = timeout;
 }

 /*
  * (non-Javadoc)
  * 
  * @see org.springframework.scheduling.quartz.QuartzJobBean＃e xecuteInternal(org.quartz.JobExecutionContext)
  */
 protected void executeInternal( JobExecutionContext context )
   throws JobExecutionException
 {
    cat.debug( "Job start" );

  //执行具体操作

 }
}
