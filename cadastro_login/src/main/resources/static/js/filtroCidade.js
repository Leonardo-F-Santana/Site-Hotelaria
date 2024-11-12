const cidadesPorEstado = {
  "1": [
      { id: "1", nome: "Rio de Janeiro" },
      { id: "2", nome: "Cabo Frio" },
      { id: "3", nome: "Paraty" }
  ],
  "2": [
      { id: "4", nome: "Bombinhas" }
  ],
  "3": [
      { id: "5", nome: "Jalapão" }
      { id: "8", nome: "Palmas" }
  ],
  "4": [
      { id: "6", nome: "Maragogi" }
  ],
  "5": [
      { id: "7", nome: "Recife" }
  ]
};

// Função para atualizar as cidades com base no estado selecionado
function filtrarCidade() {
  const estadoSelect = document.getElementById("estado");
  const cidadeSelect = document.getElementById("cidade");
  
  // Limpa as opções anteriores de cidade
  cidadeSelect.innerHTML = '<option value="">Selecione uma Cidade</option>';
  
  // Obtém as cidades correspondentes ao estado selecionado
  const cidades = cidadesPorEstado[estadoSelect.value] || [];
  
  // Popula o dropdown de cidades
  cidades.forEach(cidade => {
      const option = document.createElement("option");
      option.value = cidade.id;
      option.textContent = cidade.nome;
      cidadeSelect.appendChild(option);
  });
}