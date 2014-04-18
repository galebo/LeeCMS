function getUrl(){
	var path=window.location.href;
	var start=-1;
	var url="/pp/w/webIndex";
    if((start=path.indexOf('pages/view/'))>-1){
		url=path.substring(0,start)+'pages/view/index/1.html';
	}else if((start=path.indexOf('pp/h/'))>-1){
		var end=path.indexOf('/',start+7);
		url=path.substring(0,end)+'/index/1.html';
	}
    return url;
}