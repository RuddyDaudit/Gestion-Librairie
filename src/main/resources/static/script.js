// Fichier : script.js (Version Finale Corrigée)

console.log("--- SCRIPT.JS DÉMARRAGE ---");

// =============================================================
// 1. VARIABLES ET ÉLÉMENTS
// =============================================================
const modal = document.getElementById("myModal");
const btn = document.getElementById("openModalBtn");
const span = modal ? modal.querySelector(".close") : null;
const bookInput = modal ? modal.querySelector('input[name="nameBook"]') : null;
const bookCover = document.getElementById('bookCover');

const editModal = document.getElementById("editModal");
const editClose = document.querySelector(".edit-close");
const editButtons = document.querySelectorAll(".open-edit-btn");

const deleteModal = document.getElementById("deleteModal");
const deleteClose = document.querySelector(".delete-close");
const confirmDeleteBtn = document.getElementById("confirmDeleteBtn");

// =============================================================
// 2. UTILITAIRES
// =============================================================
let debounceTimer;
function debouncer(callback, delay) {
    clearTimeout(debounceTimer);
    debounceTimer = setTimeout(callback, delay);
}

// Fonction d'aperçu d'image (Open Library)
function updateBookCoverPreview(title) {
    if (!title || title.length < 2) {
        bookCover.style.visibility = 'hidden';
        bookCover.src = '';
        return;
    }
    const query = encodeURIComponent(title.trim());
    const imageUrl = `https://covers.openlibrary.org/b/title/${query}-M.jpg`;

    bookCover.src = imageUrl;
    bookCover.style.visibility = 'visible';
    bookCover.style.display = 'block';

    bookCover.onerror = function () {
        this.src = 'https://via.placeholder.com/150x200.png?text=Image+indisponible';
    };
}

// =============================================================
// 3. LOGIQUE DES MODALES (AJOUT ET ÉDITION)
// =============================================================

// --- AJOUT ---
if (modal && btn) {
    btn.onclick = () => {
        modal.style.display = "block";
        bookCover.style.visibility = 'hidden';
        bookCover.src = '';
    };
    if (span) span.onclick = () => modal.style.display = "none";

    if (bookInput) {
        bookInput.addEventListener('input', () => {
            debouncer(() => updateBookCoverPreview(bookInput.value), 500);
        });
    }
}

// --- MODIFICATION ---
editButtons.forEach(button => {
    button.addEventListener("click", function (e) {
        e.preventDefault(); // On empêche tout comportement bizarre

        console.log("Clic sur modifier pour l'ID : " + this.getAttribute("data-id"));

        document.getElementById("editBookId").value = this.getAttribute("data-id");
        document.getElementById("editNameBook").value = this.getAttribute("data-name");
        document.getElementById("editAuthorFirstName").value = this.getAttribute("data-author-first");
        document.getElementById("editAuthorLastName").value = this.getAttribute("data-author-last");
        document.getElementById("editReleaseDate").value = this.getAttribute("data-date");
        document.getElementById("editPrice").value = this.getAttribute("data-price");
        document.getElementById("editOrderStatus").value = this.getAttribute("data-status");

        editModal.style.display = "block";
    });
});
if (editClose) editClose.onclick = () => editModal.style.display = "none";

// =============================================================
// 4. LOGIQUE DE SUPPRESSION (FIX)
// =============================================================
document.addEventListener('click', function (event) {
    const deleteBtn = event.target.closest('.open-delete-btn');

    if (deleteBtn) {
        const id = deleteBtn.getAttribute('data-id');
        const hiddenInput = document.getElementById("deleteBookId");

        if (id && hiddenInput) {
            // On injecte l'ID dans l'input caché
            hiddenInput.value = id;
            console.log("Succès : ID " + id + " injecté dans le formulaire.");

            // On affiche la modale
            if (deleteModal) {
                deleteModal.style.display = "block";
            }
        } else {
            console.error("Erreur : ID introuvable (data-id) ou élément 'deleteBookId' absent du HTML.");
        }
    }
});

if (deleteClose) deleteClose.onclick = () => deleteModal.style.display = "none";

// =============================================================
// 5. FERMETURE GLOBALE (CLIC EN DEHORS)
// =============================================================
window.onclick = (event) => {
    if (event.target == modal) modal.style.display = "none";
    if (event.target == editModal) editModal.style.display = "none";
    if (event.target == deleteModal) deleteModal.style.display = "none";
};

console.log("--- SCRIPT.JS CHARGÉ ET PRÊT ---");