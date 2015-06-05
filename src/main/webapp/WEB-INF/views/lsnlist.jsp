<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<table class="table">
				<thead>
					<tr>
						<!-- <th style="width:10%">
							编号
						</th> -->
						<th style="width:45%">
							课程
						</th>
						<th style="width:30%">
							老师
						</th>
						<th style="width:25%">
							评分
						</th>
					</tr>
				</thead>
				<tbody id="list">
					<c:forEach items="${lessonBoList }" var="lessonBo" >
						<tr class="success"><!-- success/warnign/info -->
							<!-- <td>
								${lessonBo.lessonCode }
							</td> -->
							<td>
								<a href="kecheng/${lessonBo.lessonId }">
									${lessonBo.lessonName }
								</a>
							</td>
							<td>
								${lessonBo.teacherName }
							</td>
							<td>
								${lessonBo.score }
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="pagination">
			<ul style="width:100%">
					<li id="lastPage">
						<a >上一页</a>
					</li>
					<li id="nextPage">
						<a>下一页</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
</body>
</html>