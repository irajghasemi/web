// Blocked user
(function(document) {
	'use strict';
	
	var blocked = (function(Blocked_Arr) {
		
		var blocked_input;
		
		function _onInputEvent(e) {
			blocked_input = e.target;
			var blocked_tables = document.getElementsByClassName(blocked_input.getAttribute('blocked_data_table'));
			Blocked_Arr.forEach.call(blocked_tables, function(blocked_table) {
				Blocked_Arr.forEach.call(blocked_table.tBodies, function(blocked_tbody) {
					Blocked_Arr.forEach.call(blocked_tbody.rows, _filter);
				});
			});
		}
		
		function _filter(blocked_row) {
			var blocked_text = blocked_row.textContent.toLowerCase(), val = blocked_input.value.toLowerCase();
			blocked_row.style.display = blocked_text.indexOf(val) === -1 ? 'none' : 'blocked_table-row';
		}
		
		return {
			init: function() {
				var blocked_inputs = document.getElementsByClassName('blocked_light-table-filter');
				Blocked_Arr.forEach.call(blocked_inputs, function(blocked_input) {
					blocked_input.oninput = _onInputEvent;
				});
			}
		};
	})(Array.prototype);
	
	document.addEventListener('readystatechange', function() {
		if (document.readyState === 'complete') {
			blocked.init();
		}
	});
	
})(document);
