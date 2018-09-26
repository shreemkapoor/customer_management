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

	$("#empForm")
		.validate(
			{
			rules : {
						'firstName' :{
							required : true,
							minlength: 4,
							maxlength : 30,
							alpanumericwithspace:true,
						},
						'lastName' :{
							required : true,
							minlength: 4,
							maxlength : 30,
						},
						'emailId' : {
							required : true,
							maxlength : 40,
							email : true
						},
						'mobileNumber' : {
							required : true,
							digits : true,
							maxlength : 15,
							minlength : 5
						},
						'DOB' :{
							date : true,
						},
						'gender' :{
							required : true,
						},
						'city' :{
							required : true,
							maxlength : 20
						},
						'address' :{
							required : true,
							maxlength : 200
						},
						'stateCodedesc' :{
							required : true
						},
						'districtCodeDesc' :{
							required : true
						},
						'postalCode' :{
							required : true,
							digits : true,
							maxlength : 10,
							minlength : 5
						},
						'designation' :{
							required : true,
							maxlength : 20
						},
						'userType' :{
							required : true,
						},
						'file' :{},
						'userRole' :{
							required : true
							},
			
				},
			messages : {
						
						'firstName' :{
							required : "Field cannot be empty",
							minlength: "Should be more than 4 characters",
							maxlength : "Firstname should be less than 30 characters",
						},
						'lastName' :{
							required : "Field cannot be empty",
							minlength: "Should be more than 4 characters",
							maxlength : "Firstname should be less than 30 characters",
						},
						'emailId' : {
							required : "Please enter Email",
							maxlength : "Email Should be less than or equal to 40 characters",
							email : "please enter vaild email"
					},
						'mobileNumber' : {
							required : "Please enter mobile number",
							digits: "Please enter only digits",
							maxlength : "Should be less than or equal to 15 characters",
							minlength : "Should be more than 8"
					},
					'DOB' :{
						date : "ptanhi",
					},
					'gender' :{
						required : "Choose gender",
					},
					'city' :{
						required : "Field cannot be empty",
						maxlength : "Should be less than or equal to 20 characters"
					},
					'address' :{
						required : "Field cannot be empty",
						maxlength : "Should be less than or equal to 200 characters"
					},
					'stateCodedesc' :{
						required : "Choose state"
					},
					'districtCodeDesc' :{
						required : "Choose district"
					},
					'postalCode' :{
						required : "Please enter postal code",
						digits: "Please enter only digits",
						maxlength : "Should be less than or equal to 15 characters",
						minlength : "Should be more than 2"
					},
					'designation' :{
						required : "Field cannot be empty",
						maxlength :"Should be less than or equal to 20 characters"
					},
					'userType' :{
						required :"Choose type",
					},
					'file' :{},
					'userRole' :{
						required : "choose role"
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
	$("#empForm").submit();
	}
});

});
