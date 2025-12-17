// Fichier : script.js (Version Google Books Optimisée)

console.log("--- SCRIPT.JS DÉMARRAGE ---");

// =============================================================
// 1. VARIABLES POUR LA MODALE D'AJOUT
// =============================================================
const modal = document.getElementById("myModal");
const btn = document.getElementById("openModalBtn");
const span = modal ? modal.querySelector(".close") : null;
const bookInput = modal ? modal.querySelector('input[name="nameBook"]') : null;
const bookCover = document.getElementById('bookCover');

// =============================================================
// 2. VARIABLES POUR LA MODALE DE MODIFICATION (EDIT)
// =============================================================
const editModal = document.getElementById("editModal");
const editClose = document.querySelector(".edit-close");
const editButtons = document.querySelectorAll(".open-edit-btn");

// =============================================================
// 3. FONCTIONS UTILITAIRES & API
// =============================================================

let debounceTimer;
function debouncer(callback, delay) {
    clearTimeout(debounceTimer);
    debounceTimer = setTimeout(callback, delay);
}

// Fonction pour récupérer la couverture via Google Books
function fetchBookCoverGoogle(title, targetImgElement) {
    if (!title || title.length < 3) return;

    console.log(`Recherche Google Books pour : ${title}`);

    fetch(`https://www.googleapis.com/books/v1/volumes?q=intitle:${encodeURIComponent(title)}&maxResults=1`)
        .then(res => res.json())
        .then(data => {
            if (data.items && data.items.length > 0) {
                let imageUrl = data.items[0].volumeInfo.imageLinks?.thumbnail;
                if (imageUrl) {
                    imageUrl = imageUrl.replace("http://", "https://"); // Sécurité HTTPS
                    targetImgElement.src = imageUrl;
                    targetImgElement.style.visibility = 'visible';
                    targetImgElement.style.display = 'block';
                    return;
                }
            }
            // Si rien n'est trouvé
            targetImgElement.style.visibility = 'hidden';
            targetImgElement.src = '';
        })
        .catch(err => console.error("Erreur API Google:", err));
}

// =============================================================
// 4. LOGIQUE DE LA MODALE D'AJOUT
// =============================================================
if (modal && btn) {
    btn.onclick = () => {
        modal.style.display = "block";
        bookCover.style.visibility = 'hidden';
        bookCover.src = '';
    };

    if (span) span.onclick = () => modal.style.display = "none";

    bookInput.addEventListener('input', () => {
        debouncer(() => {
            fetchBookCoverGoogle(bookInput.value, bookCover);
        }, 500);
    });
}

// =============================================================
// 5. LOGIQUE DE LA MODALE DE MODIFICATION (Remplissage auto)
// =============================================================
editButtons.forEach(button => {
    button.addEventListener("click", function () {
        // Récupération des données depuis les attributs th:data du bouton
        const id = this.getAttribute("data-id");
        const name = this.getAttribute("data-name");
        const authorFirst = this.getAttribute("data-author-first");
        const authorLast = this.getAttribute("data-author-last");
        const date = this.getAttribute("data-date");
        const price = this.getAttribute("data-price");
        const status = this.getAttribute("data-status");

        // Remplissage des champs du formulaire de modification
        document.getElementById("editBookId").value = id;
        document.getElementById("editNameBook").value = name;
        document.getElementById("editAuthorFirstName").value = authorFirst;
        document.getElementById("editAuthorLastName").value = authorLast;
        document.getElementById("editReleaseDate").value = date;
        document.getElementById("editPrice").value = price;
        document.getElementById("editOrderStatus").value = status;

        // Afficher la modale
        editModal.style.display = "block";
    });
});

if (editClose) {
    editClose.onclick = () => editModal.style.display = "none";
}

// =============================================================
// 6. GESTION DES MODALES DE SUPPRESSION ET FERMETURE GLOBALE
// =============================================================
const deleteModal = document.getElementById("deleteModal");
const openDeleteBtn = document.getElementById("openDeleteModalBtn");
const deleteClose = document.querySelector(".delete-close");

if (openDeleteBtn) {
    openDeleteBtn.onclick = () => deleteModal.style.display = "block";
}
if (deleteClose) {
    deleteClose.onclick = () => deleteModal.style.display = "none";
}

// Fermeture si on clique en dehors d'une modale
window.onclick = (event) => {
    if (event.target == modal) modal.style.display = "none";
    if (event.target == editModal) editModal.style.display = "none";
    if (event.target == deleteModal) deleteModal.style.display = "none";
};

console.log("--- SCRIPT.JS CHARGÉ ---");