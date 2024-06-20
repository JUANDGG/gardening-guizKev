
import { uri_main_x_path } from '../config/configRequest.js';

const getData = async (path) => {
    const response = await fetch(uri_main_x_path(path), {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${localStorage.getItem("tokenGuizKevApi")}`
        },
    });

    if (!response.ok) {
        throw new Error("you are not authorized to perform this action.");
    }

    const responseData = await response.json();
    return responseData;
}

export { getData };
