<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<body>

	<c:choose>
		<c:when test="${!empty greetings}">
			<c:forEach var="greeting" items="${greetings}" varStatus="status">

				<b><c:out value="${greeting.date}" /></b>,
         
                    <c:choose>
					<c:when test="${empty greeting.author}">
						<b>anonymous:</b>,
                        </c:when>
					<c:otherwise>
						<b><c:out value="${greeting.author.nickname}" /></b>,
                        </c:otherwise>
				</c:choose>
				<c:out value="${greeting.content}" />

			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>The guestbook has no messages.</p>
		</c:otherwise>
	</c:choose>

	<form action="/guestbook" method="post">
		<div>
			<input name="content" size="25" />
		</div>

		<div>
			<input type="submit" value="Post Greeting" />
		</div>
	</form>

</body>

</html>