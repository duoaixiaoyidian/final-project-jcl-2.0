<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style type="text/css">
    .in{
        margin-top:30px;
        margin-left:30px;
    }
</style>
<script type="text/javascript">

    $(function () {
        var toolbar = [{
            iconCls: 'icon-lightbulb',
            text: "专辑详情",
            handler: function () {
                var row = $("#tree").edatagrid("getSelected");
                if(row){
                    $("#diver").dialog({
                        title:'专辑详情',
                        width:600,
                        height:300,
                        href:"${pageContext.request.contextPath}/datagird/bridge.jsp?id="+row.id
                    })
            }else {
                    $.messager.alert('警告','请选择专辑');
                }
            }
        }, '-', {
            text: "添加专辑",
            iconCls: 'icon-control_remove_blue',
            handler: function () {
                $('#div').dialog({
                    title:'添加专辑',
                    iconCls:'icon-add',
                    width:600,
                    height:500,
                    buttons:[{
                        text:'提交',
                        iconCls:'icon-ok',
                        handler:function () {
                            $('#ff').submit();
                        }
                    },{
                        text:'关闭',
                        handler:function(){
                            $('#div').dialog('close');
                        }
                    }]
                });
                $("#ff").form("submit", {
                    url: "${pageContext.request.contextPath}/album/add"
                })
            }
        }, '-', {
            text: "添加章节",
            iconCls: 'icon-bullet_edit',
            handler: function () {
               var row = $("#tree").treegrid("getSelected");
               if(row!=null){
                   if(row.author!=null){
                       $("#chapter_id").dialog("open");
                       $('#chapter_form').form('load',row);
                   }else{
                       alert("请先选择专辑")
                   }
               }else {
                   alert("请先选择行")
               }
            }
        }, '-', {
            text: "下载音频",
            iconCls: 'icon-script_save',
            handler: function () {
                var row = $("#tree").treegrid("getSelected");
                if (row != null) {
                    if (row.author == null) {
                        location.href = "${pageContext.request.contextPath}/chapter/down?audioPath=" + row.audioPath + "&title=" + row.title
                    } else {
                        alert("请选中专辑");
                    }
                } else {
                    alert("请选中行");
                }
            }
        }]

        $('#tree').treegrid({
            onDblClickRow: function (row) {
                $("#audio_dd").dialog("open")
                $("#audio").prop("src", "${pageContext.request.contextPath}/upload/"+ row.audioPath)
            },
            url: '${pageContext.request.contextPath}/album/query',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '名称', width: 60},
                {field: 'size', title: '大小', width: 60},
                {field: 'audioPath', title: '下载路径', width: 80},
                {field: 'duration', title: '时长', width: 80}
            ]],
            fit: true,
            fitColumns:true,
            toolbar:toolbar
        });
    })
    function submit1() {
        $("#chapter_form").form("submit", {
            url: "${pageContext.request.contextPath}/chapter/add"
        })
    }

</script>

<table id="tree"></table>
<div id="diver"></div>
<div id="div">
    <form id="ff" method="post" enctype="multipart/form-data">
        <div class="in">
            名称:<input class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>
        <div class="in">
            数量:<input class="easyui-textbox" type="text" id="count" name="count" data-options=""/>
        </div>
        <div class="in">

           封面: <input class="easyui-textbox" type="text" id="corverImg" name="corverImg" data-options=""/>
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
    <div id="audio_dd" class="easyui-dialog" title="音频" style="width:400px;height:200px;"
         data-options="iconCls:'icon-music ',resizable:true,modal:true,closed:true">
        <audio src="" id="audio" controls="controls" autoplay="autoplay">

        </audio>
    </div>

</div>

<div id="chapter_id" class="easyui-dialog" title="添加章节" style="width:400px;height:350px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                     submit1();
                      $('#chapter_id').dialog('close');
                      $('#tree').edatagrid('reload')
				}
			},{
				text:'关闭',
				handler:function(){
                     $('#chapter_id').dialog('close');
				}
			}]">
    <form id="chapter_form" method="post" enctype="multipart/form-data">
        <div class="in">

            音频路径:<input class="easyui-filebox" type="text" name="path" data-options=""/>
        </div>
        <div class="in">

            所属专辑:<input class="easyui-textbox" name="id" data-options="required:true"/>
        </div>
    </form>
</div>
