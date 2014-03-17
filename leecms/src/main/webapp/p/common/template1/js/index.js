jQuery.noConflict();
jQuery(function() {
	jQuery('div.answer,.bottom_controls').hide();
	jQuery('a.hide').click(function() {
		jQuery('div.answer').slideUp();
		jQuery('.faqtogglerdiv a.faqtoggler').removeClass("open");
		jQuery('.faqtogglerdiv a.faqtoggler').addClass("closed");
	});
	jQuery('a.opener').click(function() {
		jQuery('div.answer').slideDown();
		jQuery('.faqtogglerdiv a.faqtoggler').toggleClass("open");
		jQuery('.faqtogglerdiv a.faqtoggler').removeClass("closed");
	});
	jQuery('a.opener').click(function() {
		jQuery('div.bottom_controls').fadeIn();
	});
	jQuery('a.hide').click(function() {
		jQuery('div.bottom_controls').fadeOut();
	});
	jQuery('.faqtogglerdiv a.faqtoggler').click(function() {
		jQuery(this).parent('div').next('div').slideToggle();
		jQuery(this).toggleClass("open");
		return false;
	});
});