<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

    <%@ include file="../layout/header.jsp" %>

        <div class="container">
            <form>
                <div class="form-group">
                  <label for="email">Username:</label>
                  <input type="text" class="form-control" placeholder="Enter Username" id="username">
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" placeholder="Enter password" id="password">
                </div>

                <div class="form-group">
                    <label for="email">Email address:</label>
                    <input type="email" class="form-control" placeholder="Enter email" id="email">

                </div>

<%--                <div class="form-group form-check">--%>
<%--                  <label class="form-check-label">--%>
<%--                    <input class="form-check-input" type="checkbox"> Remember me--%>
<%--                  </label>--%>
<%--                </div>--%>

              </form>
              <button id="btn-save" class="btn btn-primary">회원가입 완료</button>

        </div>

        <script src = "https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="/js/user.js"></script>
        <%@ include file="../layout/footer.jsp" %>