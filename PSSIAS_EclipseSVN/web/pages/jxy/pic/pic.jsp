<%@ page contentType="text/html;charset=UTF-8"%><%@page
	import="java.io.*"%><%@page import="java.sql.Blob,java.util.*"%>
<%
	List list = (List) request.getAttribute("list");
	if (list != null) {
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
					sos.flush();
					sos.write(blobbytes, 0, bytesRead);
				}
				inStream.close();
			}
			sos.flush();
			sos.close();
			
			out.clear();
			out = pageContext.pushBody();
		}
	} else {
	}
%>