
var moveDiv1=new moveDiv('1','www.letv.com',"/p/upload/20127261665162370.jpg");
function beginMoveAd(){
	moveDiv1.beginMoveAd();
};
window.onload=beginMoveAd;//给窗体的load事件附加飘浮函数 


var scrollPic_01 = new ScrollPic();
scrollPic_01.scrollContId   = "Team"; //内容容器ID
scrollPic_01.arrLeftId      = "Team_right";//左箭头ID
scrollPic_01.arrRightId     = "Team_left"; //右箭头ID
scrollPic_01.frameWidth     = 116*6;//显示框宽度
scrollPic_01.pageWidth      = 116; //翻页宽度
scrollPic_01.speed          = 20; //移动速度(单位毫秒，越小越快)
scrollPic_01.space          = 20; //每次移动像素(单位px，越大越快)
scrollPic_01.autoPlay       = true; //自动播放
scrollPic_01.autoPlayTime   = 3; //自动播放间隔时间(秒)
scrollPic_01.initialize(); //初始化






				
function CheckForm()
{
	if(document.UserLogin.UserName.value=="")
	{
		alert("对不起，请您输入用户名！");
		document.UserLogin.UserName.focus();
		return false;
	}
	if(document.UserLogin.Password.value == "")
	{
		alert("对不起，请您输入密码！");
		document.UserLogin.Password.focus();
		return false;
	}
}
