<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>프로젝트리스트</title>
<style>
	tr {
		cursor: pointer;
	}
</style>
</head>
<body>
<jsp:include page="header.jsp"/> 
<c:if test="${delete !=null }">
	<script>
		alert("${delete}");
	</script>
</c:if>

	<div class="container">
		<div class="row">
				<div class="col-lg-12 col-lg-offset-11">
			  <a href="register"><button type="button" class="btn btn-primary">새 프로젝트 등록</button></a>
		</div>	
		</div>
	  <table class="table table-hover">
    	<thead>
      		<tr>
        		<th>프로젝트 이름</th>
        		<th>시작날짜</th>
        		<th>종료날짜</th>
        		<th>상태</th>
      		</tr>
      	</thead>
      	<tbody>
      		<c:if test="${list.size()==0 }">
      			<tr>
      				<td colspan="4">프로젝드가 없습니다.</td>
      			</tr>
      		</c:if>
      		
      		<c:if test="${list.size()>0 }">
      			<c:forEach var="ProjectVo" items="${list }">
      				<tr>
      					<td><a href="read?pno=${ProjectVo.pno }&page=${cri.page}">${ProjectVo.name }</a></td>
      					<fmt:formatDate value="${ProjectVo.startdate }" pattern="yyyy-MM-dd" var="startdate"/>
      					<td>${startdate }</td>
      					<fmt:formatDate value="${ProjectVo.enddate }" pattern="yyyy-MM-dd" var="enddate"/>
      					<td>${enddate }</td>
      					<td>${ProjectVo.state }</td>
      				</tr>
      			</c:forEach>
      		</c:if>	 
    </tbody>
    
  </table>
  	<div class="box-footer">
		<div class="text-center">
			<ul class="pagination">
				<c:if test="${pageMaker.prev }">
					<li><a href="${pageContext.request.contextPath }/?page=${pageMaker.startPage-1 }">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
					<li ${pageMaker.cri.page == idx? 'class=active' : '' }><a href="${pageContext.request.contextPath }/?page=${idx }">${idx }</a></li>
				</c:forEach>
				<c:if test="${pageMaker.next }">
					<li><a href="${pageContext.request.contextPath }/?page=${pageMaker.endPage+1 }">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
						
	</div>
  
</div>
</body>
</html>
