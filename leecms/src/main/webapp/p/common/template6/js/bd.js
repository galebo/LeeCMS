var BD_BRIDGE_OPEN = 1;
var BD_BRIDGE_ROOT = "http://qiao.baidu.com/";
var BD_BRIDGE_RCV_ROOT = "http://rqiao.baidu.com/";
var BD_BRIDGE_DATA = {siteid : "479049"};
var BD_BRIDGE_ICON_CONFIG = {
	background : {
		color : "",
		url   : "http://qiao.baidu.com/res/iconbg/10.jpg"
	},
	head : {
		url    : "http://qiao.baidu.com/res/iconhead/13.png",
		width  : 122,
		height : 58
	},
	button : {
		color : "#f7bd84",
		url   : "",
		text  : "#d8a016"
	},
	flow     : 1,
	position : 2,
	special : "0"
};
var BD_BRIDGE_INVITE_CONFIG = {
	background : {
		color : "",
		url   : "http://qiao.baidu.com/res/invitebg/10.jpg"
	},
	head : {
		show : 0,
		size : 1,
		url  : "http://qiao.baidu.com/res/invitehead/01_big.jpg"
	},
	text   : "",
	button : "#45cc15",
	mode   : 0,
	special : "0"
};
var BD_BRIDGE_INVITE = {
	invitetype   : 0,
	inviterepeat : 1,
	invitetime   : 3
};
var BD_BRIDGE_PIGEON_SOUL = {
	disableMess     : 0,
	messType        : 0,
	messFloatType   : 0,
	language        : 0,
	position        : 0,
	backgroundColor : "#6cadde",
	messItemName    : 1,
	messItemPhone   : 1,
	messItemAddress : 2,
	messItemEmail   : 0,
	extraMessItems  : [] 
};
if ((BD_BRIDGE_OPEN == 1) && (typeof window["BD_BRIDGE_LOADED"] == "undefined")) {
	window["BD_BRIDGE_LOADED"] = 1;
	var script = document.createElement("script");
    script.type="text/javascript";
    script.charset = "UTF-8";
    script.src = BD_BRIDGE_ROOT + "js/bw.js?v=2357";
    document.getElementsByTagName("head")[0].appendChild(script);
}