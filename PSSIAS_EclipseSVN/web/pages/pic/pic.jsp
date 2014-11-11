<%@ page contentType="text/html;charset=UTF-8"%><%@page
	import="java.io.*"%><%@page import="java.sql.Blob,java.util.*"%>
<%
	List list = (List) request.getAttribute("list");
	if (list != null) {
		String path = request.getRealPath("images/spacer.gif");
		OutputStream os =  response.getOutputStream();
        FileInputStream is = null;   
		if(list.size()==0){
	       try {   
	           is = new FileInputStream(path);   
	           byte[] bytes = new byte[1024];   
	           int len = 0;   
	           while (-1 != (len = is.read(bytes))) {   
	               os.write(bytes, 0, len);   
	           }   
	          
	       } catch (IOException e) {   
	           e.printStackTrace();   
	       }   
		}else{
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				response.reset();
				response.setContentType("image/jpeg");
				ServletOutputStream sos = response.getOutputStream();
				byte[] bPhoto = (byte[]) results.get("PICTURE");
				if (bPhoto != null && bPhoto.length > 0) {
					InputStream inStream = new ByteArrayInputStream(bPhoto);
					int blobsize = (int) bPhoto.length;
					byte[] blobbytes = new byte[blobsize];
					int bytesRead = 0;
					while ((bytesRead = inStream.read(blobbytes)) != -1) {
						sos.write(blobbytes, 0, bytesRead);
					}
					inStream.close();
				}else{
					try {   
				           is = new FileInputStream(path);   
				           byte[] bytes = new byte[1024];   
				           int len = 0;   
				           while (-1 != (len = is.read(bytes))) {   
				               os.write(bytes, 0, len);   
				           }   
				          
				       } catch (IOException e) {   
				           e.printStackTrace();   
				       }   
				}
				sos.flush();
				sos.close();
				out.clear();
				out = pageContext.pushBody();
			}
		}
		 os.flush();   
         os.close();   
         out.clear();
		 out = pageContext.pushBody();  
		   
	} else {
		
	}
%>