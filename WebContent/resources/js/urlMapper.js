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
	
	/*
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
alert("s d");

			    	
			        var file_data = $('#uploadfile').prop( 'files')[0];
			       
			        var form_data = new FormData();
			        form_data.append('filedata', file_data);
			     
			      $("#empForm").attr("file",form_data);
			      $( "#empForm" ).submit();

					return false;
			       
			        console.log(form_data);
										
				}
			});*/

 /*   $(document).on("click","#userSubmit",
      		 function() {
    	
    	
        var file_data = $('#uploadfile').prop( 'files')[0];
       
        var form_data = new FormData();
        form_data.append('filedata', file_data);
     
      $("#empForm").attr("file",form_data);
      $( "#empForm" ).submit();

       
        console.log(form_data);
        
    });*/
	
});


function showURLTable(){

	var urlid=$("#urlid").val();
	$.ajax({
		url:"getUrlById",
		data :{"id":urlid},
		type:"post",
		success:function(data){

			var html = '';
			
		
			var len = data.length;
		if(len>0){
			for (var i = 0; i < len; i++) {
				 
				html += "<tr><td>"+data[i].subUrlId+"</td><td>"+data[i].subUrl+"</td>" +
						"<td>"+data[i].subUrlDesc+"</td><td><button>add</button></td></tr>";
						}
		
			$('#urltable').html("");
			$('#urltable').html(html); 
			$('#urltableDiv').show();
		}else{
			$('#urltableDiv').hide();
		}
		},error:function(e){
			
		}
		

});
	

	
}

