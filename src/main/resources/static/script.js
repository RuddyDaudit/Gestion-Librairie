// Fichier : script.js

document.addEventListener('DOMContentLoaded', (event) => {

    // =================================================================
    // LOGIQUE MODALES AJOUT (myModal) & SUPPRESSION (deleteModal)
    // =================================================================

    // Element de modal d'ajout
    var modal = document.getElementById("myModal");
    var btn = document.getElementById("openModalBtn");
    // La première span[class="close"] (index 0) est celle de la modale d'ajout
    var span = document.getElementsByClassName("close")[0];

    // ELEMENT DE MODAL DE SUPPRESSION
    var deleteModal = document.getElementById("deleteModal");
    var deleteBtn = document.getElementById("openDeleteModalBtn");
    // On utilise la classe spécifique 'delete-close' ou on cherche la seconde 'close'
    var deleteSpan = document.getElementsByClassName("delete-close")[0];

    // Ouvrir la modale d'ajout
    if (btn) {
        btn.onclick = function () {
            modal.style.display = "block";
        }
    }

    // Ouvrir la modale de suppression
    if (deleteBtn) {
        deleteBtn.onclick = function () {
            deleteModal.style.display = "block"
        }
    }

    // Fermer la modale d'ajout
    if (span) {
        span.onclick = function () {
            modal.style.display = "none";
        }
    }

    // Fermer la modale de suppression
    if (deleteSpan) {
        deleteSpan.onclick = function () {
            deleteModal.style.display = "none";
        }
    }

    // =================================================================
    // LOGIQUE MODALE MODIFICATION (editModal)
    // =================================================================

    // ELEMENTS POUR LA MODALE DE MODIFICATION
    var editModal = document.getElementById("editModal");
    var closeEditBtn = editModal ? editModal.querySelector(".edit-close") : null;
    var editButtons = document.querySelectorAll(".open-edit-btn"); // Sélectionne tous les boutons 'Modifier' dans le tableau

    // Champs du formulaire de modification (ID, Nom, Auteur, etc.)
    var editBookIdInput = document.getElementById("editBookId");
    var editNameInput = document.getElementById("editNameBook");
    var editAuthorFirstInput = document.getElementById("editAuthorFirstName");
    var editAuthorLastInput = document.getElementById("editAuthorLastName");
    var editDateInput = document.getElementById("editReleaseDate");
    var editPriceInput = document.getElementById("editPrice");
    var editStatusSelect = document.getElementById("editOrderStatus");

    // Fermeture de la modale de modification
    if (closeEditBtn) {
        closeEditBtn.onclick = function () {
            editModal.style.display = "none";
        }
    }

    // Écouteur pour tous les boutons 'Modifier' dans le tableau
    editButtons.forEach(button => {
        button.addEventListener('click', function () {
            // Récupérer les données du livre via les attributs data-* du bouton cliqué
            var bookId = this.getAttribute('data-id');
            var bookName = this.getAttribute('data-name');
            var authorFirst = this.getAttribute('data-author-first');
            var authorLast = this.getAttribute('data-author-last');
            var releaseDate = this.getAttribute('data-date');
            var price = this.getAttribute('data-price');
            var status = this.getAttribute('data-status');

            // Remplir les champs du formulaire dans la modale
            editBookIdInput.value = bookId;
            editNameInput.value = bookName;
            editAuthorFirstInput.value = authorFirst;
            editAuthorLastInput.value = authorLast;

            // Gérer la date (important pour le format AAAA-MM-JJ)
            editDateInput.value = releaseDate && releaseDate !== 'null' ? releaseDate : '';

            // Remplir le prix et le statut
            editPriceInput.value = price;
            editStatusSelect.value = status;

            // Ouvrir la modale
            editModal.style.display = "block";
        });
    });

    // =================================================================
    // GESTION DU CLIC À L'EXTÉRIEUR (fenêtre)
    // =================================================================

    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
        if (event.target == deleteModal) {
            deleteModal.style.display = "none";
        }
        // Ajout de la modale de modification
        if (editModal && event.target == editModal) {
            editModal.style.display = "none";
        }
    }
});