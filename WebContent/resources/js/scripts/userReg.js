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

					'firstName' : {
						required : true,
						letterswithspaceonly : true
					},
					'lastName':{
						required=true,
					}

				},
				messages : {
					'firstName' : {
						required : "Please Enter Organization",
						letterswithspaceonly : "Please enter valid name organization"
					},

					

				},
				errorPlacement : function(error,
						element) {
					error.addClass("help-block");
					$(element).next('.FeRror').html(
							error.text()).css(
							'display', 'block');

				},
				highlight : function(element,
						errorClass, validClass) {
					$(element).parent().addClass(
							"has-error").removeClass(
							"has-success");
				},
				unhighlight : function(element,
						errorClass, validClass) {
					if ($(element).parent().hasClass(
							'has-error')) {
						$(element).parent().addClass(
								"has-success")
								.removeClass(
										"has-error");
						$(element).next('.FeRror').css(
								'display', 'none');
					}
				},
				submitHandler : function(form) {
/*alert("s d");

			    	
			        var file_data = $('#uploadfile').prop( 'files')[0];
			       
			        var form_data = new FormData();
			        form_data.append('filedata', file_data);
			     
			      $("#empForm").attr("file",form_data);
			      $( "#empForm" ).submit();
*/
					return false;
			       
			        console.log(form_data);
										
				}
			});

    $(document).on("click","#userSubmit",
      		 function() {
    	
    	
        var file_data = $('#uploadfile').prop( 'files')[0];
       
        var form_data = new FormData();
        form_data.append('filedata', file_data);
     
      $("#empForm").attr("file",form_data);
      $( "#empForm" ).submit();

       
        console.log(form_data);
        
    });
	
});

function getEmpDistrict() {
	var stcode = $("#stateCode").val();
//alert(stcode);
	$.ajax({
		url:"alldistrict",
		data :{"id":stcode},
		type:"post",
		success:function(data){

			var html = '<option value="" label="--Select--"></option>';
			
		
			var len = data.length;
		
			for (var i = 0; i < len; i++) {
				 
				html += '<option value="' + data[i].districtCode + '" label="'
				+ data[i].districtDesc + '"></option>';
			}
		
			$('#districtCode_id').html("");
			$('#districtCode_id').html(html); 
			
		},error:function(e){
			
		}
		

});
}

