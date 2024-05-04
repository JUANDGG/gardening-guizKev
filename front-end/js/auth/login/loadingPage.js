import {login} from './requestLogin.js';



const handleRegistration = async () => {
    const inputUser = document.getElementById("inputUser").value.trim();
    const inputPassword = document.getElementById("inputPassword").value.trim();

    if (inputUser === '' || inputPassword === '') {
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Please complete all fields.'
        });
        return;
    }

    try {
        await login(inputUser, inputPassword);

        Swal.fire({
            icon: 'success',
            title: 'Successful section start',
            showConfirmButton: false,
            timer: 1500
        }).then(() => {
            window.location.href = "dashboard.html";
        });
    } catch (error) {
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: error.message
        });
    }
};



document.getElementById("btn_login").addEventListener("click", handleRegistration);


document.getElementById("inputPassword").addEventListener("keypress", (event) => {
    if (event.key === 'Enter') {
        handleRegistration();
    }
});

document.getElementById("inputUser").addEventListener("keypress", (event) => {
    if (event.key === 'Enter') {
        handleRegistration();
    }
});