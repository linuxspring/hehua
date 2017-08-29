<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/> 
      <meta name="viewport" content="width=device-width, initial-scale=1"/>
      <meta http-equiv="x-ua-compatible" content="ie=edge"/>
      <script src="ref/bootstrap3/dist/js/jquery.min.js"></script>
      <script src="ref/bootstrap3/dist/js/bootstrap.js"></script>
<link rel="stylesheet" href="ref/bootstrap3/dist/css/bootstrap.css"/> 
<link rel="stylesheet" href="ref/bootstrap3/dist/css1/bootstrap.min.css"/>  
<title>系统功能主页面</title>
</head>
 <style type="text/css">
html,body {
	height: 100%;
}
.box {
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6699FF', endColorstr='#6699FF'); /*  IE */
	background-image:linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-o-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-moz-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-webkit-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-ms-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	
	margin: 0 auto;
	position: relative;
	width: 100%;
	height: 100%;
}
.login-box {
	width: 100%;
	max-width:500px;
	height: 500px;
	position: absolute;
	top: 50%;

	margin-top:-250px;
	/*设置负值，为要定位子盒子的一半高度*/
	
}
@media screen and (min-width:500px){
	.login-box {
		left: 50%;
		/*设置负值，为要定位子盒子的一半宽度*/
		margin-left: -250px;
	}
}	

.form {
	width: 100%;
	max-width:500px;
	height: 275px;
	margin: 25px auto 0px auto;
	padding-top: 25px;
}	
.login-content {
	height: 500px;
	width: 100%;
	max-width:500px;
	background-color:#6699FF; 
	float: left;
}
table{
	width:100px;
	height:500px;
	text-align: center; 
	
}
a{
 color:white;
}
/* 当有鼠标悬停在链接上  rgba(255, 250, 2550, .6);*/
a:hover {
	color: white;
	text-decoration:none; 
} 
/* 已访问的链接 */
a:visited {
	color: white;
	text-decoration:none; 

}
 
</style>  
<body>
 <div class="box"> 
 	<div class="login-box"> 
		<div class="login-content ">
			 <table class="table">  
   <tbody>
      <tr>
         <td >  	
         			<a href="#">
			         <img src="image/todolist.png"  alt=" 我的待办" style="width: 80px; height: 80px;"/> 
			         </a>
		          <br/>
		     	  <a href="#"> 我的待办</a>  
  		 </td>
         <td>
        
			      <a href="#" >
			         <img src="image/driving.png"  alt=" 驾驶舱" style="width: 80px; height: 80px;"/>
			      </a>
		          <br/>
		     	  <a href="#"> 驾驶舱</a> 
         </td>
      </tr>
      <tr>
         <td>
         	 
			      <a href="#" >
			         <img src="image/conf.png"  alt=" 配置项" style="width: 80px; height: 80px;"/>
			      </a>
		          <br/>
		     	  <a href="#">配置项</a> 
         </td>
         <td> 
			      <a href="#" >
			         <img src="image/konwledge.png"  alt=" 通知公告" style="width: 80px; height: 80px;"/>
			      </a>
		          <br/>
		     	  <a href="#">通知公告</a> 	</div> 
          </td>
      </tr>
        <tr>
         <td>
         	 
			      <a href="#" >
			         <img src="image/config.png"  alt=" 个人设置" style="width: 80px; height: 80px;"/>
			      </a>
		          <br/>
		     	  <a href="#">个人设置</a> 
         </td>
         <td></td>
      </tr>
   </tbody>
</table>
			 
		</div>
	</div>
</table>
 </div> 
</body>
</html>