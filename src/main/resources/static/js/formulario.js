document.addEventListener('DOMContentLoaded', () => {
    const fileInput = document.getElementById('portada');
    const form = document.querySelector('.book-form');

    if (fileInput) {
        fileInput.addEventListener('change', (event) => {
            const file = event.target.files && event.target.files[0];
            if (file) {
                fileInput.setAttribute('data-label', file.name);
            }
        });
    }

    if (form) {
        form.addEventListener('submit', (event) => {
            const requiredFields = form.querySelectorAll('input[required], select[required]');
            for (const field of requiredFields) {
                if (!field.value || field.value.trim() === '') {
                    event.preventDefault();
                    field.focus();
                    return;
                }
            }
        });
    }
});
