document.addEventListener('DOMContentLoaded', function() {
    // Selecciona los elementos de cada formulario
    const formClub = document.querySelector('.club-sign-up');
    const formUser = document.querySelector('.user-sign-up');
    const formLogin = document.querySelector('.sign-in');

    // Selecciona los botones dentro de cada formulario
    const btnSignUpClub = document.querySelector('.sign-in-btn.sign-up-club');
    const btnSignUpUser = document.querySelector('.sign-in-btn.sign-up-user');
    const btnSignInFromClub = document.querySelector('.club-sign-up .sign-up-btn');
    const btnSignInFromUser = document.querySelector('.user-sign-up .sign-up-btn');

    // Función para abrir un formulario y cerrar los otros
    function toggleForm(openForm) {
        formClub.classList.remove('active');
        formUser.classList.remove('active');
        formLogin.classList.remove('active');
        openForm.classList.add('active');
    }

    // Eventos para alternar entre los formularios
    btnSignUpClub.addEventListener('click', function(event) {
        event.preventDefault();
        toggleForm(formClub); // Abre el formulario de registro de clubes
    });

    btnSignUpUser.addEventListener('click', function(event) {
        event.preventDefault();
        toggleForm(formUser); // Abre el formulario de registro de usuarios
    });

    btnSignInFromClub.addEventListener('click', function(event) {
        event.preventDefault();
        toggleForm(formLogin); // Vuelve al formulario de inicio de sesión desde Clubes
    });

    btnSignInFromUser.addEventListener('click', function(event) {
        event.preventDefault();
        toggleForm(formLogin); // Vuelve al formulario de inicio de sesión desde Usuarios
    });
});