document.getElementById("btn_logout").addEventListener("click", () => {
    // Mostrar ventana emergente con SweetAlert
    swal({
        text: "Closing session",
        icon: "info",
        button: false,
        closeOnClickOutside: false,
        closeOnEsc: false,
    });

    // Eliminar el token del localStorage después de un pequeño retraso
    setTimeout(() => {
        localStorage.removeItem("tokenGuizKevApi");
        window.location.href = "index.html";
    }, 1000); // Cambia el valor según sea necesario (en milisegundos)
});