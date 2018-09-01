<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style type="text/css">
    .in{
        margin-top:30px;
        margin-left:30px;
    }
</style>
<script type="text/javascript">


    $('#fm').form('load','${pageContext.request.contextPath}/album/queryAlbum?id=${param.id}');


</script>


    <form id="fm" method="post">
        <div class="in">
            名称:<input class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>
        <div class="in">
            数量:<input class="easyui-textbox" type="text" name="count" data-options=""/>
        </div>
        <div class="in">

            封面: <input class="easyui-textbox" type="text" name="corverImg" data-options=""/>
        </div>
        <div class="in">

            评分:<input class="easyui-textbox" type="text"  name="score" data-options=""/>
        </div>
        <div class="in">

            作者:<input class="easyui-textbox" type="text"  name="author" data-options=""/>
        </div>
        <div class="in">

            播音:<input class="easyui-textbox" type="text" name="broadCast" data-options=""/>
        </div>
        <div class="in">

            内容简介:<input class="easyui-textbox" type="text" name="brief" data-options=""/>
        </div>
        <div class="in">

            发布日期:<input class="easyui-datetimebox" type="text" name="publicDate" data-options=""/>
        </div>
        <div class="in">

            创建日期:<input class="easyui-datetimebox" type="text"  name="createDate" data-options=""/>
        </div>
        <div class="in">

            状态:<input class="easyui-textbox"  name="status" data-options=""/>
        </div>
    </form>
