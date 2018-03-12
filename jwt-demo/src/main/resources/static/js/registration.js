function validate() {
	var firstName = document.getElementById("firstName").value;
	var lastName = document.getElementById("lastName").value;
	var street = document.getElementById("street").value;
	var city = document.getElementById("city").value;
	var zipcode = document.getElementById("zipCode").value;
	var state = document.getElementById("state").value;
	var email = document.getElementById("email").value;
	var phone = document.getElementById("phone").value;
	if (firstName == '' || lastName == ''|| street == ''|| city == ''|| zipcode == ''|| state == ''
			|| email == ''|| phone == '') {
		alert('Please enter all fields.');
		return false;
	}
	return true;
}