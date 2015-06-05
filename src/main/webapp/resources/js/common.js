/**
 * 
 */
var page = 1;
$(function(){
//	alert("loading common.js");
	$("#search").bind("click",function(){
		searchText = $("#searchText").val();
		if(title=="kecheng"){
			window.location.href="higher?searchText="+searchText;
		}else{
			url = "vagueSearch";
			ajaxLesson(url,page,searchText);
		}
	});
	$("#lastPage").bind("click",function(){
		if((page--)<=0) {
			page = 1;
			alert("这已经是第一页了！");
			return true;
		};
		//alert(page);
		if(title=="kecheng"){
			ajaxComment(url,page);
		}else {
			ajaxLesson(url,page,searchText);
		}
	});
	$("#nextPage").bind("click",function(){
		page = page + 1;
		//alert(page);
		if(title=="kecheng"){
			//alert(url);
			ajaxComment(url,page);
		}else {
			//alert(url);
			ajaxLesson(url,page,searchText);
		}
	});
});
	function ajaxLesson(toUrl,toPage,toSearchText){
		$.ajax({
			url : toUrl+"/"+toPage,
			type : "POST",  
			contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
			dataType : "json",
			data : {
				"vagueString":toSearchText
			},
			async : false,
			success : function(data) {
				var objdata = eval(data);
				if(objdata.errorCode=="10007"||"10001"||"10003"||"10005"){
					//alert(objdata.message);
					var objLesson = eval(objdata.params.lessonBoList);
					//alert(objLesson[1].lessonName);
					var text = "";
					if(objLesson.length<=0){
						alert("查询不到该课程或老师");
					}else{
						$("#list").html("");
						for(var i=0;i<objLesson.length;i++){
							text +="<tr class='success'><!-- success/warnign/info -->";
									//+"<td>"+ objLesson[i].lessonCode +"</td>";	
							text +="<td>"+
										"<a href='kecheng/"+ objLesson[i].lessonId+"'>"+
										objLesson[i].lessonName+"</a>"+
									"</td>";
							text += "<td>"+objLesson[i].teacherName+"</td>"+
									"<td>"+objLesson[i].score+"</td>"+
								"</tr>";
						}
						//alert(text);
						//alert("text ready");
						$("#list").append(text);
					}
					//alert("Ok");
				}else{
					alert("查询失败");	
				}
				
			},
			error : function() {
				if(title=="home"){
					//alert("就这么多了");
				}else{
					alert("我不行了");
				}
			}
		});
	}
	
	function ajaxComment(toUrl,toPage){
		$.ajax({
			url : toUrl+"/"+toPage,
			type : "POST",  
			contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
			dataType : "json",
			data : {
			},
			async : false,
			success : function(data) {
				var objdata = eval(data);
				if(objdata.errorCode=="10009"){
					//alert(objdata.message);
					var text = "";
					var objComment = eval(objdata.params.commentBoList);
					if(objComment.length<=0){
						alert("这是最后一页了！");
						page--;
					}else{
						$("#list").html("");
						for(var i=0;i<objComment.length;i++){
							text +="<tr class='success'><!-- success/warnign/info -->";
									//+"<td>"+ objComment[i].commentCode +"</td>";	
							text +="<td>"+
										objComment[i].comment+
									"</td>";
							text += "<td>"+objComment[i].writeTime+"</td>"+
									"<td>"+objComment[i].good+"</td>"+
									"<td>"+objComment[i].good+"<button id=\""+objComment[i].commentId+"\"onclick=goodComment("+objComment[i].commentId+")\"" +
											" style=\"height: 30px;width: 45px;\">"+
											"<img style=\"width: 20px;\" alt=\"赞\" src=\"../resources/img/like_1.jpg\">"+
										"</button>"+
									"</td>"
								"</tr>";
						}
					//alert(text);
					//alert("text ready");
					$("#list").append(text);
					}
					//alert("Ok");
				}else{
					alert("查询失败");	
				}
				
			},
			error : function() {
				alert("我不行了");
			}
		});
	}
