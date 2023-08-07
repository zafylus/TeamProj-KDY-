const card = document.getElementById('card');
const list = document.getElementById('list');

card.addEventListener('click', () => location.href = "product?uri=card");
list.addEventListener('click', () => location.href = "product?uri=list");