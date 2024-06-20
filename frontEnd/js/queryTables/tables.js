const createTable = (data) => {
    const columns = Object.keys(data[0] || {}).map(key => ({
        title: key,
        field: key,
        formatter: function(cell, formatterParams, onRendered) {
            if (key.endsWith('_child')) {
                const div = document.createElement('div');
                div.textContent = JSON.stringify(JSON.parse(cell.getValue()));
                div.style.color = 'blue'; 
                div.style.fontWeight = 'bold'; 
                div.style.whiteSpace = 'pre'; 
                return div;
            } else {
                return cell.getValue(); 
            }
        }
    }));

    const table = new Tabulator("#container", {
        height: "100%",
        layout: "fitData",
        data: data,
        responsiveLayout: "collapse",
        addRowPos: "top",
        history: true,
        pagination: "local",
        paginationSize: 7,
        paginationCounter: "rows",
        movableColumns: true,
        columns: columns,
        // Estilo para el tema oscuro
        cellVertAlign: "middle",
        layout: "fitDataStretch",
        initialSort: [
            { column: "name", dir: "asc" }
        ],
        rowFormatter: function(row) {
            if (row.getPosition(true) % 2 === 0) {
                row.getElement().style.backgroundColor = "#fafafa"; // Cambia el color de fondo de las filas pares
            } else {
                row.getElement().style.backgroundColor = "#ccc"; // Cambia el color de fondo de las filas impares
            }
        },
        headerSortTristate: true,
        paginationSizeSelector: [3, 6, 8, 10],
        paginationSize: 8,
        movableColumns: true,
        tooltips: true,
        tooltipsHeader: true,
        responsiveLayout: "collapse",
        responsiveLayoutCollapseStartOpen: false,
        placeholder: "No Data Set",
    });
    table.redraw();
}

export {
    createTable
};
