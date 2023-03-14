let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-delete").on("click", () => {
            this.deleteById();
        });
        $("#btn-update").on("click", () => {
            this.update();
        });
        $("#btn-reply-save").on("click", () => {
            this.replySave();
        });
    },

    save: function () {
        let data = {
            title: $("#title").val(),
            content: editor.getHTML(),
        }



        $.ajax({
            type:"POST",
            url:"/api/board",
            data:JSON.stringify(data), // http body 데이터
            contentType: "application/json; charset=utf-8",
            dataType:"JSON"
        }).done(function (res) {
            alert("등록이 완료되었습니다.")
            location.href = "/blog";
        }).fail(function (err) {
            // alert(JSON.stringify(err));
            // 로그인 페이지로 이동
            alert("로그인 해주세요.");
            location.href = "/auth/loginForm";
        });
    },

    deleteById: function() {
        let id =$("#id").text();

        $.ajax({
            type:"DELETE",
            url:"/api/board"+id,
            dataType:"JSON"
        }).done(function (res) {
            alert("삭제가 완료되었습니다.")
            location.href = "/blog";
        }).fail(function (err) {
            alert(JSON.stringify(data));
        });
    },

    update: function () {
        let id = $("#id").val();
        console.log(id);

        let data = {
            title: $("#title").val(),
            content: editor.getHTML(),
        }

        $.ajax({
            type:"PUT",
            url:"/api/board"+id,
            data:JSON.stringify(data), // http body 데이터
            contentType: "application/json; charset=utf-8",
            dataType:"JSON"
        }).done(function (res) {
            alert("등록이 완료되었습니다.")
            // 절대경로
            location.href = `/board/`+id;
        }).fail(function (err) {
            // alert(JSON.stringify(err));
            // 로그인 페이지로 이동
            alert("로그인 해주세요.");
            location.href = "/auth/loginForm";
        });
    },


    replySave: function ()
        {
        let data = {
            userId: $("#userId").val(),
            boardId: $("#boardId").val(),
            content: $("#reply-content").val()
        }

        console.log(data);

        $.ajax({
            type:"POST",
            url:`/api/board/${data.boardId}/reply`,
            data:JSON.stringify(data), // http body 데이터
            contentType: "application/json; charset=utf-8",
            dataType:"JSON"
        }).done(function (res) {
            alert("등록 완료되었습니다.")
            location.href = `/board/${data.boardId}`;
        }).fail(function (err) {
            // alert(JSON.stringify(err));
            // 로그인 페이지로 이동
            alert("로그인 해주세요.");
            location.href = "/auth/loginForm";
        });
    },

    replyDelete: function (boardId, replyId)
    {
        $.ajax({
            type:"DELETE",
            url:`/api/board/${boardId}/reply/${replyId}`,
            dataType:"JSON"
        }).done(function (res) {
            alert("삭제 완료되었습니다.")
            location.href = "/blog";
        }).fail(function (err) {
            alert(JSON.stringify(err));
        });
    },



}

index.init();