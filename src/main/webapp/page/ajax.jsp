<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ajax局部刷新</title>
 <!-- 使用ajax
   	      尽量使用 true 异步模式  （防假死）
                  尽量将获取数据之后的逻辑处理（页面渲染）放在回调函数中 -->
<script type="text/javascript">//每行的js语句结束后可以不写;号, js会根据换行判断
	/*
		封装发送ajax请求的函数 无刷新调用json地址  获取数据
		url 发送请求的地址
		方法类型  get或者post
		参数  通过 键=值&键=值 方式
		回调函数 当结果返回后 自动调用的函数 第一个参数就是返回的结果
		function（responseText）{
			具体的逻辑（页面渲染）
		}
	*/	
	function sendAjaxReq(url, methodType, param, retnFunction){
		//兼容所有浏览器,XHR对象，实现无刷新调用
		var xmlhttp;
		if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
		    xmlhttp=new XMLHttpRequest(); //IE5,IE6基本已经淘汰，所以不需要else也可以
		}
		else{// code for IE6, IE5
		    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function(){//回调的匿名函数,当请求发送收到结果后自动调用，函数名为=号左边字符串
			 /*一个ajax线程是否执行完成  可以通过回调函数 xmlhttp.onreadystatechange 是否执行完成来判断
	                                    存有 XMLHttpRequest的状态。readyState从 0 到 4 发生变化,默认值为0,只要状态发生变化就自动调用该匿名函数。
				0: 请求未初始化 (没有调用send方法)
				1: 服务器连接已建立 （socket已连接）
				2: 请求已接收  （获取到了参数 没有执行 action方法）
				3: 请求处理中  （已经在执行action方法 未执行完）
				4: 请求已完成，且响应已就绪 （已经响应 并且能获取到最终的数据）
	         status 响应的状态
	           200 成功
	        */
			if (xmlhttp.readyState == 4 && xmlhttp.status==200){
				//返回结果之后调用匿名函数
				retnFunction(xmlhttp.responseText);
			}
		};
		//open方法表示产生一个请求的关联
		//true 异步   多个线程同时执行 ,无法判断谁先执行  
		//false 同步   一次只允许一个线程执行, 页面可能会发生假死
		/* get提交
			xmlhttp.open("GET", "${pageContext.request.contextPath}/sa?seekContent=" + seekContent, true);
			xmlhttp.send();
		*/
		/*post提交
		    xmlhttp.open("POST", "${pageContext.request.contextPath}/sa", true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
			xmlhttp.send("seekContent="+seekContent);
	    */
		if(methodType == "get"){
			xmlhttp.open("GET", url + "?" + param, true);
			xmlhttp.send();
		}else{
			xmlhttp.open("POST", url, true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
			xmlhttp.send(param);
		}
	}
	function query(){
		var seekContent = document.getElementsByName("seek")[0].value;//获取文本框中的内容
		sendAjaxReq("${pageContext.request.contextPath}/qa", "get", "seekContent=" + seekContent,
			function(responseText){ //将数据通过dom方式添加到table中
				//返回字符串格式的json
			    var resultJson = responseText;
			    //转换为js对象
			    var resultObj = JSON.parse(resultJson);
			    //获取表格对象
			    var table = document.getElementById("myTable");
			    //将所有名字为dataTr的行全部删除
			    var allDataTr = document.getElementsByName("dataTr");
			    var length = allDataTr.length;
			    for ( var i = 0; i < length; i++) {
					table.removeChild(allDataTr[0]);//每次删除下标为0的tr
				}
			    //根据json的行数在表格中追加tr
			    for(var i = 0; i < resultObj.length; i++){
			    	var obj = resultObj[i];
			    	//<tr><td>"+obj.a_title+"</td><td>"+obj.a_content+"</td></tr>
			    	var td = document.createElement("td");//创建一个td
			    	td.innerText = obj.a_title;
			    	var td1 = document.createElement("td");
			    	td1.innerText = obj.a_content;
			    	var td2 = document.createElement("td");
			    	var db = document.createElement("button");//创建一个按钮
			    	var ub = document.createElement("button");
			    	db.innerText = "X";
			    	ub.innerText = "U";
			    	td2.appendChild(db);
			    	td2.appendChild(ub);
			    	var tr = document.createElement("tr");//创建一个tr
			    	db.article = obj;  //每次循环都把json对象与删除按钮中的变量绑定
			    	db.tr = tr;       //每次循环都把tr与删除按钮中的变量绑定
			    	ub.article = obj;  //每次循环都把json对象与修改按钮中的变量绑定
			    	//添加事件监听， click 单击触发事件
			    	db.addEventListener("click",
				    	function(){
				    		//删除当前行并 发送ajax请求到后台 删除数据库
				    		var eventSrc = event.srcElement;//获取按钮上的信息 
				    		table.removeChild(eventSrc.tr);
				    		sendAjaxReq("${pageContext.request.contextPath}/da/" + eventSrc.article.a_id, "POST", "_method=delete",
				    			function(responseText){
							        if(responseText==1){
							           alert("删除成功");
							        }else{
							           alert("删除失败");
							        }
			      				}
			      			);
			      		}
			    	);
			    	ub.addEventListener("click",
				    	function(){
				    		var eventSrc=event.srcElement;
					        document.getElementById('updateDiv').style.display='block';//显示div
					        document.getElementsByName("uTitle")[0].value=eventSrc.article.a_title;//赋值给div中的文本框
					        document.getElementsByName("uContent")[0].value=eventSrc.article.a_content;
					        document.getElementsByName("uId")[0].value=eventSrc.article.a_id;
			      		}
			    	);
			    	tr.setAttribute("name", "dataTr");//当前行的名字
			    	tr.appendChild(td);//tr追加一个td
			    	tr.appendChild(td1);
			    	tr.appendChild(td2);
			    	table.appendChild(tr);//表格中追加一个tr
			    }
			}
		);
	}
	//新增的方法
	function save() {
		var aTitle = document.getElementsByName("aTitle")[0].value;
		var aContent = document.getElementsByName("aContent")[0].value;
		sendAjaxReq("${pageContext.request.contextPath}/aa", "POST", "title=" + aTitle + "&content=" + aContent,
			function(responseText) {
				if (responseText == 1) {
					document.getElementById('addDiv').style.display = 'none';//隐藏div
					query();
					alert("新增成功");
				} else {
					alert("新增失败");
				}
			}
		);
	}
	//修改的方法
	function update() {
		var uId = document.getElementsByName("uId")[0].value;
		var uTitle = document.getElementsByName("uTitle")[0].value;
		var uContent = document.getElementsByName("uContent")[0].value;
		sendAjaxReq("${pageContext.request.contextPath}/ua/" + uId, "POST", "_method=put&title="
				+ uTitle + "&content=" + uContent, function(responseText) {
			if (responseText == 1) {
				document.getElementById('updateDiv').style.display = 'none';//隐藏div
				query();
				alert("修改成功");
			} else {
				alert("修改失败");
			}
		});
	}
</script> 
</head>
<body>
	百度知道 <input type="text" name="seek"></input><input type="button" value="搜索" onclick="query()"/>
	<input type='button' value="添加" onclick="document.getElementById('addDiv').style.display='block';">
	<table id="myTable">
		<tr><th width=20%>标题</th><th width=73%>内容</th><th width= 7%>操作</th></tr>
	</table>
</body>
  <!-- div名字,     风格                         隐藏                      位置 ：绝对定位                        左边 ：40%  上边:40%   最上层显示  -->
<div id="addDiv" style="display:none; position:absolute; left:40%; top:40%; z-index:100; border:1px solid black; width:250px; height:100px ">
	标题：<input type="text" name="aTitle"><br />
	内容：<input type="text" name="aContent"><br />
	<input type="button" value="保存" onclick="save()">&nbsp;&nbsp;&nbsp;
	<input type="button" value="关闭" onclick="document.getElementById('addDiv').style.display='none';"><br />
										<!-- 点击关闭按钮触发事件，隐藏该div -->
</div>
<div id="updateDiv"
	style="display:none; position:absolute; left:40%; top:40%; z-index:100; border:1px solid black; width:250px; height:100px ">
	<input type="hidden" name="uId">
	标题:<input type="text" name="uTitle"><br />
	内容:<input type="text" name="uContent"><br />
	<input type="button" value="修改" onclick="update()">&nbsp;&nbsp;&nbsp;
	<input type="button" value="关闭" onclick="document.getElementById('updateDiv').style.display='none';"><br />
									<!-- 点击关闭按钮触发事件，隐藏该div -->
</div>
</html>