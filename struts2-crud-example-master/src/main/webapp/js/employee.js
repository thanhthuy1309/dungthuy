$(document).ready(function() {
	var optionDataTable = {
		searching : false,
		"lengthMenu" : [ [ 5, 10, 20, 50, -1 ], [ 5, 10, 25, 50, "すべて" ] ],
		"columnDefs" : [ {
			"targets" : 'no-sort',
			"orderable" : false,
			"order" : []
		} ],
		"language" : {
			"paginate" : {
				"first" : "←",
				"previous" : "前",
				"next" : "次",
				"last" : "→"
			},
			"info" : "表示 _START_ に _END_ の _TOTAL_ エントリー",
			"lengthMenu" : "表示 _MENU_ レコード"
		},
		"pagingType" : "full_numbers"
	};

	$('.tableEmployee').DataTable(optionDataTable);
});