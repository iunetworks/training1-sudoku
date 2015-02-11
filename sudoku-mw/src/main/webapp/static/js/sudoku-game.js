(function ($) {
    "use strict";

    function createElement(tag, attr) {
        var el = $(document.createElement(tag)) ;
        if (typeof attr === 'object') {
            Object.keys(attr).forEach(function (key) {
                el.attr(key, attr[key])
            })
        }
        return el;
    }

    var boardContainer = $('#sudoku-table')
        , table = createElement('table',{'class':'center-block'})
        , row, cell;

    boardContainer.append(table);
    // generate sudoku board and fill with spaces
    for(var rowIndex=0; rowIndex<9;rowIndex++) {
        row = createElement('tr');
        table.append(row)
        for(var colIndex=0; colIndex<9; colIndex ++) {
            cell = createElement('td', {'id':'cell-'+(rowIndex*9+colIndex), 'class': 'sudoku-cell'});
            row.append(cell);
            cell.html('&nbsp;')
        }
    }

})(jQuery);

$("#hide").click(function() {
	$("#new_game").hide();
});