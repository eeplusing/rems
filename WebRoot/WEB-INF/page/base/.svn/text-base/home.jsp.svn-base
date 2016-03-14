<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../taglib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>设备管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/t_style.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/equms/home.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery/jquery-calendar.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/equms/modle_form.css" />
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/component/jquery-calendar.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/equms/equms.js"></script>
    
    <script type="text/javascript">
        $(function(){
        	$(".open_menu").each(function(){
        		$(this).click(function(){
        			$(this).siblings().each(function(){
        				$(this).children("div").slideUp("1000");
        				$(this).children("span.pt_grade_o").css({
            				"background":"#F5F5F5",
            				"color":"#333"
            			});
        				$(this).children("span.pt_grade_t").css({
            				"color":"#333"
            			});
        				
        				$(this).children("span.pt_grade_o").children("label.selected_icon").css("background", "url('${pageContext.request.contextPath}/img/right.png') 12px 3px no-repeat");
        				
        				$(this).children("span.pt_grade_t").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/add.png') 0px 3px no-repeat");
        				
        				if($(this).hasClass("sys_manager")){
        					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/a1.png') no-repeat");
        				}
        				if($(this).hasClass("equ_manager")){
        					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/a2.png') no-repeat");
        				}
        				if($(this).hasClass("spa_manager")){
        					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/a3.png') no-repeat");
        				}
        				if($(this).hasClass("sto_manager")){
        					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/a4.png') no-repeat");
        				}
        				if($(this).hasClass("tend_manager")){
        					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/a5.png') no-repeat");
        				}
        				if($(this).hasClass("form_manager")){
        					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/a6.png') no-repeat");
        				}
        				if($(this).hasClass("stat_manager")){
        					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/a7.png') no-repeat");
        				}
        				if($(this).hasClass("dtd_manager")){
        					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/a8.png') no-repeat");
        				}
        			});
        			$(this).children("div").slideDown("1000");
        			$(this).children("span.pt_grade_o").css({
        				"background":"#3794CF",
        				"color":"#FDF4F8"
        			});
        			$(this).children("span.pt_grade_t").css({
        				"color":"#3794CF"
        			});
        			$(this).children("span.pt_grade_o").children("label.selected_icon").css("background", "url('${pageContext.request.contextPath}/img/right-d.png') 12px 3px no-repeat");
        		    
        			$(this).children("span.pt_grade_t").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/less01.png') 0px 3px no-repeat");
        			
        			if($(this).hasClass("sys_manager")){
    					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/b1.png') no-repeat");
    				}
    				if($(this).hasClass("equ_manager")){
    					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/b2.png') no-repeat");
    				}
    				if($(this).hasClass("spa_manager")){
    					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/b3.png') no-repeat");
    				}
    				if($(this).hasClass("sto_manager")){
    					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/b4.png') no-repeat");
    				}
    				if($(this).hasClass("tend_manager")){
    					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/b5.png') no-repeat");
    				}
    				if($(this).hasClass("form_manager")){
    					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/b6.png') no-repeat");
    				}
    				if($(this).hasClass("stat_manager")){
    					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/b7.png') no-repeat");
    				}
    				if($(this).hasClass("dtd_manager")){
    					$(this).children("span.pt_grade_o").children("label.modle_icon").css("background", "url('${pageContext.request.contextPath}/img/b8.png') no-repeat");
    				}
    				
    				$()
        		});
        	});
        	
        	$(".menus").find("a").click(function(){
        		$(".menus").find("a").each(function(){
        			$(this).removeClass("checked");
        		});
        		$(this).addClass("checked");
        	});
        	
        	$(".child_modle_linker").click(function(){
        		var pto = $(this).parents(".modle_root").find(".pt_grade_o");
        		var ptt = $(this).parents(".modle_root").find(".pt_grade_t");
        		var _html = "<ul><li>" + $(pto[0]).find(".modle_name").text() + " ></li>"
        		if(ptt.length > 0){
        			_html += "<li>" + $(ptt[0]).find(".modle_name").text() + " ></li>"
        		}
        		_html += "<li class=\"last_\">" + $(this).find("a").text() + "</li></ul><div style=\"clear: both;\"></div>"
        		$(".current_position").html(_html);
        	});
        	
        	init_modleForm();
        });
        
        function load_page(url){
        	$.ajax({
			    type : "POST",
				url : url,
				data : null,
				dataType : "html",
				success : function(msg) {
				    $(".h_main").html(msg + "<div style=\"clear: both;\"></div>");
				    init_page();
				}
			});
        }
    </script>
  </head>
  
  <body>
    <div class="home">
         <div class="top">
             <div class="tl">
                 <a href="home.action" title="系统首页"><span>魔盾设备管理系统</span></a>
                 <div style="clear: both;"></div>
             </div>
             <div class="tr">
                 <ul>
                    <li>
                        <a href="#" class="help" title="帮助"></a>
                        <a href="#" class="about" title="系统介绍"></a>
                        <a href="login.action" class="exit" title="退出登录"></a>
                        <div style="clear: both;"></div>
                    </li>
                 </ul>
                 <div style="clear: both;"></div>
             </div>
             <div style="clear: both;"></div>
         </div>
         <div class="msg_place">
             <table>
                 <tr>
                    <td class="user"></td>
                    <td class="blank_"></td>
                    <td class="message">
                         <label class="user_name">您好！${user_name}</label>
                         <label class="message"><a href="javascript:void(0);" title="你有${message_num}条新任务">任务(${message_num})</a></label>
                    </td>
                    <td class="blank_"></td>
                    <td class="place">
                         <div class="current_position">
                             <ul>
                                 <li>系统首页</li>
                             </ul>
                         </div>
                    </td>
                 </tr>
             </table>
         </div>
         <div class="mid menus">
             <ul>
                 <c:forEach items="${MenuTree.childTree}" var="mt">
                      <c:if test="${mt.childTree == null}">
                          <li onclick="load_page('${mt.modleURL}');"><a href="javascript:void(0);" class="${mt.flagClass}" >${mt.modleName}</a></li>
                      </c:if>
                      <c:if test="${mt.childTree != null}">
                          <li class="open_menu modle_root ${mt.flagClass}">
                              <span class="pt_grade_o">
                                  <label class="modle_label modle_icon"></label>
                                  <label class="modle_label modle_name">${mt.modleName}</label>
                                  <label class="modle_label selected_icon"></label>
                              </span>
		                      <div style="display:none;">
		                          <ul>
		                              <c:forEach items="${mt.childTree}" var="ct">
		                                  <c:if test="${ct.childTree == null}">
					                          <li class="a_grade_t child_modle_linker ${ct.flagClass}" onclick="load_page('${ct.modleURL}');"><a href="javascript:void(0);">${ct.modleName}</a></li>
					                      </c:if>
					                      <c:if test="${ct.childTree != null}">
					                          <li class="open_menu ${ct.flagClass}">
					                              <span class="pt_grade_t">
					                                  <label class="modle_label modle_icon"></label>
					                                  <label class="modle_label modle_name">${ct.modleName}</label>
					                              </span>
					                              <div style="display:none;">
		                                              <ul>
		                                                  <c:forEach items="${ct.childTree}" var="m">
		                                                      <li class="a_grade_thr child_modle_linker ${m.flagClass}" onclick="load_page('${m.modleURL}');"><a href="javascript:void(0);">${m.modleName}</a></li>
		                                                  </c:forEach>
		                                              </ul>
		                                          </div>
					                          </li>
					                      </c:if>
		                              </c:forEach>
		                          </ul>
		                      </div>
		                  </li>
                      </c:if>
                 </c:forEach>
             </ul>
             <div style="clear: both;"></div>
         </div>
         <div class="mid h_main">
             <table class="modle_form">
                 <tr><td class="field_name">设备编号:</td><td><input type="text" name="fieldCode0" id="fieldCode0" format="{empty:0, length:50, regex:regex, test:0}"></td><td class="field_name">设备名称:</td><td><input type="text" name="fieldCode1" id="fieldCode1" format="{empty:1, length:50, regex:regex, test:1}"></td><td class="field_name">设备类型:</td><td><input type="radio" name="fieldCode2" value="0">动力设备<input type="radio" name="fieldCode2" value="1">生产设备<input type="radio" name="fieldCode2" value="2">交通运输设备<input type="radio" name="fieldCode2" value="3">仪器仪表</td></tr><tr><td class="field_name">设备规格:</td><td><input type="text" name="fieldCode3" id="fieldCode3" format="{empty:1, length:50, regex:regex, test:1}"></td><td class="field_name">所属部门:</td><td><select name="fieldCode4" id="fieldCode4"><option value="0">管理部门</option><option value="1">生产一部</option><option value="2">生产二部</option><option value="3">营业部</option><option value="4">财务部</option><option value="5">人事部</option><option value="6">总务部</option></select></td><td class="field_name">启用时间:</td>
                 <td><input type="text" id="fieldCode5" name="fieldCode5" maxlength="19" value="" onclick="$(this).calendar();"/></td></tr><tr><td class="field_name">设备外形:</td><td><input type="file" name="fieldCode6" id="fieldCode6"></td></tr><tr><td class="field_name">使用环境:</td><td colspan="5"><input type="checkbox" name="fieldCode7" value="0">室内<input type="checkbox" name="fieldCode7" value="1">室外<input type="checkbox" name="fieldCode7" value="2">高温<input type="checkbox" name="fieldCode7" value="3">低温<input type="checkbox" name="fieldCode7" value="4">风沙<input type="checkbox" name="fieldCode7" value="5">辐射<input type="checkbox" name="fieldCode7" value="6">粉尘</td></tr><tr><td class="field_name">使用年限:</td><td><input type="text" name="fieldCode8" id="fieldCode8" format="{empty:0, length:3, regex:regex, test:0}"></td></tr><tr><td class="field_name">设备描述:</td><td colspan="5"><textarea name="fieldCode9" id="fieldCode9"></textarea></td></tr>
             </table>
             <div style="clear: both;"></div>
         </div>
         <div style="clear: both;"></div>
    </div>
  </body>
</html>
