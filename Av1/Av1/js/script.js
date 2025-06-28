document.addEventListener("DOMContentLoaded", () => {

  const loginForm = document.getElementById("loginForm");
  const authStatus = document.getElementById("authStatus");

  const loginSalvo = localStorage.getItem("usuarioLogado");
  if (loginSalvo && authStatus) {
    authStatus.innerHTML = `<a href="cadastro.html"><img src="img/user.png" alt="User" style="height: 30px; border-radius: 50%; vertical-align: middle;"></a> ${loginSalvo}`;
  }

  if (loginForm) {
    loginForm.addEventListener("submit", (e) => {

      const login = document.getElementById("login").value.trim();
      const senha = document.getElementById("senha").value.trim();

      if (login && senha) {
        localStorage.setItem("usuarioLogado", login);
        window.location.href = "index.html";
      } else {
        alert("Por favor, preencha os dois campos.");
      }
    });
  }

  const temaSelect = document.getElementById("tema");
  const form = document.getElementById("cadastroForm");

  if (temaSelect && form) {
    temaSelect.addEventListener("change", () => {
      if (temaSelect.value === "custom") {
        form.querySelectorAll("label").forEach(label => {
          label.style.fontFamily = "Courier New, monospace";
        });
        form.querySelectorAll("input").forEach(input => {
          input.style.backgroundColor = "#eef";
        });
      } else {
        form.querySelectorAll("label").forEach(label => {
          label.style.fontFamily = "";
        });
        form.querySelectorAll("input").forEach(input => {
          input.style.backgroundColor = "";
        });
      }

      document.body.classList.remove("default");
      document.body.classList.add(temaSelect.value);
    });
  }

});
