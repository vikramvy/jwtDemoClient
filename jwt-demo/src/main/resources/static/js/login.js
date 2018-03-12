function validate() {
	var name = document.getElementById("userName").value;
	var passWord = document.getElementById("passWord").value;
	if (name == '' || passWord == '' ) {
		alert('Please enter a valid credential.');
		return false;
	}
	
		return true;
	}
