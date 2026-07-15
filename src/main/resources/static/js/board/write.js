const insertForm = document.querySelector("#insertForm");

insertForm.addEventListener("submit", function (event) {
    event.preventDefault();

    if (!chkData("#boardName", "작성자명을")) return;
    if (!chkData("#boardTitle", "제목을")) return;
    if (!chkData("#boardContent", "내용을")) return;
    if (!chkData("#boardPasswd", "비밀번호를")) return;

    insertForm.submit();
});