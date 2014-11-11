<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="menuid" name="menuid" />






		    <tr class="crosscolor_tr">
               <td class="crosscolor_td">
			       <%=SsMenu.ALIAS_MENUNAME%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_MENUNAME}" key="menuname" value="%{model.menuname}" cssClass="max-length-50" required="false" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=SsMenu.ALIAS_MENUDESC%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_MENUDESC}" key="menudesc" value="%{model.menudesc}" cssClass="max-length-256" required="false" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
               <td class="crosscolor_td">
			       <%=SsMenu.ALIAS_MENULABEL%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_MENULABEL}" key="menulabel" value="%{model.menulabel}" cssClass="max-length-50" required="false" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=SsMenu.ALIAS_ISLEAF%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_ISLEAF}" key="isleaf" value="%{model.isleaf}" cssClass="max-length-50" required="false" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
               <td class="crosscolor_td">
			       <%=SsMenu.ALIAS_MENUURL%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_MENUURL}" key="menuurl" value="%{model.menuurl}" cssClass="max-length-50" required="false" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=SsMenu.ALIAS_MENULEVEL%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_MENULEVEL}" key="menulevel" value="%{model.menulevel}" cssClass="max-length-50" required="false" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
               <td class="crosscolor_td">
			       <%=SsMenu.ALIAS_ROOTID%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_ROOTID}" key="rootid" value="%{model.rootid}" cssClass="max-length-50" required="false" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=SsMenu.ALIAS_PARENTID%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_PARENTID}" key="parentid" value="%{model.parentid}" cssClass="validate-number " required="false" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
               <td class="crosscolor_td">
			       <%=SsMenu.ALIAS_IMAGEPATH%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_IMAGEPATH}" key="imagepath" value="%{model.imagepath}" cssClass="max-length-50" required="false" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=SsMenu.ALIAS_MENUSEQ%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_MENUSEQ}" key="menuseq" value="%{model.menuseq}" cssClass="max-length-50" required="false" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
               <td class="crosscolor_td">
			       <%=SsMenu.ALIAS_DISPLAYORDER%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_DISPLAYORDER}" key="displayorder" value="%{model.displayorder}" cssClass="validate-number " required="false" />
		       </td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
             </tr>
        
