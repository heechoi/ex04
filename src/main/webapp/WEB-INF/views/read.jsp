<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<c:if test="${modify !=null }">
	<script>
		alert("${modify}");
	</script>
</c:if>
	<div class="container">
		<form class="form-horizontal">
  			<div class="form-group">
   				<label class="control-label col-lg-2" for="name">프로젝트 이름</label>
   				<div  class="col-lg-10">
   					<input type="text" class="form-control" id="name" name="name" value="${project.name }" readonly="readonly">
   				</div>
  			</div>
  			<div class="form-group">
  				<label  class="control-label col-lg-2" for="content">프로젝트 내용</label>
 				<div class="col-lg-10">
 					<textarea class="form-control" rows="5" id="content" name="content" readonly="readonly">${project.content }</textarea>
 				</div>	
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="start">시작날짜 </label>
				<div class="col-lg-10">
					<fmt:formatDate value="${project.startdate }" pattern="yyyy-MM-dd" var="startdate"/>
					<input type="date" id="start" name="start" class="form-control" value=${startdate } readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label  class="control-label col-lg-2" for="end">마감날짜 </label>
				<div class="col-lg-10">
				<fmt:formatDate value="${project.enddate }" pattern="yyyy-MM-dd" var="enddate"/>
					<input type="date" id="end" name="end" class="form-control" value="${enddate }" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label  class="control-label col-lg-2" for="state">상태 </label>
				<div class="col-lg-10">
					<select id="state" name="state" class="form-control" disabled="disabled">
						<option value="준비">준비</option>
						<option value="진행중">진행중</option>
						<option value="종료">종료</option>
						<option value="보류">보류</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<a href="modify?pno=${project.pno}&page=${cri.page}"><button type="button" class="btn btn-info">수정</button></a>
					<button type="button" class="btn btn-danger" id="removeBtn">삭제</button>
  			 		<a href="${pageContext.request.contextPath }/?page=${cri.page}"><button type="button" class="btn btn-warning">되돌아가기</button></a>
				</div>
			</div>
  			
		</form>
	</div>
	<script>
		$("#state").val("${project.state}");
		$("#removeBtn").click(function(){
			
			if(confirm("삭제하시겠습니까?")){
				location.href="remove?pno=${project.pno}";
			}
		})
	</script>
</body>
</html>