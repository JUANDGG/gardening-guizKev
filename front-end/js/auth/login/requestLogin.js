import { uri_main_x_path } from '../../config/configRequest.js';

const login = async (username, password) => {
    const requestBody = {
        userName: username,
        password: password
    };


    const response = await fetch(uri_main_x_path("auth/login"), {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(requestBody)
    });

    if (!response.ok) {
        throw new Error("Error logging in. Please try again.");
    }

    const responseData = await response.json();
    localStorage.setItem("tokenGuizKevApi", responseData.token);
    
}

export {
    login
}
