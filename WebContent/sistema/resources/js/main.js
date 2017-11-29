$(document).ready(function() {

	/* affix the navbar after scroll below header */
	$('#nav').affix({
		offset : {
			top : $('header').height() - $('#nav').height()
		}
	});

	/* highlight the top nav as scrolling occurs */
	$('body').scrollspy({
		target : '#nav'
	})

	/* smooth scrolling for scroll to top */
	$('.scroll-top').click(function() {
		$('body,html').animate({
			scrollTop : 0
		}, 1000);
	})

	/* smooth scrolling for nav sections */
	$('#nav .navbar-nav li>a').click(function() {
		var link = $(this).attr('href');
		var posi = $(link).offset().top + 20;
		$('body,html').animate({
			scrollTop : posi
		}, 700);
	})

	/* google maps */

	// enable the visual refresh
	google.maps.visualRefresh = true;

	var map;
	function initialize() {
		var mapOptions = {
			zoom : 15,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		map = new google.maps.Map(document
				.getElementById('map-canvas'), mapOptions);
		// try HTML5 geolocation
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(
					position) {
				var pos = new google.maps.LatLng(
						position.coords.latitude,
						position.coords.longitude);

				var infowindow = new google.maps.InfoWindow({
					map : map,
					position : pos,
					content : 'Location found using HTML5.'
				});

				map.setCenter(pos);
			}, function() {
				handleNoGeolocation(true);
			});
		} else {
			// browser doesn't support geolocation
			handleNoGeolocation(false);
		}
	}

	function handleNoGeolocation(errorFlag) {
		if (errorFlag) {
			var content = 'Error: The Geolocation service failed.';
		} else {
			var content = 'Error: Your browser doesn\'t support geolocation.';
		}

		var options = {
			map : map,
			position : new google.maps.LatLng(60, 105),
			content : content
		};

		var infowindow = new google.maps.InfoWindow(options);
		map.setCenter(options.position);
	}
	google.maps.event
			.addDomListener(window, 'load', initialize);

});

(function(i, s, o, g, r, a, m) {
	i['GoogleAnalyticsObject'] = r;
	i[r] = i[r] || function() {
		(i[r].q = i[r].q || []).push(arguments)
	}, i[r].l = 1 * new Date();
	a = s.createElement(o), m = s.getElementsByTagName(o)[0];
	a.async = 1;
	a.src = g;
	m.parentNode.insertBefore(a, m)
})(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
ga('create', 'UA-40413119-1', 'bootply.com');
ga('send', 'pageview');

//input preview
function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$("#img_preview").attr('src', e.target.result)
		};
		reader.readAsDataURL(input.files[0]);
	} else {
		var img = input.value;
		$("#img_preview").attr('src', img);
	}
}

function verificaMostraBotao() {
	$('#id_foto').each(function(index) {
		if ($('#id_foto').eq(index).val() != "") {
			readURL(this);
			$('#img_title').hide();
		}
	});
}

$('#id_foto').on("change", function() {
	verificaMostraBotao();
});