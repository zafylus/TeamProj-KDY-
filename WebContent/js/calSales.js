const date = new Date();
const year = date.getFullYear();
const month = date.getMonth()+1;
let nowMonth = document.getElementById('fc-dom-1');

if (month > 12 ) {
    month = 1;
    year+=1;
}
if (month < 1 ) {
    month = 12;
    year-=1;
}

document.querySelector('.fc-prev-button').addEventListener('click', prevSales);

function prevSales(){
    console.log('test');
    alert('test');
    /*month -= 1;
    let yearMonth = year+'-'+month;
    console.log(yearMonth);
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function(){
       let monthSale = this.responseText;
    }
    xhttp.open('GET', 'sales?month='+yearMonth, true);
    xhttp.send();*/
}