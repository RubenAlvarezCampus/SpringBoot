function eliminar(id) {
		    swal({
		        title: "Estas Seguro?",
		        text: "Si lo eliminas no podras recuperarlo...",
		        icon: "warning",
		        buttons: true,
		        dangerMode: true,
		    })
		        .then((OK) => {
		            if (OK) {
		                $.ajax({
		                    url:"/admin/delete/" + id,
		                    success: function(res){
		                        console.log(res);
		                    }
		                });
		                swal("Se ha eliminado correctamente el usuario!", {
		                    icon: "success",
		                }).then((ok)=>{
		                    if(ok){
		                        location.href="/admin";
		                    }
		                });
		            } else {
		                swal("No se ha eliminado ningun usuario");
		            }
		        });
}