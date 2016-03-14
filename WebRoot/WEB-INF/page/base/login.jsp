<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>系统登录</title>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
   	<script type="text/javascript">
	    $(function(){
	    	resizePage();
	    	 
	    	
	    	 
	    });
	    
	    window.onresize=function(){  
	    	resizePage();  
	    }
	    
   	</script>
	
	<style type="text/css">
		#mainDiv{
			background:url(${pageContext.request.contextPath}/img/denglu.jpg) top center no-repeat;
			background-size:cover;
			width:1300px;
			height:600px;
			margin:30px auto;
			border:1px solid #1CB8DE;
		}
		
		#location{
			border:0px solid #0F0;
			width:384px; 
			height:257px; 
			margin-left:890px;
			margin-top:255px;
		}
		
		.submitBtn{
			background-color:#3794CF;
			border: none;
			font-size: 16px;
			color:#FFF;
			font-weight: bolder;
		}
		
		.fonterror{
			color:#F00;
			font-size:14px;
			font-weight:bold;
		}
	
	</style>
  </head>
  
  <body>
  	<div id="mainDiv" >
	    <s:form action="accountAction_login" namespace="/" method="post">
	    	<div id="location">
				<table>
					<tr><td style="height:56px;"></td></tr>
					<tr>
						<td id="loginName" style="border: 0px solid #F00;">
							<s:textfield id="account" name="accountNo" style="height:35px; width:223px;  border:none;"/>
						</td>
						<td>
							<font class="fonterror"><s:fielderror><s:param>accountNo</s:param></s:fielderror></font>
						</td>
					</tr>
					<tr><td style="height:31px;"></td></tr>
					<tr>
						<td id="loginPsw" class="" style="border: 0px solid #F00;">
							<s:password id="password" name="accountPass" style=" height:35px; width:223px; border:none;"/>
						</td>
						<td>
							<font class="fonterror"><s:fielderror><s:param>accountPass</s:param></s:fielderror></font>
						</td>
					</tr>
					<tr><td style="height:27px;"></td></tr>
					<tr>
						<td id="loginSure" style="border:0px solid #F00; height:35px; width:223px;  border:none;">
							<s:submit style="height:29px; width:223px;" value="登    录            " cssClass="submitBtn"/>
						</td>
					</tr>
				</table>
			</div>
		</s:form>
	</div>
  </body>
</html>
