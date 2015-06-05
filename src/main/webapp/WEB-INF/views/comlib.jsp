<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${ctx }/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx }/resources/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/bootstrap.min.js"></script>
</head>
<body>
<form method="post" action="${ctx }/kecheng/judge/${lessonBo.lessonId }/${lessonBo.teacherId }">
	<fieldset>
			<legend>我要评论</legend>
			<label>赞点or槽点</label>
				<input name="commentString" type="text" style="width:100%;height:60px;"/> 
			<!-- <span class="help-block">这里填写帮助信息.</span> 
			<label class="checkbox"> 
				<input type="checkbox" /> 
				勾选同意
			</label>--> 
			<div style="float:right;">
				评分
					<select name="score" >
						<option value="0">0</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				<button type="submit" class="btn">提交</button>
			</div>
		</fieldset>
</form> 
</body>
</html>