document.addEventListener('DOMContentLoaded', function() {
    const wishlistForm = document.getElementById('wishlistForm');
    const wishlistModal = document.getElementById('wishlistModal');
    const closeModal = document.getElementsByClassName('close')[0];

    wishlistForm.addEventListener('click', function() {
        wishlistModal.style.display = 'block';
    });

    closeModal.addEventListener('click', function() {
        wishlistModal.style.display = 'none';
    });

    window.addEventListener('click', function(event) {
        if (event.target === wishlistModal) {
            wishlistModal.style.display = 'none';
        }
    });
});
