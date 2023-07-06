document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        locale: 'ko',
        events: ${sales},
        header: {
            start: 'title',
            center: '',
            end: ''
        }
    });
calendar.render();

const sales = document.getElementById('sales');
const date = new Date();
let year = date.getFullYear();
let month = date.getMonth()+1;

sales.innerText = `이번달 매출 : ${monthTotal}`;
document.getElementById('prev').addEventListener('click', prevSales);
document.getElementById('next').addEventListener('click', nextSales);

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
    month = month-1;
    fixDate();
    let yearMonth = year+'-'+(''+month).padStart(2, "0");
    console.log(yearMonth);
    calendar.prev();

    $.ajax({
        url: 'sales',
        type: 'post',
        data: {date: yearMonth},
        dataType: 'text',
        success: function(res){
            sales.innerText = '이번달 매출 :' + res;
        }
    });
}

function nextSales(){
    month = month+1;
    fixDate();
    let yearMonth = year+'-'+(''+month).padStart(2, "0");
    console.log(yearMonth);
    calendar.next();

    $.ajax({
        url: 'sales',
        type: 'post',
        data: {date: yearMonth},
        dataType: 'text',
        success: function(res){
            sales.innerText = '이번달 매출 :' + res;
        }
    });
}
});