var CODES = CODES || {}; 
		CODES = (function(){
			CODES.form = function(param){
				jQuery("."+param.btn).click(function(){
					var succ = validate();
					if(param.before() && succ ){
						$.ajax({
							type:'get',
				            url:param.url,
				            async:false,
				            data:$('#'+param.id).serialize(),
				            success:function(data){  
				            	var json = JSON.parse(data);
				            	var hasMsg = typeof(json.msg) != "undefined";
				                if(json.success){
				                	if(hasMsg){
					                    alert(json.msg);
				                	}
									if(typeof(json.url) != "undefined"){
										if(hasMsg){
											setTimeout(function(){
												window.location.href=json.url;
											},1500);
										}else{
					                		window.location.href=json.url;
										}
				                	}
				                }else{
				                    alert(json.msg);
				                } 
				            }                  
						});
					}
				});
			}			
			
			function validate(){
				var flag = true;
				var validate = null;
				var index = null;
				var label = null;
				jQuery(".help-block").html("");
				jQuery("input[validate]:enabled").each(function(){
					validate = jQuery(this).attr("validate");
					label = jQuery(this).attr("label");
					var val = jQuery(this).val();
					if(validate.indexOf("required") != -1){
						if(val == ""){
							jQuery(this).parent().addClass("has-error");
							jQuery(this).next().html(label+"不能为空");
							flag = false;
							return true;
						}
					}
					if(validate.indexOf("mobile") != -1){
						if(val.match(/^1[0-9]{10}$/) == null){
							jQuery(this).parent().addClass("has-error");
							jQuery(this).next().html(label+"格式错误");
							flag = false;						
							return true;
						}
					}
					if(validate.indexOf("number") != -1){
						if( isNaN(val) ){
							jQuery(this).parent().addClass("has-error");
							jQuery(this).next().html(label+"必须为数字","forbidden");
							flag = false;						
							return true;
						}
					}
					if((index = validate.indexOf("max")) != -1){
						var sub = validate.substring(index + 4);
						var last = sub.indexOf(",");
						var num = null;
						if( last != -1 ){
							num = sub.substring(0,last);
						}else{
							num = sub;
						}
						if(val > parseInt(num)){
							jQuery(this).parent().addClass("has-error");
							jQuery(this).next().html(label+"不得大于"+num);
							flag = false;						
							return true;
						}
					}
					if((index = validate.indexOf("min")) != -1){
						var sub = validate.substring(index + 4);
						var last = sub.indexOf(",");
						var num = null;
						if( last != -1 ){
							num = sub.substring(0,last);
						}else{
							num = sub;
						}
						if(val < parseInt(num)){
							jQuery(this).parent().addClass("has-error");
							jQuery(this).next().html(label+"不得小于"+num);
							flag = false;						
							return true;
						}
					}
					jQuery(this).parent().removeClass("has-error");
					
				});
				return flag;
			}	
			
			return{
                form: CODES.form,
                validate:validate
            }
		})();

