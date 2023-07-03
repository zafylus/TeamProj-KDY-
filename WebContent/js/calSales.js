const date = new Date();
const year = date.getFullYear();
const month = date.getMonth()+1;

if (month > 12 ) {
    month = 1;
    year+=1;
}
if (month < 1 ) {
    month = 12;
    year-=1;
}
let nowMonth = document.getElementById('fc-dom-1');
const prev_button = document.querySelector('.fc-prev-button');
