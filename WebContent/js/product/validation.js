const name = document.querySelector('input[name="pr_name"]');
const price = document.querySelector('input[name="pr_price"]');
const ma001 = document.querySelector('input[name="ma001"]');
const ma002 = document.querySelector('input[name="ma002"]');
const ma003 = document.querySelector('input[name="ma003"]');
const subbtn = document.getElementById('sumbitbtn');

subbtn.addEventListener('click', check);

function check(e){
    e.preventDefault();
}