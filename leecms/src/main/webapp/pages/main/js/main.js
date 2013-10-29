function IsExit(){
	if (confirm("真的要退出系统吗?"))
	{
		parent.location.href="/logout";
		return true;
	}
}
function initTime(){
	setInterval("document.getElementById('jnkc').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
}