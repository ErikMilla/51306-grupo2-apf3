document.addEventListener('DOMContentLoaded', function () {
    const registerForm = document.getElementById('registerForm');
    const loginForm = document.getElementById('loginForm');

    // Formulario de registro
    registerForm.addEventListener('submit', function (e) {
        e.preventDefault();

        const usuario = registerForm.querySelector('input[name="usuario"]').value;
        const email = registerForm.querySelector('input[name="email"]').value;
        const password = registerForm.querySelector('input[name="password"]').value;

        fetch('/registrar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                usuario,
                email,
                password
            })
        })
        .then(response => {
            if (response.ok) {
                alert('Usuario registrado correctamente');
                registerForm.reset();
                document.getElementById('login').click(); // Cambia a la vista de login
            } else {
                return response.text().then(text => { throw new Error(text) });
            }
        })
        .catch(error => {
            console.error('Error al registrar:', error);
            alert('Error al registrar: ' + error.message);
        });
    });

    // Formulario de login
    loginForm.addEventListener('submit', function (e) {
        e.preventDefault();

        const usuario = loginForm.querySelector('input[name="usuario"]').value;
        const password = loginForm.querySelector('input[name="password"]').value;

        fetch('/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                usuario,
                password
            })
        })
        .then(response => {
            if (response.ok) {
                alert('Inicio de sesión exitoso');
                // Redirecciona o cambia vista según rol
                window.location.href = '/dashboard'; // ajusta esto a tu ruta real
            } else {
                return response.text().then(text => { throw new Error(text) });
            }
        })
        .catch(error => {
            console.error('Error al iniciar sesión:', error);
            alert('Error de login: ' + error.message);
        });
    });

    // Cambiar entre login y registro
    document.getElementById('register').addEventListener('click', () =>
        document.getElementById('container').classList.add("active")
    );

    document.getElementById('login').addEventListener('click', () =>
        document.getElementById('container').classList.remove("active")
    );
});
