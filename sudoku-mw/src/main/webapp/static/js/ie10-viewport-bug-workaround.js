/*!
 * IE10 viewport hack for Surface/desktop Windows 8 bug
 * Copyright 2014 Twitter, Inc.
 * Licensed under the Creative Commons Attribution 3.0 Unported License. For
 * details, see http://creativecommons.org/licenses/by/3.0/.
 */

// See the Getting Started docs for more information:
// http://getbootstrap.com/getting-started/#support-ie10-width
$(document).ready(function() {
	$("#hide").click(function() {
		$("#new_game").hide();
	});
	$("#show").click(function() {
		$("#new_game").show();
		$('#new_game').css("visibility", "visible");

	});
	$(window).load(function() {
		$('#new_game').show();
		$('#new_game').css("visibility", "visible");

	});
});

(function() {
	'use strict';
	if (navigator.userAgent.match(/IEMobile\/10\.0/)) {
		var msViewportStyle = document.createElement('style')
		msViewportStyle.appendChild(document
				.createTextNode('@-ms-viewport{width:auto!important}'))
		document.querySelector('head').appendChild(msViewportStyle)
	}
})();