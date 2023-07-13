<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="org.json.JSONArray"%>
<%@page import="dto.SalesByDateDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.SalesDAO"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ERP Project</title>
    <script src="js/jquery-3.7.0.js"></script>
    <script src="js/index.global.js"></script>
    <script>
    document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
            headerToolbar: {
                left: '',
                center: 'title',
                end: ''
            },
            locale: 'ko',
        });
        calendar.render();
        var toolbar = document.querySelector('.fc-toolbar');
        var newDiv = document.createElement('div');
        newDiv.classList.add('show_sale_box');
        toolbar.parentNode.insertBefore(newDiv, toolbar.nextSibling);

        var childDiv1 = document.createElement('div');
        var childDiv2 = document.createElement('div');
        childDiv1.classList.add('first_box');
        childDiv2.classList.add('second_box');
        newDiv.appendChild(childDiv1);
        newDiv.appendChild(childDiv2);

        var sale_title_box = document.createElement('div');
        var sale_value_box = document.createElement('div');
        var sale_value = document.createElement('div');
        var won1 = document.createElement('span');

        sale_title_box.classList.add('sale_title_box');
        sale_value_box.classList.add('sale_value_box');
        sale_value.classList.add('sale_value');

        childDiv1.appendChild(sale_title_box);
        childDiv1.appendChild(sale_value_box);
        sale_value_box.appendChild(sale_value);
        sale_value_box.appendChild(won1);

        sale_title_box.innerText = "이번 달 실매출";
        sale_value.innerText = "0";
        won1.innerText = "원";

        var refund_title_box = document.createElement('div');
        var refund_value_box = document.createElement('div');
        var refund_value = document.createElement('div');
        var won2 = document.createElement('span');

        refund_title_box.classList.add('refund_title_box');
        refund_value_box.classList.add('refund_value_box');
        refund_value.classList.add('refund_value');

        childDiv2.appendChild(refund_title_box);
        childDiv2.appendChild(refund_value_box);
        refund_value_box.appendChild(refund_value);
        refund_value_box.appendChild(won2);

        refund_title_box.innerText = "이번 달 총환불";
        refund_value.innerText = "0";
        won2.innerText = "원";

        const sales = document.getElementById('sales');
        let daySales = $('.fc-event-title-container');
        const dialog = document.querySelector('dialog');
        console.log(daySales);
        const date = new Date();
        let year = date.getFullYear();
        let month = date.getMonth() + 1;

        todaySales();
        document.getElementById('prev').addEventListener('click', prevSales);
        document.getElementById('next').addEventListener('click', nextSales);
        document.getElementById('today').addEventListener('click', todaySales);
        daySales.click(showModal);


        function fixDate() {
            if (month > 12) {
                month = 1;
                year += 1;
            }
            if (month < 1) {
                month = 12;
                year -= 1;
            }
        }

        function prevSales() {
            month = month - 1;
            fixDate();
            let yearMonth = year + '-' + ('' + month).padStart(2, "0");
            calendar.prev();
            daySales = $('.fc-event-title-container');
            daySales.click(showModal);
            console.log(yearMonth);
            console.log(daySales);

            $.ajax({
                url: 'sales',
                type: 'post',
                data: { date: yearMonth },
                dataType: 'text',
                success: function(res) {
                    sales.innerText = '이번달 매출: ' + Number(res).toLocaleString();
                }
            });
        }

        function nextSales() {
            month = month + 1;
            fixDate();
            let yearMonth = year + '-' + ('' + month).padStart(2, "0");
            calendar.next();
            daySales = $('.fc-event-title-container');
            daySales.click(showModal);
            console.log(yearMonth);
            console.log(daySales);

            $.ajax({
                url: 'sales',
                type: 'post',
                data: { date: yearMonth },
                dataType: 'text',
                success: function(res) {
                    sales.innerText = '이번달 매출: ' + Number(res).toLocaleString();
                }
            });
        }

        function todaySales() {
            calendar.today();
            year = date.getFullYear();
            month = date.getMonth() + 1;
            const monthTotaltoLocal = sales.dataset.monthTotal.toLocaleString();
            sales.innerText = '이번달 매출: ' + monthTotaltoLocal;
        }

        function showModal(e) {
            let jq_et = null;
            if (e.target.className == 'fc-event-title fc-sticky') {
                jq_et = $(e.target).parent();
            } else {
                jq_et = $(e.target);
            }
            console.log(jq_et);
            let date = jq_et.parent().parent().parent().parent().parent().parent().parent()[0].dataset.date;
            console.log(`showModal: ${date}`);
            dialog.showModal();

            $.ajax({
                url: 'eachProdSales?date=' + date,
                type: 'get',
                dataType: 'text',
                success: function(res) {
                    const jo = JSON.parse(res);
                    console.log(jo);
                    const prodstat = $('#prodstat');
                    let htmlString = '';
                    for (let i = 0; i < jo.length; i++) {
                        htmlString +=
                            '<tr><td>' + (i + 1) + '</td><td><span>' + jo[i].pr_name + '</span></td><td>' +
                            jo[i].amount + '</td>' + '<td>' + jo[i].sales + '</td><tr>';
                    }
                    console.log(htmlString);
                    prodstat.html(htmlString);
                }
            });
        }
    });
    </script>
   
</head>
 <link href="css/style2.css" rel="stylesheet">
<body>
    <dialog>
        <h2>매출순위</h2>
        <table>
            <thead>
                <tr>
                    <th>순위</th>
                    <th>제품</th>
                    <th>판매량</th>
                    <th>총매출</th>
                </tr>
            </thead>
            <tbody id="prodstat">
            </tbody>
        </table>
        <form method="dialog">
            <button>Close</button>
        </form>
    </dialog>
    <div id = "wrapper">
        <div id="header">
            <h1>ERP</h1> 
        </div>
        <div id="nav">
            <h2>
                <a href="sales">매출</a> 
                <a href="">지출</a>
                <a href="">재고</a>
                <a href="">직원</a>
                <a href="index.html">홈으로</a>
            </h2>
        </div>
        <div id="sidebar">
            <div class = "dtlmenu">조 회</div>
        </div>
        <div id="section">
            
            <div>
                <span id="sales">이번달 매출 : </span>
                <span id="button">
                   <button id="prev"><</button> 
                   <button id="today">today</button>
                   <button id="next">></button> 
                </span>
            </div>
            <div style="width:900px; height:900px;">
            <div id="calendar"></div>
            </div>
        </div>
    </div>
</body>
</html>