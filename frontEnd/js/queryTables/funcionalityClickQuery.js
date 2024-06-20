import {getData} from './requestQueris.js'
import {reorganizationData} from './normalizeData.js'
import {createTable} from './tables.js'

console.log("asd");

const handleQueries=()=> {
    const queries = document.querySelectorAll('li.query');
    queries.forEach(query => {
        query.addEventListener('click', async () => {
            try {
                const endpoint = query.getAttribute("data-endpoint");
                const response = await getData(endpoint);
                const reorganizationDataResponse = reorganizationData(response);
                createTable(reorganizationDataResponse);
            } catch (error) {
                console.error("Error al obtener respuesta:", error);
            }
        });
    });
}
handleQueries();