import { register } from './requestRegister.js';

const isPasswordSecure = (password) => {
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    return passwordRegex.test(password);
}

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

    if (inputUser.length > 10) {
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'The username must have a maximum of 10 characters.'
        });
        return;
    }

    if (!isPasswordSecure(inputPassword)) {
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'The password must be at least 8 characters and contain at least one lowercase letter, one uppercase letter, one number, and one special character.'
        });
        return;
    }

    try {
        await register(inputUser, inputPassword);

        Swal.fire({
            icon: 'success',
            title: 'Successful registration',
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

document.getElementById("btn_register").addEventListener("click", handleRegistration);


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