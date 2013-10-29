var focus_width=200
var focus_height=150
var text_height=25
var swf_height = focus_height+text_height
						
var pics='MyFiles/2006123015315254599.jpg|MyFiles/2006123015302666580.jpg|MyFiles/2006123015284125864.jpg|MyFiles/2006123015264264295.jpg|MyFiles/2006122415362537191.jpg|MyFiles/2006122415352434054.jpg'
var links='http://|http://|http://|http://|http://|http://'
var texts='гн|гн|гн|гн|гн|гн  '
document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="'+ focus_width +'" height="'+ swf_height +'">');
document.write('<param name="allowScriptAccess" value="sameDomain"><param name="movie" value="http://www.86lawyer.com/images/pixviewer.swf">');
document.write('<param name="menu" value="false"><PARAM NAME="AllowNetworking" VALUE="all"><PARAM NAME="WMode" VALUE="Transparent">');
document.write('<param name="FlashVars" value="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'">');
document.write('<embed src="http://www.86lawyer.com/images/pixviewer.swf" wmode="opaque" FlashVars="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'" menu="false" bgcolor="#ffffff" quality="high" width="'+ focus_width +'" height="'+ focus_height +'" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />');		
document.write('</object>');
