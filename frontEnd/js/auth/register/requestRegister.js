import { uri_main_x_path } from '../../config/configRequest.js';

const register = async (username, password) => {
    const requestBody = {
        userName: username,
        password: password
    };


    const response = await fetch(uri_main_x_path("auth/register"), {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(requestBody)
    });

    if (!response.ok) {
        throw new Error("Error register in. Please try again.");
    }

    const responseData = await response.json();
    localStorage.setItem("tokenGuizKevApi", responseData.token);
    
}

export {
    register
}
