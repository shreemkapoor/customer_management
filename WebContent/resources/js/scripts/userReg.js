/*$( document ).ready(function() {
	

    $(document).on("click","#userSubmit",
      		 function() {
        alert("111");
        var file_data = $('#uploadfile').prop( 'files')[0];
       
        var form_data = new FormData();
        form_data.append('filedata', file_data);
      alert(file_data);
      
       
        console.log(form_data);
        $
            .ajax({
                url: 'createUser',
                data: form_data,
                async: false,
                dataType: 'text',
                processData: false,
                contentType: false,
                type: 'POST',
                beforeSend: function(xhr) {
                  //  xhr.setRequestHeader( 'X-CSRF-Token', $(  '#secureToken') .val());
                },
                success: function(data,  textStatus, jqXHR) {

                    if (data == "1") {
                   	 
                   	 alert("Save successfully");

                    } else {
                   	 alert("Save successfully");
                    }
                },
                error: function(jqXHR,
                    textStatus,
                    errorThrown) {
                    alert(textStatus,
                        errorThrown);
                }
            });
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
}*/
/*
function show(){
	 alert("111");
     var file_data = $('#uploadfile').prop( 'files')[0];
    
     var form_data = new FormData();
     form_data.append('filedata', file_data);
   alert(file_data);
   
    
     console.log(form_data);
     $
         .ajax({
             url: 'createUser',
             data: form_data,
             type: 'POST',
             beforeSend: function(xhr) {
               //  xhr.setRequestHeader( 'X-CSRF-Token', $(  '#secureToken') .val());
             },
             success: function(data,  textStatus, jqXHR) {

                 if (data == "1") {
                	 
                	 alert("Save successfully");

                 } else {
                	 alert("Save successfully");
                 }
             },
             error: function(jqXHR,
                 textStatus,
                 errorThrown) {
                 alert(textStatus,
                     errorThrown);
             }
         });
}
*/