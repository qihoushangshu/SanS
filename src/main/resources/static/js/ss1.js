$("#add").click(function(){
     console.log("----------add------------------"); 
     $("#successMsg").removeClass("display-block");
     $("#successMsg").addClass("display-none");
     $("#errorMsg").removeClass("display-block");
     $("#errorMsg").addClass("display-none");
     var name = $("#name").val();
     var user = {
   　　　　　　　　  name:name
   　　　　　　　  };
     $.ajax({
         url: "add",
         contentType: "application/json;charset=UTF-8",
         method: "post",
         data: JSON.stringify(user),
         dataType: "json",
         success: function(data) {
             if (data.status == "success") {
                $("#successMsg").text("保存成功");
                $("#successMsg").removeClass("display-none");
                $("#successMsg").addClass("display-block");
                $("#name").val("");
              }else{
            	  if(data.errmsg != "" && data.errmsg != null){
             		 $("#errorMsg").text(data.errmsg);
             		 $("#errorMsg").removeClass("display-none");
                     $("#errorMsg").addClass("display-block");
                  }
              }
         },
         error: function(data) {
        	  
             $("#errorMsg").text("保存失败");
             $("#errorMsg").removeClass("display-none");
             $("#errorMsg").addClass("display-block");
         }
     });

 }); 