$(function(){
	//accordian - faq board
	var class_closed = 'closed';
	$('.board').each(function(){
		var ul = $(this);
		var allQuestion = ul.find('.question');
		var allAnswer = ul.find('.answer');
				
		function closeAll(){
			allQuestion.addClass(class_closed);
			allAnswer.addClass(class_closed);
		}
		function open(dt, dd){
			dt.removeClass(class_closed);
			dd.removeClass(class_closed);
		}
		closeAll();
		
		allQuestion.click(function(){
			var question = $(this);
			var answer = question.next();
			closeAll();
			open(question, answer);
			
		});
	});
});