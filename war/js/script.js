$(function() {
	$('#input-container').on('click', 'button', function() {
		var number = $(this).parent().find('input:text').val();

		$.ajax({
			type : "POST",
			url : "/restsqrt",
			data : JSON.stringify({
				"number" : number
			}),
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(response) {
				if (response.response_status === "ok") {
					$('#result').html("Result: " + response.result);
				} else {
					$('#result').html("Error occured: " + response.result);
				}
			},
			failure : function() {
				$('#result').html("Error occured");
			}
		});
	});
});