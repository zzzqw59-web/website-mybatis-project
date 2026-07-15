const updateFormBtn = document.querySelector("#updateFormBtn");
const boardCancelBtn = document.querySelector("#boardCancelBtnBtn");

updateFormBtn.addEventListener("click", function () {
    const boardNumber = document.querySelector("#boardNumber").value;
    locationProcess(`/board/${boardNumber}/update`); // ?
});

boardCancelBtn.addEventListener("click", function () {
    if (!confirm("게시글을 삭제하시겠습니까?")) {
        return;
    }
    formSubmit("dataForm", "post", "/board/delete");
});