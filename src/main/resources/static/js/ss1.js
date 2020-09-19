$("#add").click(function(){
     console.log("----------add------------------"); 
     var name = $("#name").val();
     $.ajax({
         url: "add",
         method: "post",
         data: {
        	 name: name
         },
         dataType: "json",
         success: function(data) {
             if (data.status == "success") {
                $("#successMsg").text("保存成功");
                $("#successMsg").removeClass("display-none");
                $("#successMsg").addClass("display-block");
                $("#name").val("");
              }
         },
         error: function(data) {
        	 $("#errorMsg").text("保存失败");
             $("#errorMsg").removeClass("display-none");
             $("#errorMsg").addClass("display-block");
         }
     });

 }); 