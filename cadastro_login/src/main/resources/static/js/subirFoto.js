function handleFileUpload(inputId, labelClass) {
    const fileInput = document.getElementById(inputId);
    const fileLabel = document.querySelector(`.${labelClass}`);

    if (fileInput && fileLabel) {
        fileInput.addEventListener("change", (event) => {
            const fileName = event.target.files.length > 0 ? event.target.files[0].name : "Escolher arquivo";
            fileLabel.textContent = fileName;
        });
    }
}