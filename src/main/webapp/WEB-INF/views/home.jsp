<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<div style="padding-top:10px;">
	<h3>A global community of friends and strangers spitting out their 
		inner-most and personal thoughts on the web for everyone else to see.
	</h3>
	<h4>Look at what these people are spitting right now...</h4>
	<ol class="spittle-list">
		<c:forEach var="spittle" items="${spittles}">
			<s:url value="/spitters/{spitterName}" var="spitter_url" >
				<s:param name="spitterName" value="${spittle.spitter.username}" />
			</s:url>
			<li>
				<span class="spittleListImage">
				</span>
					<span class="spittleListText">
						<a href="${spitter_url}"> 
						<c:out value="${spittle.spitter.username}" />
						</a> - <c:out value="${spittle.text}" /><br/>
				   <small><fmt:formatDate value="${spittle.when}" pattern="hh:mma MMM d, yyyy" /></small>
			   </span>
			</li>
		</c:forEach>
	</ol>
</div>
				
		
		