<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<s:if test="%{actionErrors != null && actionErrors.size > 0}">
	<div class="error">
		<s:iterator value="%{actionErrors}">
			<img src="${ctx}/images/iconWarning.gif" alt="Warning"/><s:property/><br/>
		</s:iterator>
	</div>
</s:if>


<div class="message">	
			<img src="${ctx}/images/iconInformation.gif" alt="Info"/>
            没有事故信息<br/>
</div>
