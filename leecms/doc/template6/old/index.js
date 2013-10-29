
		  var _gaq = _gaq || [];
		  _gaq.push(['_setAccount', 'UA-18589568']);
		  _gaq.push(['_trackPageview']);

		  (function() {
		    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		  })();


			function recordOutboundLink(link, category, action) {
				_gat._getTrackerByName()._trackEvent(category, action);
				if ( link.target == '_blank' ) return true;
				setTimeout('document.location = "' + link.href + '"', 100);
				return false;
			}
			/* use regular Javascript for this */
			function getAttr(ele, attr) {
				var result = (ele.getAttribute &amp;&amp; ele.getAttribute(attr)) || null;
				if( !result ) {
					var attrs = ele.attributes;
					var length = attrs.length;
					for(var i = 0; i &lt; length; i++)
					if(attr[i].nodeName === attr) result = attr[i].nodeValue;
				}
				return result;
			}

			window.onload = function () {
				var links = document.getElementsByTagName('a');
				for (var x=0; x &lt; links.length; x++) {
					if (typeof links[x] == 'undefined') continue;
					if (typeof links[x].onclick != 'undefined') continue;
					links[x].onclick = function () {
						var mydomain = new RegExp(document.domain, 'i');
						href = getAttr(this, 'href');
						if(href &amp;&amp; href.toLowerCase().indexOf('http') === 0 &amp;&amp; !mydomain.test(href)) {
							recordOutboundLink(this, 'Outbound Links', href);
						}
					}
				}
			};

	var searchbox = MGJS.$("searchbox");
	var searchtxt = MGJS.getElementsByClassName("textfield", "input", searchbox)[0];
	var searchbtn = MGJS.getElementsByClassName("button", "input", searchbox)[0];
	var tiptext = "Type text to ";
	if(searchtxt.value == "" || searchtxt.value == tiptext) {
		searchtxt.className += " searchtip";
		searchtxt.value = tiptext;
	}
	searchtxt.onfocus = function(e) {
		if(searchtxt.value == tiptext) {
			searchtxt.value = "";
			searchtxt.className = searchtxt.className.replace(" searchtip", "");
		}
	}
	searchtxt.onblur = function(e) {
		if(searchtxt.value == "") {
			searchtxt.className += " searchtip";
			searchtxt.value = tiptext;
		}
	}
	searchbtn.onclick = function(e) {
		if(searchtxt.value == "" || searchtxt.value == tiptext) {
			return false;
		}
	}
