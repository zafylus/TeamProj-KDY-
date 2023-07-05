const date = new Date();
const year = date.getFullYear();
const month = date.getMonth()+1;
let nowMonth = document.getElementById('fc-dom-1');

const prev_Btn = document.getElementById('prev');
prev_Btn.addEventListener('click', prevTest);



function prevTest(){
    // calendar.prev();
    console.log('test');
}

function fixDate(){
    if (month > 12 ) {
        month = 1;
        year+=1;
    }
    if (month < 1 ) {
        month = 12;
        year-=1;
    }
}
function prevSales(){
    month -= 1;
    fixDate();
    let yearMonth = year+'-'+month;
    console.log(yearMonth);
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function(){
    let monthSale = this.responseText;
    }
    xhttp.open('GET', 'sales?month='+yearMonth, true);
    xhttp.send();
}