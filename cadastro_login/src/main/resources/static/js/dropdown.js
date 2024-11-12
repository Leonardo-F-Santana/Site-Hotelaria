document.getElementById("dropdownButton").addEventListener("click", function() {
    var menu = document.getElementById("dropdownMenu");
    menu.style.display = menu.style.display === "block" ? "none" : "block";
});

// Fechar o menu ao clicar fora dele
window.onclick = function(event) {
    if (!event.target.matches('.dropdown-button') && !event.target.matches('.arrow')) {
        var menu = document.getElementById("dropdownMenu");
        if (menu.style.display === "block") {
            menu.style.display = "none";
        }
    }
}