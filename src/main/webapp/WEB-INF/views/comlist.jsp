<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
							评论
						</th>
						<th style="width:30%">
							时间
						</th>
						<th style="width:25%">
							赞
						</th>
					</tr>
				</thead>
				<tbody id="list">
					<c:forEach items="${commentBoList }" var="commentBo" >
					<tr class="success"><!-- success/warnign/info -->
						<!-- <td>
							${commentBo.commentCode }
						</td> -->
						<td>
							${commentBo.comment }
						</td>
						<td>
							${commentBo.writeTime }
						</td>
						<td>
							${commentBo.good }
							<button id="good${commentBo.commentId }" onclick="goodComment(${commentBo.commentId })" style="height: 30px;width: 45px;">
								<img style="width: 20px;/* margin-left:20px */" alt="赞" src="${ctx }/resources/img/like_1.jpg">
							</button>
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
<script type="text/javascript">
	function goodComment(commentId){
		$.ajax({
			url : "goodComment/"+commentId+"/true",
			type : "POST",  
			//contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
			dataType : "json",
			data : {
			},
			async : false,
			success : function(data) {
				var objdata = eval(data);
				if(objdata.status=="success"){
					//$.cookie("hasGood","");
					//lert($.cookie('hasGood'));
					//if($.cookie('hasGood')=="yes"){
					//	alert("不能重复点赞");
					//}else{
					//	alert($("#td"+commentId));
					//	var cookietime = new Date(); 
					//	cookietime.setTime(date.getTime() + (5 * 60 * 1000));//coockie保存一小时 
					//	$.cookie('hasGood', "yes",{expires:cookietime}); 
					//	alert("点赞成功");
						history.go(0);
					//}
				}else{
					alert("点赞失败");
				}	
			},
			error : function() {
				//alert("我不行了");
				history.go(0);
			}
		});
	};
</script>

</html>