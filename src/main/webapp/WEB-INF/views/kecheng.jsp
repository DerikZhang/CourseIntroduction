<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>kecheng</title>
<script type="text/javascript">
	var title = "kecheng";
	var url = "getComment/"+${lessonBo.lessonId};
	var searchText="";
	//alert("${message}");
	//$("#searchText").value=${searchText };
</script>
</head>
<body>

<%@ include file="taglibs.jsp"%>
<div class="row-fluid">
		<div class="span12">
			<blockquote>
				<h3>
					${lessonBo.lessonName }
				</h3>老师： <cite>${lessonBo.teacherName }</cite>
				<label>评分：${lessonBo.score }</label>
			</blockquote>
		</div>
	</div>
<%@ include file="comlist.jsp"%>
<%@ include file="comlib.jsp"%>
</body>
<script type="text/javascript">
	$("#searchDiv").html("");
</script>
<script type="text/javascript" src="${ctx }/resources/js/common.js"></script>

</html>