package org.security.userdetails.jdbc;

import javax.servlet.*;
import javax.servlet.http.*;

public class SessionUserCount implements HttpSessionListener {
	   private static int count = 0;

	   public synchronized void sessionCreated(HttpSessionEvent se) {
	       count++;
	   }

	   public synchronized void sessionDestroyed(HttpSessionEvent se) {
		   if(count > 0){
	          count--;
		   }
	   }

	   public int getCount() {
	       return count;
	   }
}
