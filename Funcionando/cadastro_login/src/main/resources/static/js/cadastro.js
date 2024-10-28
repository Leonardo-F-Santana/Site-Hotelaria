function verificarSenha() {
  const senha = document.getElementById('password').value;
  const confirmarSenha = document.getElementById('confirmarSenha').value;
  const mensagemErro = document.getElementById('mensagemErro');
  const submitBtn = document.getElementById('submitBtn');

  if (senha !== confirmarSenha) {
      mensagemErro.textContent = "As senhas não são iguais.";
      submitBtn.disabled = true;
  } else {
      mensagemErro.textContent = "";
      submitBtn.disabled = false;
  }
}

