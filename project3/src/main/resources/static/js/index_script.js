$(function(){
	
	// rollover- quickmenu
	$('.rollover').each(function(){
		var a = $(this);
		var span = a.find('span');
		var pos_off = span.css('background-position-x');
		
		
		a.bind('mouseenter focus click',function(){
			span.css('background-position-x','-255px');
		});
		a.bind('mouseleave blur',function(){
			span.css('background-position-x',pos_off);
		});
	});
	
	//guideText - mylibrary
	var guideClass = 'mute';
	$('.guideText').each(function(){
		var guideText = this.defaultValue;
		var element = $(this);
		element.focus(function(){
			if(element.val()===guideText){
				element.val('');
				element.removeClass(guideClass);
			}
		}).blur(function(){
			if(element.val()===''){
				element.val(guideText);
				element.addClass(guideClass);
			}
		});
		if(element.val()===guideText){
			element.addClass(guideClass);
		};
	});
	
	// imgslider - botbanner
	 var interval = 2500;
	
	$('.slideshow').each(function(){
		var timer;
		var container = $(this);
		function switchImg(){
			var anchors = container.find('.slide');
			var first = anchors.eq(0);
			var second = anchors.eq(1);
			first.fadeOut().appendTo(container);
			second.fadeIn();
		}
		
		function startTimer(){
			timer=setInterval(switchImg, interval);
		}
		function stopTimer(){
			clearInterval(timer);
		}
		startTimer();
		container.find('.slide').hover(stopTimer,startTimer);
	}); 

	//tabcontent - tab board
	$('#tab_board').each(function(){
		var topDiv = $(this);
		var anchors = topDiv.find('ul.tabs a');
		var panelDivs = topDiv.find('div.panel');
		var lastAnchor;
		var lastPanel;
		anchors.show();
		lastAnchor = anchors.filter('.on')
		lastPanel = $(lastAnchor.attr('href'));
		panelDivs.hide();
		lastPanel.show(); 
		
		
		
		anchors.click(function(event){
			 event.preventDefault();
			 var currentAnchor = $(this);
			 var currentPanel = $(currentAnchor.attr('href'));
			 if(currentAnchor.get(0)===lastAnchor.get(0)){
				 return;
			 }
			 lastPanel.slideUp(200,function(){
				lastAnchor.removeClass('on');
				currentAnchor.addClass('on');
				currentPanel.slideDown(200);
				lastAnchor = currentAnchor;
				lastPanel = currentPanel;
			 });			 
			 			 
		});
	});
	
	//poster -imgslider
	var panel_width = $('.slider_panel img').width();
	var size = $('.control_button').size();
	$('.slider_text').css('left',-300).each(function(index){
		$(this).attr('data-index',index);
	});
	$('.control_button').each(function(index){
		$(this).attr('data-index',index);
	}).click(function(){
		var index = $(this).attr('data-index');
		// alert(index);
		moveSlider(index);
	});
	
	function moveSlider(index){
		var willMoveLeft = -(index*panel_width);
		$('.slider_panel').animate({left:willMoveLeft},1000);
		$('.control_button[data-index='+index+']').addClass('active');
		$('.control_button[data-index!='+index+']').removeClass('active');
		$('.slider_text[data-index='+index+']').show().animate({left:20},1000);
		$('.slider_text[data-index!='+index+']').hide().animate({left:-300},1000);
		randomNumber = index;
	}
	var randomNumber = Math.round(Math.random()*4);
	moveSlider(randomNumber);
	
	var setIntervalId;
	function timer(){
		setIntervalId = setInterval(function(){
			randomNumber++;
			if(randomNumber==size){
				randomNumber = 0;				
			}
			//moveSlider(randomNumber);
			$('.control_button').eq(randomNumber).trigger('click');
		},2000);
	}
	timer();
	$('.animation_canvas').hover(
		function(){
			clearInterval(setIntervalId);
		},
		function(){
			timer();
		}
	);
	$('.left').click(function(){
		randomNumber--;
		if(randomNumber<0){randomNumber = size-1;}
		$('.control_button').eq(randomNumber).trigger('click');
	});
	
	$('.right').click(function(){
		randomNumber++;
		if(randomNumber>=size){randomNumber = 0;}
		$('.control_button').eq(randomNumber).trigger('click');
	});
	
	//weather
	$.getJSON('http://api.openweathermap.org/data/2.5/find?q=seoul&units=metric&appid=59cd4115a815a56a919458303f2f2979', function(today_data){
		var today_min_temp = today_data.list[0].main.temp_min;
		var today_max_temp = today_data.list[0].main.temp_max;
		var today_temp = today_data.list[0].main.temp;
		var today_feel_temp = today_data.list[0].main.feels_like;
		var today_humidity = today_data.list[0].main.humidity
		var today_date_time = new Date();
		var today_month = today_date_time.getMonth()+1;
		var today_day = today_date_time.getDate();
		var today_hour = today_date_time.getHours();
		var today_minute = today_date_time.getMinutes();
		var today_weather_icon = today_data.list[0].weather[0].icon;
		var today_weather_text = today_data.list[0].weather[0].main;
		$('.today_temp_text').html(today_temp + '&#8451;');
		$('.today_min_temp_text').html('최저 '+today_min_temp+'&#8451;');
		$('.today_max_temp_text').html('최고 '+today_max_temp+'&#8451;');
		$('.today_feel_temp_text').html('체감 '+today_feel_temp+'&#8451;');
		$('.today_humidity_text').html('습도 '+today_humidity+'%');
		$('.today_date_text').text(today_month+'월 '+today_day+'일 '+today_hour+'시 '+today_minute+'분');
		
		
		if(todayWeather_Icon == '01d' || todayWeather_Icon == '01n' || todayWeather_Icon == '02d' || todayWeather_Icon == '02n' || todayWeather_Icon == '03d' || todayWeather_Icon == '03n' || todayWeather_Icon == '04d' || todayWeather_Icon == '04n' || todayWeather_Icon == '09d' || todayWeather_Icon == '09n' || todayWeather_Icon == '10d' || todayWeather_Icon == '10n' ||todayWeather_Icon == '11d' || todayWeather_Icon == '11n' || todayWeather_Icon == '13d' || todayWeather_Icon == '13n' || todayWeather_Icon == '50d' || todayWeather_Icon == '50n'){
			$('.todayWeatherIcon').attr('src','images/weather/'+todayWeather_Icon+'.png');
		}else {
			$('.todayWeatherIcon').attr('src','images/weather/01d.png');
		};

		if(todayWeather_Text == 'Rain'){
			$('.todayWeather').css({'background':'url(images/weather/rain_bg.png)'});
		}else if(todayWeather_Text == 'Clear'){
			$('.todayWeather').css('background','url(images/weather/clear_bg.png)');
		}else if(todayWeather_Text == 'Clouds'){
			$('.todayWeather').css('background','url(images/weather/clouds_bg.png)');
		}else if(todayWeather_Text == 'Thunderstorm' || todayWeather_Text == 'Tornado' || todayWeather_Text == 'Squall'){
			$('.todayWeather').css('background','url(images/weather/thunderstorm_bg.png)');
		}else if(todayWeather_Text == 'Snow'){
			$('.todayWeather').css('background','url(images/weather/snow_bg.png)');
		}else if(todayWeather_Text == 'Smoke' || todayWeather_Text == 'Haze' || todayWeather_Text == 'Dust' || todayWeather_Text == 'Sand' || todayWeather_Text == 'Ash' || todayWeather_Text == 'Atmosphere' || todayWeather_Text == 'Mist' || todayWeather_Text == 'Fog'){
			$('.todayWeather').css('background','url(images/weather/atmosphere_bg.png)');
		} else {
			$('.todayWeather').css('background','url(images/weather/clear_bg.png)');
		};
	});			
	
	
});