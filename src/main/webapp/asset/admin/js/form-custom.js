(function($) {
	function floatLabel(inputType) {
		$(inputType).each(function() {
			var $this = $(this);
			// on focus add cladd active to label
			$this.focus(function() {
				$this.next().addClass("active");
			});
			//on blur check field and remove class if needed
			$this.blur(function() {
				if ($this.val() === '' || $this.val() === 'blank') {
					$this.next().removeClass();
				}
			});
		});
	}
	// just add a class of "floatLabel to the input field!"
	floatLabel(".floatLabel");
})(jQuery);

// ------------------------------------------------------------------------ //

// make tag a send post request

var sendPostRequest = (url) => {
	if (confirm("Are u sure about that ?")) {
		fetch(url, {
			method: 'POST'
		})
			.then(() => location.reload())
	}
}