<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<div class="container">
		<form action="register" class="form-horizontal" method="post">
  			<div class="form-group">
   				<label class="control-label col-lg-2" for="name">프로젝트 이름</label>
   				<div  class="col-lg-10">
   					<input type="text" class="form-control" id="name" name="name">
   				</div>
  			</div>
  			<div class="form-group">
  				<label  class="control-label col-lg-2" for="content">프로젝트 내용</label>
 				<div class="col-lg-10">
 					<textarea class="form-control" rows="5" id="content" name="content"></textarea>
 				</div>	
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="start">시작날짜 </label>
				<div class="col-lg-10">
					<input type="date" id="start" name="start" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label  class="control-label col-lg-2" for="end">마감날짜 </label>
				<div class="col-lg-10">
					<input type="date" id="end" name="end" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label  class="control-label col-lg-2" for="state">상태 </label>
				<div class="col-lg-10">
					<select id="state" name="state" class="form-control">
						<option value="준비">준비</option>
						<option value="진행중">진행중</option>
						<option value="종료">종료</option>
						<option value="보류">보류</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<button type="submit" class="btn btn-success">저장</button>
  			 		<a href="${pageContext.request.contextPath }/"><button type="button" class="btn btn-danger">취소</button></a>
				</div>
			</div>
  			
		</form>
	</div>
</body>
</html>