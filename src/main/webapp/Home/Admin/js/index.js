/**
 * 
 */
var firebaseConfig = {
	apiKey: "AIzaSyAopHGn7kleRl1b8VMedeS_NLcjJpSbZRs",
	authDomain: "collegerankingmanagementsystem.firebaseapp.com",
	projectId: "collegerankingmanagementsystem",
	storageBucket: "collegerankingmanagementsystem.appspot.com",
	messagingSenderId: "409052021701",
	appId: "1:409052021701:web:4cea3c690a4d84e934c1ac",
	measurementId: "G-XXMEEYXZ9S"
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);
firebase.analytics();

$(button).click(function() {
	var email = $("#uname".val());
	var password = $("#pwd".val());

	if (email != "" && password != "") {
		var result = firebase.auth().signInWithEmailAndPassword(email, password);

		result.catch(function(error) {
			var errorCode = error.code;
			var errorMessage = error.message;

			window.alert("Message : " + errorMessage);
		});
	}
	else {
		windows.alert("Please fill out all fields");
	}
});