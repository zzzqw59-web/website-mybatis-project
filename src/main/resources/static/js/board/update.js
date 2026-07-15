const updateForm = document.querySelector("#updateForm");

updateForm.addEventListener("submit", function (event) {
    event.preventDefault();

    if (!chkData("#boardTitle", "제목을")) {
        return;
    }

    if (!chkData("#boardContent", "내용을")) {
        return;
    }

    updateForm.submit();
});