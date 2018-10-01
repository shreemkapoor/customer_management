(function($) {
	$.fn.serializeFormJSON = function() {

		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
})(jQuery)
$( document ).ready(function() {

	$("#loginForm")
		.validate(
			{
			rules : {
						'emailId' : {
						required : true,
						maxlength : 40,
						email : true
					},
						'userPassword' : {
						required : true,
						alpanumericspecialchpass : true,
						maxlength : 200,
						minlength : 8
					},
					'captcha' : {
						required : true,
						maxlength : 6,
					}, 
				},
			messages : {
						'emailId' : {
						required : "Please enter Email",
						maxlength : "Email Should be less than or equal to 40 characters",
						email : "please enter vaild email"
					},
						'userPassword' : {
						required : "Please enter password",
						alpanumericspecialchpass : "please enter valid password",
						maxlength : "Password Should be less than or equal to 40 characters",
						minlength : "Password Should be more than 8 or equal to 40 characters"
					},
					'captcha' : {
						required : "This field is required",
						maxlength : "Should be same as above image",
					}, 
				},
			errorPlacement : function(error,element) {
						error.addClass("help-block");
						$(element).next('.FeRror').html(
						error.text()).css('display', 'block');

				},
					highlight : function(element,errorClass, validClass) {
					$(element).parent().addClass("has-error").removeClass("has-success");
				},
					unhighlight : function(element,errorClass, validClass) {
					if ($(element).parent().hasClass('has-error')) {
					$(element).parent().addClass("has-success").removeClass("has-error");
					$(element).next('.FeRror').css('display', 'none');
				}
		},
	submitHandler : function(form) {
		var pass = $("#userPwd").val();
		var randomsalt=$("#randSalt").val();
		var actualpass = new Hashes.SHA256().hex(pass);
		var SHA256 = new Hashes.SHA256().hex((new Hashes.SHA256().hex(pass))+ randomsalt);
		$("#userPwd").val(SHA256);		
		form.submit();
	}
});

});
function refresh_captcha() {
	/*$('#loginId').val("");
	$("#userPwd").val("");*/
	$('#captcha').val("");
	$('#captcha_id').attr('src', 'captchaimg?' + Math.random());
}
